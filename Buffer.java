import java.util.LinkedList;
public class Buffer {
    private LinkedList<Proizvod> proizvodi;

    public Buffer() {
        this.proizvodi = new LinkedList<Proizvod>();
    }

    public synchronized void dodaj(Proizvod p) {
        while (proizvodi.size() > 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }            
        }
        proizvodi.add(p);
        notifyAll();
    }
    public synchronized Proizvod uzmi() {
        while (proizvodi.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        Proizvod p = proizvodi.removeFirst();
        notifyAll();
        return p;
    }
}
