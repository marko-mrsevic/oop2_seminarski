public class Proizvodjac extends Thread {

    private Buffer buffer;
    private Proizvod[] proizvodi;

    public Proizvodjac(Buffer b, Proizvod[] p) {
        this.buffer = b;
        this.proizvodi = p;
    }

    public void run() {
        for (int i = 0; i < proizvodi.length; i++) {
            buffer.dodaj(proizvodi[i]);
            System.out.println("***** Proizvodjac ucitao: " + proizvodi[i].getNaziv()
                + ", cijena: " + proizvodi[i].getCijena());
        }
    }
}