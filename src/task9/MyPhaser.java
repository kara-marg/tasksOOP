package task9;

public class MyPhaser {
    private int phase;
    private int parties;
    private int arrived;


    public MyPhaser(int parties) {
        this.parties = parties;
        this.arrived=0;
    }

    int register(){
        arrived++;
        return phase;
    }

    int arrive(){
        arrived--;
        int currentPhase = phase;
        synchronized (this){
            if(arrived == 0){
                notifyAll();
                arrived = parties;
                phase = currentPhase + 1;
            }
        }
        return phase;
    }

    int arriveAndAwaitAdvance(){
        arrived--;
        int currentPhase = phase;
        synchronized (this){
            while (arrived > 0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        arrived = parties;
        phase = currentPhase + 1;
        synchronized (this){
            notifyAll();
        }
        return phase;
    }

    int arriveAndDeregister(){
        --arrived;
        --parties;
        int currentPhase = phase;
        synchronized (this){
            if(arrived == 0){
                notifyAll();
                phase = currentPhase + 1;
                arrived = parties;
                return -1;
            }
        }
        return phase + 1;
    }

    public int getPhase() {
        return phase;
    }
}
