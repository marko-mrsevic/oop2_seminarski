import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Potrosac extends Thread {

    private Buffer buffer;
    private int brojProizvoda;

    public Potrosac(Buffer b, int br) {
        this.buffer = b;
        this.brojProizvoda = br;
    }


    public void run() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("proizvodi.txt"))) {
            for (int i = 0; i < brojProizvoda; i++) {
                Proizvod p = buffer.uzmi();
                pw.println(p.getNaziv() + " " + p.getCijena());
            }
        } catch (IOException e) {
            System.out.println("***** Greska pri upisu u datoteku: " + e.getMessage());
        }
    }

}
