import java.util.concurrent.Semaphore;

 public class Manager {
    Fork[] forks = new Fork[5];
    Philosopher[] philosophers = new Philosopher[5];
    public Manager()
    {
        Starter();
    }
    private void Starter()
    {
        for(int i = 0; i < 5; i++)
            forks[i] = new Fork(i+1);
        Semaphore permits = new Semaphore(2);
        for(int i = 0; i < 5; i++) {
            philosophers[i] = new Philosopher(i + 1,forks[i],forks[(i + 1) % forks.length],permits);
            philosophers[i].start();
        }
    }
}
