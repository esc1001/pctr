package pg01.c02;

import java.util.concurrent.TimeUnit;

public class HiloO implements Runnable {

    @Override
    public void run() {
        try {
            for ( int i = 0; i < 100; i++ ) {
                System.out.print("O");
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.err.println("Interrumpido: "+ e.getMessage());
        }
    }
    
}