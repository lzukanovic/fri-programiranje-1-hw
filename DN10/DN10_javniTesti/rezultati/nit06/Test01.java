
public class Test01 {

    public static void main(String[] args) {
        Oddaja.Risar risar = new Oddaja.Risar();
        Oddaja.Lik p = new Oddaja.Pravokotnik(3, 1, 4, 5);
        risar.narisiLik(p);
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
