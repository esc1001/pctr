package pg01.c03;

public class App {
    public static void main(String[] args) throws InterruptedException {
        HiloX hx = new HiloX('X',100,100);
        HiloX ho = new HiloX('O',100,100);
        HiloX hg = new HiloX('-',100,100);
        Thread tx = new Thread(hx);
        tx.setPriority(Thread.MAX_PRIORITY);
        tx.start();
        Thread to = new Thread(ho);
        to.setPriority(Thread.NORM_PRIORITY);
        to.start();
        Thread tg = new Thread(hg);
        tg.setPriority(Thread.MIN_PRIORITY);
        tg.start();
        tx.join();
        to.join();
        tg.join();
    }
}