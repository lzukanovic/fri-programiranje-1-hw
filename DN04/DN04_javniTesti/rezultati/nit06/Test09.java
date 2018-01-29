
public class Test09 {
    private static final String LOCILO = "--------------------";

    public static void main(String[] args) {
        Skladovnica skladovnica = new Skladovnica(3, 2);
        System.out.println(LOCILO);

        izpisiKapacitete(skladovnica);
        System.out.println(LOCILO);

        System.out.println("Zacetno stanje:");
        izpisiZasedenosti(skladovnica);
        System.out.println(LOCILO);

        System.out.println("Dodamo 30 skatel:");
        skladovnica.dodaj(30);
        izpisiZasedenosti(skladovnica);
        System.out.println(LOCILO);

        System.out.println("Poskusimo odstraniti 10 skatel:");
        System.out.println(skladovnica.odvzemi(10));
        izpisiZasedenosti(skladovnica);
        System.out.println(LOCILO);

        System.out.println("Poskusimo odstraniti 21 skatel:");
        System.out.println(skladovnica.odvzemi(21));
        izpisiZasedenosti(skladovnica);
        System.out.println(LOCILO);

        System.out.println("Dodamo 22 skatel:");
        skladovnica.dodaj(22);
        izpisiZasedenosti(skladovnica);
        System.out.printf("Skupno stevilo skatel: %d%n", 
                          skladovnica.skupnoSteviloSkatel());
        System.out.println(LOCILO);

        System.out.println(skladovnica.poisciKup(2));
        System.out.println(skladovnica.poisciKup(24));
        System.out.println(skladovnica.poisciKup(25));
        System.out.println(skladovnica.poisciKup(37));
        System.out.println(skladovnica.poisciKup(45));
        System.out.println(LOCILO);

        System.out.println("Skatle prelozimo na skladovnico 5/3 ...");
        Skladovnica nova = skladovnica.prestavi(5, 3);
        System.out.print("Nova skladovnica: ");
        izpisiZasedenosti(nova);
        System.out.print("Originalna skladovnica: ");
        izpisiZasedenosti(skladovnica);
        System.out.println(LOCILO);
    }

    private static void izpisiKapacitete(Skladovnica skladovnica) {
        for (int kup = 1;  kup <= 10;  kup++) {
            System.out.printf("| %d ", skladovnica.kapacitetaKupa(kup));
        }
        System.out.println("|");
    }

    private static void izpisiZasedenosti(Skladovnica skladovnica) {
        for (int kup = 1;  kup <= 10;  kup++) {
            System.out.printf("| %d ", skladovnica.zasedenostKupa(kup));
        }
        System.out.println("|");
    }
}
