package hu.alkfejl.nyilvantarto.model.bean;

import java.io.Serializable;

public class Szemely implements Serializable {
    private static final long serialVersionUID = -697890192402112723L;
    private String nev;
    private String email;
    private String telefon;
    private int szulEv;

    public Szemely() {
    }

    public Szemely(String nev, String email, String telefon, int ev) {
        this.nev = nev;
        this.email = email;
        this.telefon = telefon;
        this.szulEv = ev;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getSzulEv() {
        return szulEv;
    }

    public void setSzulEv(int szulEv) {
        this.szulEv = szulEv;
    }
}
