public class Main {
    private static Buffer monitor;
    private static Thread[] consumidores;
    private static Thread productor;
    private final static int MAX_CONSUMIDORES = 5;
    private final static int NUM_SLOTS_BUFFER = 4;

    public static void main(String[] args){
        monitor = new Buffer(NUM_SLOTS_BUFFER);
        consumidores = new Thread[MAX_CONSUMIDORES];
        productor = new Productor(1,monitor);
        productor.start();


        for (int i = 0; i < MAX_CONSUMIDORES; i++) {
            consumidores[i]=new Thread(new Consumidor(i,monitor));
            consumidores[i].start();
        }

    }

}
