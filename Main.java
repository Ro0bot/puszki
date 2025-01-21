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

        System.out.println("Jaką puszkę chcesz dodać?");
        System.out.println("1 - Zwykłą");
        System.out.println("2 - Limitowaną");
        int wybor = sc.nextInt();
        switch (wybor) {
            case 1:
                System.out.println("Podaj firmę producenta");
                firma = sc.next();
                System.out.println("Podaj smak napoju");
                smak = sc.next();
                System.out.println("Podaj ilość mililitrów");
                mililitry = sc.nextInt();
                System.out.println("Podaj cenę");
                cena = sc.nextDouble();
                System.out.println("Czy zawiera cukier?");
                System.out.println("Wpisz true jeśli tak, lub false jeśli nie");
                cukier = sc.nextBoolean();
                puszka = new Puszka(firma, smak, mililitry, cena, cukier);
                puszka.nowaPuszka();
                break;
            case 2:
                System.out.println("Podaj firmę producenta");
                firma = sc.next();
                System.out.println("Podaj smak napoju (podstawowy jeśli występuje dodatkowy aromat)");
                smak = sc.next();
                System.out.println("Podaj aromat (dodatkowy smak) jaki ma napój (jeśli jakiś aromat występuje)");
                aromat = sc.next();
                System.out.println("Podaj ilość mililitrów");
                mililitry = sc.nextInt();
                System.out.println("Podaj cenę");
                cena = sc.nextDouble();
                System.out.println("Czy zawiera cukier?");
                System.out.println("Wpisz true jeśli tak, lub false jeśli nie");
                cukier = sc.nextBoolean();
                System.out.println("Podaj kto / co pojawia się na puszce");
                powiazanie = sc.next();
                System.out.println("Podaj kolor puszki");
                kolor = sc.next();
                lPuszka = new LimitowanaPuszka(firma, smak, mililitry, cena, cukier, powiazanie, aromat, kolor);
                lPuszka.nowaPuszka();
                break;
        }
    }
}
