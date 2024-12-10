public class LimitowanaPuszka extends Puszka {
    String powiazanie;
    String aromat;
    String kolor;

    public LimitowanaPuszka(String firma, String smak, int mililitry, double cena, boolean cukier, String powiazanie, String aromat, String kolor) {
        super(firma, smak, mililitry, cena, cukier);
        this.powiazanie = powiazanie;
        this.aromat = aromat;
        this.kolor = kolor;
    }

    public String getPowiazanie() {
        return powiazanie;
    }
    public String getAromat() {
        return aromat;
    }
    public String getKolor() {
        return kolor;
    }

    @Override
    public void nowaPuszka() {
        System.out.println("Dodano nową limitowaną puszkę: Napój " + firma + " o smaku " + smak + " oraz aromacie " + aromat + "m! Partner: " + powiazanie + "!");
    }
}