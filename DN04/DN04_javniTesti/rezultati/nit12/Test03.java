
public class Test03 {

    public static void main(String[] args) {
        Skladovnica s = new Skladovnica(100, 0);
        s.dodaj(40);
        s.dodaj(7);
        s.dodaj(20);
        System.out.println(s.skupnoSteviloSkatel());
    }
}
