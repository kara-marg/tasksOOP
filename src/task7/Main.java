package task7;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyCyclicBarrier myCyclicBarrier = new MyCyclicBarrier(3, () -> System.out.println("START"));
        Runner runner1 = new Runner("Bob", myCyclicBarrier);
        Runner runner2 = new Runner("Tom", myCyclicBarrier);
        Runner runner3 = new Runner("Mark", myCyclicBarrier);
        Thread[] threads = {
                new Thread(runner1),
                new Thread(runner2),
                new Thread(runner3)
        };
        for (Thread thread : threads) {
            thread.start();
            Thread.sleep(2000);
        }

    }
}

