public class Puszka {
    String firma;
    String smak;
    int mililitry;
    double cena;
    boolean cukier;

    public Puszka(String firma, String smak, int mililitry, double cena, boolean cukier) {
        this.firma = firma;
        this.smak = smak;
        this.mililitry = mililitry;
        this.cena = cena;
        this.cukier = cukier;
    }

    public String getFirma() {
        return firma;
    }

    public String getSmak() {
        return smak;
    }

    public int getMililitry() {
        return mililitry;
    }

    public double getCena() {
        return cena;
    }

    public boolean isCukier() {
        return cukier;
    }

    public void nowaPuszka() {
        System.out.println("Dodano nową puszkę: Napój " + firma + " o smaku " + smak + "!");
    }
}