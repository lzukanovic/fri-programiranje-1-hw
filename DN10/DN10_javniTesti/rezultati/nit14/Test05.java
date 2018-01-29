
public class Test05 {

    public static void main(String[] args) {
        // trikotnik s to"ckami (0, 0), (20, 0), (0, 10)
        Oddaja.Lik trikotnik = new Oddaja.Mnogokotnik(
            new int[][]{
                {-1,  0,   0},
                { 0, -1,   0},
                { 1,  2, -20}
            }
        );

        // petkotnik s to"ckami (15, 15), (21, 18), (18, 21), (12, 21), (9, 18)
        Oddaja.Lik petkotnik = new Oddaja.Mnogokotnik(
            new int[][]{
                {  1, -2,  15},
                {  1,  1, -39},
                {  0,  1, -21},
                { -1,  1,  -9},
                { -1, -2,  45}
            }
        );

        Oddaja.Risar risar = new Oddaja.Risar();
        risar.narisiLik(trikotnik);
        risar.narisiLik(petkotnik);

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
