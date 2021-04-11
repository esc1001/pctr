package pg01.c02;

import java.util.concurrent.TimeUnit;

public class HiloX implements Runnable {

    @Override
    public void run() {
        try {
            for ( int i = 0; i < 100; i++ ) {
                System.out.print("X");
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.err.println("Interrumpido: "+ e.getMessage());
        }
    }
    
}