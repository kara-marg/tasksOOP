package task7;

import java.util.concurrent.CyclicBarrier;

public class MyCyclicBarrier {
    private final int parties;
    private Runnable barrierAction;
    private volatile int numberOfWaiter;

    public MyCyclicBarrier(int parties) {
        this.parties = parties;
        this.numberOfWaiter = 0;
        this.barrierAction = null;
    }

    public MyCyclicBarrier(int parties, Runnable barrierAction) {
        this(parties);
        this.barrierAction = barrierAction;

    }


    public synchronized void await() throws InterruptedException {
        numberOfWaiter++;
        if (numberOfWaiter == parties) {
            numberOfWaiter = 0;
            notifyAll();
            if (barrierAction != null) {
                barrierAction.run();
            }
        } else {
            wait();
        }
    }

    public int getParties() {
        return parties;
    }

    public int getNumberOfWaiter() {
        return numberOfWaiter;
    }

}
