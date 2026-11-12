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
                e.printStackTrace();
            }            
        }
        proizvodi.add(p);
        System.out.println("***** Proizvodjac ucitao: " + p.getNaziv()
                + ", cijena: " + p.getCijena());
        notifyAll();
    }
    public synchronized Proizvod uzmi() {
        while (proizvodi.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Proizvod p = proizvodi.removeFirst();
        System.out.println("***** Potrosac preuzeo: " + p.getNaziv()
                        + ", cijena: " + p.getCijena());
        notifyAll();
        return p;
    }
}
