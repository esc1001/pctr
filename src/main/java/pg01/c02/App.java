package pg01.c02;

public class App {
    public static void main(String[] args) throws InterruptedException {
        HiloX hx = new HiloX();
        HiloO ho = new HiloO();
        HiloG hg = new HiloG();
        Thread tx = new Thread(hx);
        tx.start();
        Thread to = new Thread(ho);
        to.start();
        Thread tg = new Thread(hg);
        tg.start();
        tx.join();
        to.join();
        tg.join();
        System.out.println("Finalizado.");
    }
}