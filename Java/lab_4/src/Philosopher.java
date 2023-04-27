import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher extends Thread{
    int id;
    Fork leftFork;
    Fork rightFork;
    Semaphore permits;

    public Philosopher(int id,Fork leftFork, Fork rightFork,Semaphore permits)
    {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.permits = permits;
    }

    @Override
    public void run()
    {
        //Random rand = new Random();
        for(int i = 0; i < 10; i++) {
            try {
                permits.acquire();
                System.out.println("Philosopher: " + id + " Thinking " + (i + 1) + " times");
                leftFork.GetSem().acquire();
                System.out.println("Philosopher: " + id + " Took left fork " + (i + 1) + " times");
                rightFork.GetSem().acquire();
                System.out.println("Philosopher: " + id + " Took right fork " + (i + 1) + " times");

                System.out.println("Philosopher: " + id + " Eating " + (i + 1) + " times");

                rightFork.GetSem().release();
                System.out.println("Philosopher: " + id + " Put right fork " + (i + 1) + " times");
                leftFork.GetSem().release();
                System.out.println("Philosopher: " + id + " Put left fork " + (i + 1) + " times");

                permits.release();

                //Thread.sleep(Math.abs(rand.nextInt(5)) * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
