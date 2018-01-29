
public class Test09 {

    public static void main(String[] args) {
        Oddaja.Risar risar = new Oddaja.Risar();

        Oddaja.Lik elipsa1 = new Oddaja.Elipsa(7, 5, 6, 4);
        Oddaja.Lik elipsa2 = new Oddaja.Elipsa(22, 5, 6, 4);

        // trikotnik z ogli"s"ci (2, 29), (26, 29), (14, 8)
        Oddaja.Lik trikotnik = new Oddaja.Mnogokotnik(
            new int[][]{
                {  0,  1, -29 },
                {  7, -4, -66 },
                { -7, -4, 130 }
            }
        );

        risar.narisiLik(elipsa1);
        risar.narisiRob(elipsa2, 3);
        risar.narisiRob(trikotnik, 4);

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
