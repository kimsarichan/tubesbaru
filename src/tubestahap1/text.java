package tubestahap1;

import java.text.SimpleDateFormat;
import java.util.*;

class text {

    private String t;
    private ArrayList<String> comment ;
    private int like;
    private Date tglkirim;
    private String nama ;
    private int id_status;

    //constructor
    public text(int id_status ,String nama, String t, Date tglkirim) {
        this.nama=nama;
        this.t = t;
        this.tglkirim = tglkirim;
        comment =new ArrayList<String>();
        this.id_status=id_status;
    }
     public text(String nama, String t, Date tglkirim) {
        this.nama=nama;
        this.t = t;
        this.tglkirim = tglkirim;
        comment =new ArrayList<String>();
    }

    //setter and getter
    
    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getT() {
        return t;
    }

    public ArrayList<String> getComment() {
        return comment;
    }
    

    public void setComment(String c) {
        boolean add = comment.add(c);
        
    }

    public int getLike() {
        return like;
    }
    
    public Date getTglkirim() {
        return tglkirim;
    }

    public void setTglkirim(Date tglkirim) {
        this.tglkirim = tglkirim;
    }

    public void edittext(String t) {
        this.t = t;
    }
    
    //like 
    public void addlike() {
        like = like + 1;
    }

    public void deletelike() {
        like = like - 1;
    }

    @Override
    public String toString() {
        return "("+getTglkirim()+")"+getNama()+" : "+" "+getT();
    }
    
}
