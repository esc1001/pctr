package pg03.c01;

public class Parque {

    int accesos;
    int accesosA;
    int accesosB;
    double mediaActual;
    long ultimoAcceso;

    public static enum Puertas {A,B}

    public Parque() {
        accesos = 0;
        accesosA = 0;
        accesosB = 0;
        mediaActual = 0.0d;
        ultimoAcceso = System.currentTimeMillis();
    }

    // Calculo de media stateless
    private double calculaMedia(double previa, int nPrevio, long valor) {
        return (previa*nPrevio + valor) / (nPrevio + 1);
    }

    public synchronized void accede(Puertas puerta) {
        long ahora = System.currentTimeMillis();
        long tAcceso = ahora - ultimoAcceso;
        ultimoAcceso = ahora;
        System.out.println("Nuevo acceso por puerta: " + puerta);
        int prev = accesos;
        mediaActual = calculaMedia(mediaActual, prev, tAcceso);
        System.out.println("\tTiempo medio de acceso: " + (mediaActual/1000) + "sg");
        accesos++;
        System.out.println("\tTotal de accesos: " + accesos);
        if ( puerta == Puertas.A ) {
            accesosA++;
        }
        System.out.println("\tTotal de accesos por puerta A: " + accesosA);
        if ( puerta == Puertas.B ) {
            accesosB++;
        }
        System.out.println("\tTotal de accesos por puerta B: " + accesosB);
        //assert accesos == prev+1: "INV:";
        assert accesos == (accesosA + accesosB): "INV: "+accesos+"=="+accesosA+"+"+accesosB;
    }

    public int getAccesos() {
        return this.accesos;
    }

    public static void main(String[] args) {
        Parque p = new Parque();
        Puerta pA = new Puerta(Puertas.A, p);
        Puerta pB = new Puerta(Puertas.B, p);
        new Thread(pA).start();
        new Thread(pB).start();
    }
}