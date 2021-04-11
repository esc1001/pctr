package pg03.c01;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Puerta implements Runnable {

    private Parque.Puertas tipo;
    private Parque parque;

    private static long MAX_SLEEP = 1000;

    public Puerta(Parque.Puertas tipo, Parque parque) {
        this.tipo = tipo;
        this.parque = parque;
    }

    @Override
    public void run() {
        Random r = new Random();
        long nextSleep;
        while (parque.getAccesos() < 100) {
            try {
                parque.accede(tipo);
                nextSleep = Math.round(r.nextFloat()*MAX_SLEEP); // Calculo un número entre 0 y MAX_SLEEP en base a distribución uniforme.
                TimeUnit.MILLISECONDS.sleep(nextSleep);
            } catch (InterruptedException e) {
                System.out.println("Proceso interrumpido antes de tiempo: " + e.getMessage());
            }
        }
        System.out.println("Finalizado entrada por puerta "+tipo);
    }

    

}