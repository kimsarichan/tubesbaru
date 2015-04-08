package tubestahap1;

import java.util.Date;

class note extends text {

    String title;

    public note(String not, Date tgl, String title) {
        super(not, tgl);
        this.title = title;
    }
}
