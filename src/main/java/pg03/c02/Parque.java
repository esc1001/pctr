package pg03.c02;

import java.util.HashMap;
import java.util.Map;

public class Parque {

    int accesos;
    int numPuertas;
    Map<Character, Integer> accesosPuerta;
    double mediaActual;
    long ultimoAcceso;

    public Parque(int numPuertas) {
        accesos = 0;
        this.numPuertas = numPuertas;
        accesosPuerta = new HashMap<>();
        char key = 'A';
        // Initialize door access
        for (int i = 0; i < numPuertas; i++) {
            accesosPuerta.put(key, 0);
            key++;
        }
        mediaActual = 0.0d;
        ultimoAcceso = System.currentTimeMillis();
    }

    // Calculo de media stateless
    private double calculaMedia(double previa, int nPrevio, long valor) {
        return (previa*nPrevio + valor) / (nPrevio + 1);
    }

    public synchronized void accede(char puerta) {
        long ahora = System.currentTimeMillis();
        long tAcceso = ahora - ultimoAcceso;
        ultimoAcceso = ahora;
        System.out.println("Nuevo acceso por puerta: " + puerta);
        int prev = accesos;
        mediaActual = calculaMedia(mediaActual, prev, tAcceso);
        System.out.println("\tTiempo medio de acceso: " + (mediaActual/1000) + "sg");
        accesos++;
        System.out.println("\tTotal de accesos: " + accesos);
        int pAcceso = accesosPuerta.get(puerta);
        pAcceso++;
        accesosPuerta.put(puerta, pAcceso);
        // Show access data
        accesosPuerta.forEach((k, v) -> System.out.println(("\t\tTotal de accesos por puerta "+k + ":" + v)));
        //assert accesos == prev+1: "INV:";
        //assert accesos == (accesosA + accesosB): "INV: "+accesos+"=="+accesosA+"+"+accesosB;
        assert accesos == accesosPuerta.values().stream().reduce(0, Integer::sum): "VIOLACIÓN DE INVARIANTE";
    }

    public int getAccesos() {
        return this.accesos;
    }

    public static void main(String[] args) {
        int N = 10;
        Parque p = new Parque(N);
        char key = 'A';
        // Initialize door access
        for (int i = 0; i < N; i++) {
            new Thread(new Puerta(key,p)).start();
            key++;
        }
    }
}