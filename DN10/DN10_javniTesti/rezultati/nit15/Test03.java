
public class Test03 {

    public static void main(String[] args) {
        Oddaja.Risar risar = new Oddaja.Risar();
        risar.narisiLik(new Oddaja.Elipsa(9, 10, 6, 8));
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
