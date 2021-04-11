package pg01.c01;

public class HiloO implements Runnable {

    @Override
    public void run() {
        for ( int i = 0; i < 100; i++ ) {
            System.out.print("O");
        }
    }
    
}