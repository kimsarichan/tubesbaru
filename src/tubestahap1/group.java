package tubestahap1;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;


class group implements Serializable {

    private acount member[] = new acount[100];
    private acount admin;
    private ArrayList<message> pesan = new ArrayList<>();
    private ArrayList<text> status = new ArrayList<>(); //status 
    private int numberofmember;
    private String nama;
    private String description;
    private Date tglberdiri;
    //constructor
    public group(acount admin, String nama, String description, Date tglberdiri) {
        this.admin = admin;
        this.nama = nama;
        this.description = description;
        this.tglberdiri = tglberdiri;
    }

    //setter and getter
    public acount getAdmin() {
        return admin;
    }

    public void setAdmin(acount admin) {
        this.admin = admin;
    }

    public ArrayList<message> getPesan() {
        return pesan;
    }

    public ArrayList<text> getStatus() {
        return status;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTglberdiri() {
        return tglberdiri;
    }

    public void setTglberdiri(Date tglberdiri) {
        this.tglberdiri = tglberdiri;
    }

    public int getNumberofmember() {
        return numberofmember;
    }

    public void setNumberofmember(int numberofmember) {
        this.numberofmember = numberofmember;
    }

    public acount getMember(int id) {
        return member[id];
    }
    
    //kirim message
    public void sendpesan(message m){
        pesan.add(m);
        for(int i=0 ; i< numberofmember;i++){
            member[i].getmessage(member[i], m);
        }
    }
    //add status
    public void tambahstatus(text e){
        status.add(e);
    }
    //add member
    public void tambahmember(acount  m){
        member[numberofmember]= m;
        numberofmember+=1;
    }
    //mencari teman  
    public acount searchmember(String nama) throws Exception {
        int i = 0;
        acount a = null;
        boolean ketemu = false;
        while (i < numberofmember && ketemu == false) {
            if (member[i].nama.equals(nama)) {
                a = member[i];
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
}
