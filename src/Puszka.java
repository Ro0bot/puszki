/**
 * Klasa obsługująca zapisywanie zwykłych puszek
 */

public class Puszka {
    String firma;
    String smak;
    int mililitry;
    double cena;
    boolean cukier;

    /**
     * Konstruktor tworzący obiekt z danymi zwykłej puszki
     *
     * @param firma Nazwa firmy
     * @param smak Smak napoju
     * @param mililitry Ilość mililitrów
     * @param cena Cena napoju
     * @param cukier Czy zawiera cukier
     */

    public Puszka(String firma, String smak, int mililitry, double cena, boolean cukier) {
        this.firma = firma;
        this.smak = smak;
        this.mililitry = mililitry;
        this.cena = cena;
        this.cukier = cukier;
    }

    /**
     * Zwraca nazwę firmy
     *
     * @return Nazwa firmy
     */

    public String getFirma() {
        return firma;
    }

    /**
     * Zwraca smak napoju
     *
     * @return Smak napoju
     */

    public String getSmak() {
        return smak;
    }

    /**
     * Zwraca ilość mililitrów
     *
     * @return Ilość mililitrów
     */

    public int getMililitry() {
        return mililitry;
    }

    /**
     * Zwraca cenę napoju
     *
     * @return Cena napoju
     */

    public double getCena() {
        return cena;
    }

    /**
     * Zwraca czy napój zawiera cukier
     *
     * @return True lub false w zależności od obecności cukru
     */

    public boolean isCukier() {
        return cukier;
    }

    /**
     * Wypisuje informacje o nowej zwykłej puszce
     */

    public void nowaPuszka() {
        System.out.println("Dodano nową puszkę: Napój " + firma + " o smaku " + smak + "!");
    }
}
