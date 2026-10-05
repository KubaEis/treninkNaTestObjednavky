public class Objednavka {
    private String jmenoPrijmeni;
    private String email;
    private String produkt;
    private double cena;
    private int pocetKusu;

    public Objednavka(String jmenoPrijmeni, String email, String produkt, double cena, int pocetKusu) {
        this.jmenoPrijmeni = jmenoPrijmeni;
        this.email = email;
        this.produkt = produkt;
        this.cena = cena;
        this.pocetKusu = pocetKusu;
    }

    public String getJmenoPrijmeni() {
        return jmenoPrijmeni;
    }

    public void setJmenoPrijmeni(String jmenoPrijmeni) {
        this.jmenoPrijmeni = jmenoPrijmeni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProdukt() {
        return produkt;
    }

    public void setProdukt(String produkt) {
        this.produkt = produkt;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getPocetKusu() {
        return pocetKusu;
    }

    public void setPocetKusu(int pocetKusu) {
        this.pocetKusu = pocetKusu;
    }

    @Override
    public String toString() {
        return "Jmeno: "+jmenoPrijmeni+" E-mail: "+email+" Produkt: "+produkt+" Cena: "+cena+" Pocet kusu: "+pocetKusu;
    }
}
