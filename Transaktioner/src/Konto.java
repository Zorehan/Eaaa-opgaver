public class Konto {

    private String regNr;
    private String ktoNr;
    private String tekst;
    private double saldo;
    private double renteIndlaan;
    private double renteUdlaan;

    public Konto(String regNr, String ktoNr, String tekst, double saldo, double renteIndlaan, double renteUdlaan) {
        this.regNr = regNr;
        this.ktoNr = ktoNr;
        this.tekst = tekst;
        this.saldo = saldo;
        this.renteIndlaan = renteIndlaan;
        this.renteUdlaan = renteUdlaan;
    }

    public String getRegNr(){
        return regNr;
}

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getKtoNr() {
        return ktoNr;
    }

    public void setKtoNr(String ktoNr) {
        this.ktoNr = ktoNr;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getRenteIndlaan() {
        return renteIndlaan;
    }

    public void setRenteIndlaan(double renteIndlaan) {
        this.renteIndlaan = renteIndlaan;
    }

    public double getRenteUdlaan() {
        return renteUdlaan;
    }

    public void setRenteUdlaan(double renteUdlaan) {
        this.renteUdlaan = renteUdlaan;
    }
}
