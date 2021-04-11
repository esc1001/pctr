package pg03.c02;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Puerta implements Runnable {

    private char name;
    private Parque parque;

    private static long MAX_SLEEP = 3000;

    public Puerta(char name, Parque parque) {
        this.name = name;
        this.parque = parque;
    }

    @Override
    public void run() {
        Random r = new Random();
        long nextSleep;
        while (parque.getAccesos() < 50) {
            try {
                parque.accede(name);
                nextSleep = Math.round(r.nextFloat()*MAX_SLEEP); // Calculo un número entre 0 y MAX_SLEEP en base a distribución uniforme.
                TimeUnit.MILLISECONDS.sleep(nextSleep);
            } catch (InterruptedException e) {
                System.out.println("Proceso interrumpido antes de tiempo: " + e.getMessage());
            }
        }
        System.out.println("Finalizado entrada por puerta "+name);
    }

    

}