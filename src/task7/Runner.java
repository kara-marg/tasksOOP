package task7;

public class Runner  implements Runnable {

    private final String name;
    private final MyCyclicBarrier myCyclicBarrier;
    private long time;

    public Runner(String name, MyCyclicBarrier myCyclicBarrier) {
        this.myCyclicBarrier = myCyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Runner " + name + " is ready to start");
        try {
            myCyclicBarrier.await();
            while ((int) (Math.random() * 4) != 0) {
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Runner " + name + " come to finish");

    }
}


