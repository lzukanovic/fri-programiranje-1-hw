
public class Test01 {

    public static void main(String[] args) {
        Skladovnica s = new Skladovnica(10, 5);
        System.out.println(s.kapacitetaKupa(1));
        System.out.println(s.kapacitetaKupa(2));
        System.out.println(s.kapacitetaKupa(10));
    }
}
