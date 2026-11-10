public class Proizvod {
    private String naziv;
    private double cijena;

    public Proizvod(String n, double c) {
        this.naziv = n;
        this.cijena = c;
    }

    public String getNaziv() {
        return this.naziv;
    }
    public double getCijena() {
        return this.cijena;
    }
}
