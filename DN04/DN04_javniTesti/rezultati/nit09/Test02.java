
public class Test02 {

    public static void main(String[] args) {
        Skladovnica s = new Skladovnica(13, 47);
        System.out.println(s.kapacitetaKupa(75));
        System.out.println(s.kapacitetaKupa(120));
        System.out.println(s.kapacitetaKupa(63));
        System.out.println(s.kapacitetaKupa(7));
    }
}
