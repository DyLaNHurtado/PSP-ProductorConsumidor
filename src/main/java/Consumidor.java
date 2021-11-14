public class Consumidor extends Thread {

    private int id;
    private  Buffer buffer;

    public Consumidor(int id, Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(Boolean.TRUE){
            System.out.println("Consumidor " + id + " consume -> " + buffer.get(id) );
        }

    }
}
