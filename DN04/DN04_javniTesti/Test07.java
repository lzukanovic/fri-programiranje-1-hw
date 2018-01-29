
public class Test07 {

    public static void main(String[] args) {
        Skladovnica s = new Skladovnica(2, 1);

        System.out.println(s.odvzemi(1));
        s.dodaj(20);
        s.dodaj(13);

        System.out.println(s.skupnoSteviloSkatel());
        for (int i = 1;  i <= 10;  i++) {
            System.out.print(s.zasedenostKupa(i) + "|");
        }
        System.out.println();

        System.out.println(s.odvzemi(5));

        System.out.println(s.skupnoSteviloSkatel());
        for (int i = 1;  i <= 10;  i++) {
            System.out.print(s.zasedenostKupa(i) + "|");
        }
        System.out.println();

        System.out.println(s.odvzemi(6));

        System.out.println(s.skupnoSteviloSkatel());
        for (int i = 1;  i <= 10;  i++) {
            System.out.print(s.zasedenostKupa(i) + "|");
        }
        System.out.println();

        s.dodaj(10);

        System.out.println(s.skupnoSteviloSkatel());
        for (int i = 1;  i <= 10;  i++) {
            System.out.print(s.zasedenostKupa(i) + "|");
        }
        System.out.println();

        System.out.println(s.odvzemi(35));

        System.out.println(s.skupnoSteviloSkatel());
        for (int i = 1;  i <= 10;  i++) {
            System.out.print(s.zasedenostKupa(i) + "|");
        }
        System.out.println();
    }
}
