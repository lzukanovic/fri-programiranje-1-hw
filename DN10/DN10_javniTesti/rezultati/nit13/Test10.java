
public class Test10 {

    public static void main(String[] args) {

        Oddaja.Risar risar = new Oddaja.Risar();

        Oddaja.Lik okvir = new Oddaja.Pravokotnik(0, 0, 100, 100);

        Oddaja.Lik e1 = new Oddaja.Elipsa(35, 35, 30, 30);
        Oddaja.Lik e2 = new Oddaja.Elipsa(65, 35, 30, 30);
        Oddaja.Lik e3 = new Oddaja.Elipsa(50, 65, 30, 30);

        Oddaja.Lik e12 = new Oddaja.Presek(e1, e2);
        Oddaja.Lik e13 = new Oddaja.Presek(e1, e3);
        Oddaja.Lik e23 = new Oddaja.Presek(e2, e3);

        risar.narisiRob(okvir, 1);

        risar.narisiRob(e1, 2);
        risar.narisiRob(e2, 2);
        risar.narisiRob(e3, 2);

        risar.narisiLik(new Oddaja.Razlika(e12, e3));
        risar.narisiLik(new Oddaja.Razlika(e13, e2));
        risar.narisiLik(new Oddaja.Razlika(e23, e1));

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
