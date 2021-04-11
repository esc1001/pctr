package pg01.c02;

import java.util.concurrent.TimeUnit;

public class HiloG implements Runnable {

    @Override
    public void run() {
        try {
            for ( int i = 0; i < 100; i++ ) {
                System.out.print("-");
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.err.println("Interrumpido: "+ e.getMessage());
        }
    }
    
}