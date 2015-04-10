package tubestahap1;

import java.text.SimpleDateFormat;
import java.util.Date;

class group {

    private acount member[] = new acount[100];
    private acount admin;
    private message pesan[] = new message[100];
    private text notes[] = new note[100]; //status 
    private int numberofpesan;
    private int numberofnotes;
    private int numberofmember;
    private String nama;
    private String description;
    private Date tglberdiri;

    public group(acount admin, String nama, String description, Date tglberdiri) {
        this.admin = admin;
        this.nama = nama;
        this.description = description;
        this.tglberdiri = tglberdiri;
    }

    public  void sendmessage(){
    };

    public  void sendnote(){
    };
}
