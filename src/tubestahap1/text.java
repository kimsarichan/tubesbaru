package tubestahap1;

import java.text.SimpleDateFormat;
import java.util.*;

class text {

    protected String t;
    protected ArrayList<String> comment ;
    protected int like;
    protected Date tglkirim;

    //constructor
    public text(String t, Date tglkirim) {
        this.t = t;
        this.tglkirim = tglkirim;
        comment =new ArrayList<String>();
    }

    //setter and getter
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

}
