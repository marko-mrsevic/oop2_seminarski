//--------------- Seminarski 1 OOP2 ---------------
// Marko Mrsevic RT-3/24
// Marko Jakovljevic RT-6/24



public class main {
    public static void main(String[] args) throws InterruptedException {

        Buffer buffer = new Buffer();

        Proizvod[] proizvodi = {
            new Proizvod("Hljeb", 60.0),
            new Proizvod("Mlijeko", 150.0),
            new Proizvod("Jaja", 22.0),
            new Proizvod("Sir", 480.0),
            new Proizvod("Jabuke", 130.0),
            new Proizvod("Kafa", 350.0),
            new Proizvod("Secer", 120.0),
            new Proizvod("Ulje", 260.0)
        };

        Proizvodjac proizvodjac = new Proizvodjac(buffer, proizvodi);
        Potrosac potrosac = new Potrosac(buffer, proizvodi.length);

        proizvodjac.start();
        potrosac.start();

        proizvodjac.join();
        potrosac.join();
    }
}