import java.util.Random;

public class Productor extends Thread {

    private int id;
    private Random random;
    private Buffer buffer;
    private final int TIEMPOESPERA = 1500;

    public Productor(int id, Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
        random = new Random();
    }


    @Override
    public void run() {
        double item = 0.0;
        while (true) {
            try {
                Thread.sleep(TIEMPOESPERA);

                buffer.put(++item, id);
                System.out.println("Productor " + id + " -> produciendo -> " + item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
