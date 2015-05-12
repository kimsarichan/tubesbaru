package tubestahap1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class message {

    String m;
    Date tgl;
    acount p;//pengirim
    acount r;//receiver

    public message(String m, Date tgl, acount p,acount r) {
        this.m = m;
        this.tgl = tgl;
        this.p = p;
        this.r=r;
    }
    
    public message(String m , Date tgl ){
        this.m=m;
        this.tgl=tgl;
    }

    public acount getR() {
        return r;
    }

    public void setR(acount r) {
        this.r = r;
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

    @Override
    public String toString() {
        return "message(" + "m=" + m + "/ tgl=" + tgl + ')';
    }
    



    
}
