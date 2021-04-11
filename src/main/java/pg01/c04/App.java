package pg01.c04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws InterruptedException {
        HiloX hx = new HiloX('X',100,100);
        HiloX ho = new HiloX('O',100,100);
        HiloX hg = new HiloX('-',100,100);
        
        //ExecutorService exec = Executors.newCachedThreadPool();
        //ExecutorService exec = Executors.newFixedThreadPool(10);
        //ExecutorService exec = Executors.newSingleThreadExecutor();
        ExecutorService exec = Executors.newFixedThreadPool(3);
        
        Thread tx = new Thread(hx);
        Thread to = new Thread(ho);
        Thread tg = new Thread(hg);
        exec.execute(tx);
        exec.execute(to);
        exec.execute(tg);
        exec.shutdown();
    }
}