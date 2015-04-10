package tubestahap1;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class acount extends profile implements Serializable {

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
    //setter dan getter 
    public int getNumberoffriend() {
        return numberoffriend;
    }

    public void setNumberoffriend(int numberoffriend) {
        this.numberoffriend = numberoffriend;
    }

    public int getNumberofgroup() {
        return numberofgroup;
    }

    public void setNumberofgroup(int numberofgroup) {
        this.numberofgroup = numberofgroup;
    }

    public int getNumberofpesan() {
        return numberofpesan;
    }

    public void setNumberofpesan(int numberofpesan) {
        this.numberofpesan = numberofpesan;
    }

    public int getNumberofstatus() {
        return numberofstatus;
    }

    public void setNumberofstatus(int numberofstatus) {
        this.numberofstatus = numberofstatus;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public acount getFriend(int id) {
        return friend[id];
    }

    public ArrayList<message> getPesan() {
        return pesan;
    }

    public ArrayList<text> getStatus() {
        return status;
    }
    
    //menambahkan pesan baru 
    public void sendmessage(message m){
       pesan.add(m);
    }
    //menambahkan status baru 
    public void addstatus(text stat){
        status.add(stat);
    }
    //menambahkan teman baru 
    public void addfriend(acount f) {
        friend[numberoffriend] = f;
        numberoffriend = numberoffriend + 1;
        notification += nama+ " menambahkan "+ friend[numberoffriend].getNama() + " sebagai teman " ;
    }
   
    //mencari teman  
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

    public String getnotification() {
        return notification;
    }

}
