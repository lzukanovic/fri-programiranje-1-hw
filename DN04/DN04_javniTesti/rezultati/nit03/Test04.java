
public class Test04 {

    public static void main(String[] args) {
        Skladovnica s = new Skladovnica(20, 10);
        System.out.println(s.skupnoSteviloSkatel());
        s.dodaj(6);
        System.out.println(s.skupnoSteviloSkatel());
        s.dodaj(3);
        System.out.println(s.skupnoSteviloSkatel());
        s.dodaj(1);
        System.out.println(s.skupnoSteviloSkatel());
        s.dodaj(5);
        System.out.println(s.skupnoSteviloSkatel());
    }
}
