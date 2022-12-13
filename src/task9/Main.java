package task9;
import java.util.ArrayList;
import java.util.concurrent.Phaser;

public class Main {
    public static void main(String args[]) {
        Phaser phsr = new Phaser(1);
        int curPhase;

        System.out.println("Start");

        new MyThread(phsr, "A");
        new MyThread(phsr, "B");
        new MyThread(phsr, "C");

        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " end");

        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " end");

        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " end");

        phsr.arriveAndDeregister();

        if(phsr.isTerminated()) {
            System.out.println("END");
        }
    }
}


class MyThread implements Runnable {
    Phaser phsr;
    String name;

    MyThread(Phaser p, String n) {
        phsr = p;
        name = n;
        phsr.register();
        new Thread(this).start();
    }

    public void run() {

        System.out.println("Thread " + name + " begin first phase");
        phsr.arriveAndAwaitAdvance();


        try {
            Thread.sleep(10);
        } catch(InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " begin second phase");
        phsr.arriveAndAwaitAdvance();


        try {
            Thread.sleep(10);
        } catch(InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " begin third phase");

        phsr.arriveAndDeregister();
    }
}