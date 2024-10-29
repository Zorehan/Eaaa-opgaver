package BE;

public class Bog {

    private int id;
    private String titel;
    private String udgivelseAar;
    private int forfatterID;

    public Bog(int id, String titel, String udgivelseAar, int forfatterID)
    {
        this.id = id;
        this.titel = titel;
        this.udgivelseAar = udgivelseAar;
        this.forfatterID = forfatterID;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getUdgivelseAar() {
        return udgivelseAar;
    }

    public void setUdgivelseAar(String udgivelseAar) {
        this.udgivelseAar = udgivelseAar;
    }

    public int getForfatterID() {
        return forfatterID;
    }

    public void setForfatterID(int forfatterID) {
        this.forfatterID = forfatterID;
    }

    public String toString()
    {
        String returnes = "Bogen: " + titel + " udgivet i  " + udgivelseAar + "\n";
        return returnes;    
    }
}
