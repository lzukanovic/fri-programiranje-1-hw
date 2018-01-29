
public class Test06 {

    private static final String LOCILO = "--------------------";

    public static void main(String[] args) {
        Skladovnica s = new Skladovnica(6, 7);
        s.dodaj(19);
        s.dodaj(75);
        s.dodaj(1);
        s.dodaj(37);

        for (int kup = 1;  kup <= 10;  kup++) {
            System.out.println(s.zasedenostKupa(kup));
        }
        System.out.println(LOCILO);

        s.dodaj(888300);
        for (int kup = 501;  kup <= 510;  kup++) {
            System.out.println(s.zasedenostKupa(kup));
        }
    }
}
