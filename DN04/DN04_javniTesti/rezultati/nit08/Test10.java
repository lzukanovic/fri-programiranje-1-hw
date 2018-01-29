
public class Test10 {

    private static final String LOCILO = "--------------------";
    private static final int N = 1000000;

    public static void main(String[] args) {
        Skladovnica s1 = new Skladovnica(42, 15);
        s1.dodaj(N);
        testiraj(s1);

        Skladovnica s2 = s1.prestavi(33, 28);
        testiraj(s2);

        Skladovnica s3 = s2.prestavi(1, 44);
        testiraj(s3);

        testiraj(s1);
        testiraj(s2);
    }

    public static void testiraj(Skladovnica s) {
        System.out.printf("Skladovnica %d/%d%n",
                s.kapacitetaKupa(1), s.kapacitetaKupa(2) - s.kapacitetaKupa(1));

        System.out.printf("%d skatel%n", s.skupnoSteviloSkatel());
        int kup = s.poisciKup(N);
        if (kup >= 1) {
            System.out.printf("kup %d --> %d skatel%n", kup, s.zasedenostKupa(kup));
        } else {
            System.out.println(kup);
        }

        int kup2 = s.poisciKup(N / 2);
        if (kup2 >= 1) {
            System.out.printf("kup %d --> %d skatel%n", kup2, s.zasedenostKupa(kup2));
        } else {
            System.out.println(kup);
        }

        System.out.println(LOCILO);
    }
}
