package tubestahap1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class message {

    String m;
    Date tgl;
    acount p;

    public message(String m, Date tgl, acount p) {
        this.m = m;
        this.tgl = tgl;
        this.p = p;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public acount getP() {
        return  p;
    }

    public void setP(acount pengirim) {
        this.p = pengirim;
    }


    
}
