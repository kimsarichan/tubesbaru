package tubestahap1;

import java.text.SimpleDateFormat;
import java.util.Date;

class text {

    protected String t;
    protected String comment[] = new String[5];
    protected int numberofcomment;
    protected int like;
    protected Date tglkirim;

    public text(String t, Date tglkirim) {
        this.t = t;
        this.tglkirim = tglkirim;

    }

    public void edittext(String t) {
        this.t = t;
    }

    public void addcomment(String com) {
        comment[numberofcomment] = com;
        numberofcomment = numberofcomment + 1;
    }

    public void editcomment(String com, int num) {
        comment[num] = com;
    }

    public void addlike() {
        like = like + 1;
    }

    public void deletelike() {
        like = like - 1;
    }

}
