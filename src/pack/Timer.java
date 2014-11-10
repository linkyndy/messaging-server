package pack;

import java.util.concurrent.TimeUnit;

public class Timer implements Runnable {
    private int LIMIT;

    public Timer(int limit) {
        this.LIMIT = limit;
    }

    public void run() {
        for (int i = 0; i < this.LIMIT; i++) {
             try {
                TimeUnit.MINUTES.sleep(1);
                this.LIMIT = this.LIMIT--;
             } catch (InterruptedException e) {
                System.exit(1);
            }
        }
    }

    public int getCurrentLimit() {
        return this.LIMIT;
    }
}
