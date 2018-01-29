
public class Test08 {

    public static void main(String[] args) {

        Oddaja.Risar risar = new Oddaja.Risar();

        Oddaja.Lik pravokotnik = new Oddaja.Pravokotnik(5, 73, 12, 19);
        risar.narisiRob(pravokotnik, 1);

        Oddaja.Lik elipsa = new Oddaja.Elipsa(70, 75, 15, 20);
        risar.narisiRob(elipsa, 1);

        // "sestkotnik z ogli"s"ci (50, 10), (65, 20), (65, 40), (50, 50),
        // (35, 40), (35, 20)
        Oddaja.Lik sestkotnik = new Oddaja.Mnogokotnik(
            new int[][]{
                { 2, -3,  -70},
                { 1,  0,  -65},
                { 2,  3, -250},
                {-2,  3,  -50},
                {-1,  0,   35},
                {-2, -3,  130}
            }
        );
        risar.narisiRob(sestkotnik, 1);

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
