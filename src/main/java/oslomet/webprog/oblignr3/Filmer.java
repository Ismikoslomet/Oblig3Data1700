package oslomet.webprog.oblignr3;

public class Filmer {
    private String valgtFilm;
    private String sjanger;

    public Filmer(String valgtFilm, String sjanger) {
        this.valgtFilm = valgtFilm;
        this.sjanger = sjanger;
    }

    public String getValgtFilm() {
        return valgtFilm;
    }

    public void setValgtFilm(String valgtFilm) {
        this.valgtFilm = valgtFilm;
    }

    public String getSjanger() {
        return sjanger;
    }

    public void setSjanger(String sjanger) {
        this.sjanger = sjanger;
    }
}





