package tubestahap1;

import java.text.SimpleDateFormat;
import java.util.*;

class text {

    protected String t;
    protected ArrayList<String> comment ;
    protected int numberofcomment;
    protected int like;
    protected Date tglkirim;

    //constructor
    public text(String t, Date tglkirim) {
        this.t = t;
        this.tglkirim = tglkirim;
        ArrayList comment =new ArrayList<>();
    }

    //setter and getter
    public String getT() {
        return t;
    }
    
    public String getComment(int id) {
        return comment.get(id);
    }

    public void setComment(String c) {
        comment.add(c);
    }

    public int getNumberofcomment() {
        return numberofcomment;
    }

    public void setNumberofcomment(int numberofcomment) {
        this.numberofcomment = numberofcomment;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
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

}
