
public class Test02 {

    public static void main(String[] args) {
        Oddaja.Risar risar = new Oddaja.Risar();
        risar.narisiLik(new Oddaja.Pravokotnik(0, 0, 100, 1));
        risar.narisiLik(new Oddaja.Pravokotnik(0, 0, 1, 100));
        risar.narisiLik(new Oddaja.Pravokotnik(99, 0, 1, 100));
        risar.narisiLik(new Oddaja.Pravokotnik(0, 99, 100, 1));
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
