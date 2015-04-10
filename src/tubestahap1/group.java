package tubestahap1;

import java.text.SimpleDateFormat;
import java.util.*;


class group {

    private acount member[] = new acount[100];
    private acount admin;
    private ArrayList<message> pesan = new ArrayList<>();
    private ArrayList<text> status = new ArrayList<>(); //status 
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
