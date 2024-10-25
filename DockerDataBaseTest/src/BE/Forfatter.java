package BE;

public class Forfatter {
    private int id;
    private String navn;
    private String foedselsaar;
    private String doedlAar;
    private String land;

    public Forfatter(int id, String navn, String foedselsaar, String doedlAar, String land)
    {
        this.id = id;
        this.navn = navn;
        this.foedselsaar = foedselsaar;
        this.doedlAar = doedlAar;
        this.land = land;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getFoedselsaar() {
        return foedselsaar;
    }

    public void setFoedselsaar(String foedselsaar) {
        this.foedselsaar = foedselsaar;
    }

    public String getDoedlAar() {
        return doedlAar;
    }

    public void setDoedlAar(String doedlAar) {
        this.doedlAar = doedlAar;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String toString()
    {
        String returnes = this.navn + " født i: " + this.foedselsaar + ". Døde i år: " + this.doedlAar + ". Fra " + this.land + "\n" ;
        return returnes;
    }
}
