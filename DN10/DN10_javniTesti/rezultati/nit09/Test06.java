
public class Test06 {

    public static void main(String[] args) {

        Oddaja.Risar risar = new Oddaja.Risar();

        // presek pravokotnika z ogli"s"ci (0, 0), (40, 0), (0, 20), (40, 20)
        // in elipse s sredi"s"cem (40, 10) ter polosema 20 in 10
        Oddaja.Lik pravokotnik = new Oddaja.Pravokotnik(0, 0, 40, 20);
        Oddaja.Lik elipsa = new Oddaja.Elipsa(40, 10, 20, 10);
        risar.narisiLik(new Oddaja.Presek(pravokotnik, elipsa));

        prikazi(risar.slika());
    }

    private static void prikazi(boolean[][] slika) {
        for (int i = 0;  i < slika.length;  i++) {
            for (int j = 0;  j < slika[i].length;  j++) {
                System.out.print(slika[i][j] ? "* " : "- ");
            }
            System.out.println();
        }
    }
}
