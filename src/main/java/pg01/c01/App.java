package pg01.c01;

public class App {
    public static void main(String[] args) {
        HiloX hx = new HiloX();
        HiloO ho = new HiloO();
        HiloG hg = new HiloG();
        new Thread(hx).start();
        new Thread(ho).start();
        new Thread(hg).start();
    }
}