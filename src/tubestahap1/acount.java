package tubestahap1;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class acount extends profile implements Serializable {

    private acount friend[];
    private group grup[];
    private ArrayList<message> pesan;
    private ArrayList<text> status;
    private int numberoffriend;
    private int numberofgroup;
    private int idacount;
    private String alamat;
    private String sekolah;
    private String securityquestion;
    private String securityanwer;
    private String notification;//hapus

    public acount(int idacount,String nama,String email, String username, String password, Date tanggal,String alamat, String sekolah, String job, String gender,String securityquestion, String securityanswer  ) {
        super(nama, job, gender, username, password, securityanswer, securityquestion, tanggal, email);
        friend = new acount[100];
        grup = new group[100];
        pesan = new ArrayList<>();
        status = new ArrayList<>();//status
        this.idacount=idacount;
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

    public void addgroup(group g) {
        grup[numberofgroup] = g;
        numberofgroup += 1;
    }

    public group getgroup(int id) {
        return grup[id];
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
    public void getmessage(acount pengirim, message m) {
        this.pesan.add(m);

    }

    public void sendmessage(acount penerima, message m) {
        m.setM("From : " + nama + "\n" + m.getM());
        this.pesan.add(m);
        m.getP().getmessage(this, m);

    }

    //menambahkan status baru 
    public void addstatus(text stat) {
        status.add(stat);
    }

    //menambahkan teman baru 
    public void addfriend(acount f) {
        friend[numberoffriend] = f;
        numberoffriend = numberoffriend + 1;

    }

    //mencari teman  
    public acount searchfriend(String username) throws Exception {
        int i = 0;
        acount a = null;
        boolean ketemu = false;
        while (i < numberoffriend && ketemu == false) {
            if (friend[i].username.equals(username)) {
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

    //mencari grup
    public group searchgrup(String nama) throws Exception {
        int i = 0;
        group a = null;
        boolean ketemu = false;
        while (i < numberofgroup && ketemu == false) {
            if (grup[i].getNama().equalsIgnoreCase(nama)) {
                a = grup[i];
                ketemu = true;
            }
            i++;
        }
        if (ketemu == true) {
            return a;
        } else {
            throw new notfoundexception("grup tidak ditemukan");
        }

    }

    /**
     * @return the idacount
     */
    public int getIdacount() {
        return idacount;
    }

}
