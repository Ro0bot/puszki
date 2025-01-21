/**
 * Klasa obsługująca zapisywanie limitowanych puszek
 */

public class LimitowanaPuszka extends Puszka {
    String powiazanie;
    String aromat;
    String kolor;

    /**
     * Konstruktor tworzący obiekt z danymi limitowanej puszki
     *
     * @param firma Nazwa firmy
     * @param smak Smak napoju
     * @param mililitry Ilość mililitrów
     * @param cena Cena napoju
     * @param cukier Czy zawiera cukier
     * @param powiazanie Z kim / czym powiązana jest puszka
     * @param aromat Jaki aromat ma napój
     * @param kolor Jaki kolor przeważa na puszce
     */

    public LimitowanaPuszka(String firma, String smak, int mililitry, double cena, boolean cukier, String powiazanie, String aromat, String kolor) {
        super(firma, smak, mililitry, cena, cukier);
        this.powiazanie = powiazanie;
        this.aromat = aromat;
        this.kolor = kolor;
    }

    /**
     * Zwraca z kim / czym powiązana jest puszka
     *
     * @return Powiązanie puszki
     */

    public String getPowiazanie() {
        return powiazanie;
    }

    /**
     * Zwraca dodatkowy aromat napoju
     *
     * @return Aromat napoju
     */

    public String getAromat() {
        return aromat;
    }

    /**
     * Zwraca przeważający kolor na puszce
     *
     * @return Kolor puszki
     */

    public String getKolor() {
        return kolor;
    }

    /**
     * Wypisuje informacje o nowej limitowanej puszce
     */

    @Override
    public void nowaPuszka() {
        System.out.println("Dodano nową limitowaną puszkę: Napój " + firma + " o smaku " + smak + " oraz aromacie " + aromat + "m! Partner: " + powiazanie + "!");
    }
}
