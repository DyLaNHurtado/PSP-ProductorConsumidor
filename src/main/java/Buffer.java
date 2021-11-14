public class Buffer {

    private int numSlots = 0;
    private double[] buffer = null;
    private int putIn = 0, takeOut = 0;
    private int cont = 0;

    public Buffer(int numSlots) {
        this.numSlots = numSlots;
        buffer = new double[numSlots];
    }

    public synchronized double get(int id) {
        double value;
        while (cont == 0) {//Buffer vacio
            try {
                System.out.println("Consumidor " + id + " -> No puedo tomar nada y me duermo");
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }

        }
        value = buffer[takeOut];
        takeOut = (takeOut + 1) % numSlots;
        cont--;
        System.out.println("\t Tamaño de buffer: "+cont+"\n");
        notifyAll();
        return value;
    }

    public synchronized void put(double value, int id) {
        while (cont == numSlots) { //Buffer lleno
            try {
                System.out.println("Productor " + id + " se duerme -> Buffer lleno");
                wait();
            } catch (InterruptedException e) {
                System.err.println("Productor " + id + " : Error en put -> " + e.getMessage());
            }
        }

        buffer[putIn]=value;
        putIn= (putIn + 1) % numSlots;
        cont++;
        System.out.println("\t Tamaño de buffer: " + cont+"\n");
        notifyAll();

    }
}
