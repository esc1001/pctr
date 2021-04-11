package pg01.c03;

import java.util.concurrent.TimeUnit;

public class HiloX implements Runnable {

    private char c;
    private int sleep;
    private int repeats;

    public HiloX(char c, int sleep, int repeats) {
        this.c = c;
        this.sleep = sleep;
        this.repeats = repeats;
    }

    @Override
    public void run() {
        try {
            for ( int i = 0; i < repeats; i++ ) {
                System.out.print(c);
                TimeUnit.MILLISECONDS.sleep(sleep);
            }
        } catch (InterruptedException e) {
            System.err.println("Interrumpido: "+ e.getMessage());
        }
    }
    
}