
public class Test05 {

    public static void main(String[] args) {
        Skladovnica s = new Skladovnica(20, 10);
        s.dodaj(15);
        s.dodaj(10);
        s.dodaj(3);
        s.dodaj(18);
        s.dodaj(9);
        s.dodaj(7);
        System.out.println(s.zasedenostKupa(1));
        System.out.println(s.zasedenostKupa(2));
        System.out.println(s.zasedenostKupa(3));
        System.out.println(s.zasedenostKupa(4));
        System.out.println(s.zasedenostKupa(5));
    }
}
