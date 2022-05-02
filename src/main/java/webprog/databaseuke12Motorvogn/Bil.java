package webprog.databaseuke12Motorvogn;

public class Bil {
    // må ha Stor forbokstav i klasse^
    private String personnr;
    private String navn;
    private String adresse;
    private String kjennetegn;
    private String bilmerke;
    private String biltype;
    private int id;

    public Bil(String personnr, String navn, String adresse, String kjennetegn, String bilmerke, String biltype, int id){
        this.personnr = personnr;
        this.navn = navn;
        this.adresse = adresse;
        this.kjennetegn = kjennetegn;
        this.bilmerke = bilmerke;
        this.biltype = biltype;
        this.id = id;
    }

    public Bil(){
        //          DATABASE må ha med tom 2.Konstruktør.
    }
    /* Get først*/
    public String getPersonnr(){
        return personnr;
    }
    public void setPersonnr(String personnr){
        this.personnr = personnr;
    }
    public String getNavn(){
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public String getAdresse(){
        return adresse;
    }
    public void setAdresse(String adresse){
        this.adresse=adresse;
    }
    public String getKjennetegn(){
        return kjennetegn;
    }
    public void setKjennetegn(String kjennetegn){
        this.kjennetegn=kjennetegn;
    }
    public String getBilmerke(){
        return bilmerke;
    }
    public void setBilmerke(String bilmerke){
        this.bilmerke=bilmerke;
    }
    public String getBiltype(){
        return biltype;
    }
    public void setBiltype(String biltype){
        this.biltype=biltype;
    }
    public int getId(){
        return id; }
    public void setId(int id){   //       NB! Husk at den tar inn idFraInput her.
        this.id = id; }
}