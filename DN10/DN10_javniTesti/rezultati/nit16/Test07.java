
public class Test07 {

    public static void main(String[] args) {

        Oddaja.Risar risar = new Oddaja.Risar();

        // razlika kvadrata z ogli"s"ci (50, 20), (70, 40), (50, 60), (30, 40)
        // in kroga s sredi"s"cem (50, 40) in polmerom 10
        Oddaja.Lik kvadrat = new Oddaja.Mnogokotnik(
            new int[][]{
                { 1, -1,  -30},
                { 1,  1, -110},
                {-1,  1,  -10},
                {-1, -1,   70}
            }
        );
        Oddaja.Lik krog = new Oddaja.Elipsa(50, 40, 10, 10);
        risar.narisiLik(new Oddaja.Razlika(kvadrat, krog));

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
