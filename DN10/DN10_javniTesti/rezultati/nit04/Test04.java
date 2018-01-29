
public class Test04 {

    public static void main(String[] args) {
        Oddaja.Risar risar = new Oddaja.Risar();
        risar.narisiLik(new Oddaja.Elipsa(5, 5, 5, 5));
        risar.narisiLik(new Oddaja.Elipsa(49, 49, 49, 33));
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
