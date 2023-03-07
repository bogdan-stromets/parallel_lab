
public class Main {
    public static void main(String[] args) {
        int cntThreads = 5;  // threads num
        int step = 4;
        int timeToBreak = 5; // in seconds

        Thread [] myThreads = new Thread[cntThreads];
        Breaker  breaker = new Breaker(timeToBreak);

        for (int i = 0; i < cntThreads; i++)
        {
            myThreads[i] = new Calc(step,i + 1,breaker);
            myThreads[i].start();
        }
        new Thread(breaker).start();

    }
}