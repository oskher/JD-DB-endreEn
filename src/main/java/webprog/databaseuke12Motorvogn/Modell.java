package webprog.databaseuke12Motorvogn;

public class Modell {
    private String merke;
    private String type;

    public Modell(String merke, String type) {
        this.merke = merke;
        this.type = type;
    }

    public Modell() {
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
