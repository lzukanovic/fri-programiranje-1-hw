
public class Test08 {

    public static void main(String[] args) {
        Skladovnica s = new Skladovnica(4, 6);

        s.dodaj(1000000);
        System.out.println(s.poisciKup(5));
        System.out.println(s.poisciKup(1));
        System.out.println(s.poisciKup(27));
        System.out.println(s.poisciKup(101));
        System.out.println(s.poisciKup(1002));
        System.out.println(s.poisciKup(10003));
        System.out.println(s.poisciKup(100004));
        System.out.println(s.poisciKup(1000000));
        System.out.println(s.poisciKup(1000001));
    }
}
