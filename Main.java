import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firma;
        String smak;
        int mililitry;
        double cena;
        boolean cukier;
        Puszka puszka;
        String powiazanie;
        String aromat;
        String kolor;
        LimitowanaPuszka lPuszka;

        System.out.println("normal or limit");
        int wybor = sc.nextInt();
        switch (wybor) {
            case 1:
                System.out.println("firma");
                firma = sc.next();
                System.out.println("smak");
                smak = sc.next();
                System.out.println("mililitry");
                mililitry = sc.nextInt();
                System.out.println("cena");
                cena = sc.nextDouble();
                System.out.println("cukier?");
                cukier = sc.nextBoolean();
                puszka = new Puszka(firma, smak, mililitry, cena, cukier);
                puszka.nowaPuszka();
                break;
            case 2:
                System.out.println("firma");
                firma = sc.next();
                System.out.println("smak");
                smak = sc.next();
                System.out.println("mililitry");
                mililitry = sc.nextInt();
                System.out.println("cena");
                cena = sc.nextDouble();
                System.out.println("cukier?");
                cukier = sc.nextBoolean();
                System.out.println("powiązanie");
                powiazanie = sc.next();
                System.out.println("aromat");
                aromat = sc.next();
                System.out.println("kolor");
                kolor = sc.next();
                lPuszka = new LimitowanaPuszka(firma, smak, mililitry, cena, cukier, powiazanie, aromat, kolor);
                lPuszka.nowaPuszka();
                break;
        }
    }
}
