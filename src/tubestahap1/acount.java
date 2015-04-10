package tubestahap1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class acount extends profile {

    private acount friend[] = new acount[100];
    private ArrayList<message> pesan = new ArrayList<>();
    private ArrayList<text> status = new ArrayList<>(); //status 
    private int numberoffriend;
    private int numberofgroup;
    private int numberofpesan;
    private int numberofstatus;
    private String notification;

    public acount(String nama, String job, String gender, String username, String password, String securityanswer, String securityquestion, Date tanggal) {
        super(nama, job, gender, username, password, securityanswer, securityquestion, tanggal);
    }
    
    public void addfriend(acount f) {
        friend[numberoffriend] = f;
        numberoffriend = numberoffriend + 1;
    }

    public acount searchfriend(String nama) throws Exception {
        int i = 0;
        acount a = null;
        boolean ketemu = false;
        while (i < numberoffriend && ketemu == false) {
            if (friend[i].nama.equals(nama)) {
                a = friend[i];
                ketemu = true;
            }
            i++;
        }
        if (ketemu == true) {
            return a;
        } else {
            throw new notfoundexception("teman tidak ditemukan");
        }

    }

    public void sendmessage(acount f, message m) {
        pesan[numberofpesan] = m;
        numberofpesan = numberofpesan + 1;
    }

    public void addstatus(status s) {
        stat[numberofstatus] = s;
        numberofstatus = numberofstatus;
    }

    public String getnotification() {
        return notification;
    }

}
