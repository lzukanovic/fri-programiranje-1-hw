public class tester{
	public static void main(String[] args) {
		Skladovnica skladovnica = new Skladovnica(3, 2);

		skladovnica.dodaj(30);
		System.out.println(skladovnica.odvzemi(10));
		System.out.println(skladovnica.odvzemi(21));
		skladovnica.dodaj(22);

		System.out.println(skladovnica.poisciKup(2));
        System.out.println(skladovnica.poisciKup(24));
        System.out.println(skladovnica.poisciKup(25));
        System.out.println(skladovnica.poisciKup(37));
        System.out.println(skladovnica.poisciKup(45));
	}
}