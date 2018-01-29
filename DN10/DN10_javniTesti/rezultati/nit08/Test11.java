
public class Test11 {

    public static void main(String[] args) {
        Oddaja.Risar risar = new Oddaja.Risar();

        Oddaja.Lik lik = new Oddaja.Razlika(
            new Oddaja.Elipsa(41, 49, 39, 36),
            new Oddaja.Mnogokotnik(new int[][]{{-20, 53, -3795}, {-9, -10, 831}, {83, 17, -6761}})
        );

        risar.narisiRob(lik, 8);

        narisi(risar.slika());
    }

    private static void narisi(boolean[][] slika) {
        for (int i = 0;  i < slika.length;  i++) {
            for (int j = 0;  j < slika[i].length;  j++) {
                System.out.print(slika[i][j] ? "* " : "- ");
            }
            System.out.println();
        }
    }
}
