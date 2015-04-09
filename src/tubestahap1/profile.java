package tubestahap1;

import java.util.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class profile {

    protected String nama;
    protected String job;
    protected school sekolah[] = new school[5];
    protected int nsekolah;
    protected String gender;
    public adress alamat;
    public String username;
    private String password;
    protected String securityquestion;
    protected String securityanswer;
    protected Date tgl;

    public profile(String nama, String job, String gender, String username, String password, String securityanswer, String securityquestion, Date tgl) {
        this.nama = nama;
        this.gender = gender;
        this.job = job;
        this.username = username;
        this.password = password;
        this.securityanswer = securityanswer;
        this.securityquestion = securityquestion;
        this.tgl = tgl;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getNsekolah() {
        return nsekolah;
    }

    public void setNsekolah(int nsekolah) {
        this.nsekolah = nsekolah;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSecurityquestion() {
        return securityquestion;
    }

    public void setSecurityquestion(String securityquestion) {
        this.securityquestion = securityquestion;
    }

    public String getSecurityanswer() {
        return securityanswer;
    }

    public void setSecurityanswer(String securityanswer) {
        this.securityanswer = securityanswer;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void addschool(String schoolname, int yearattended) {
        sekolah[nsekolah] = new school(schoolname, yearattended);
        nsekolah = nsekolah + 1;
    }

    public void changepass(String p) {
        password = p;
    }

    public void forgetpass(String securityans) {
        Scanner s = new Scanner(System.in);
        System.out.println("jawab pertanyaan dibawah ini ");
        System.out.println(s.next());
        if (securityans.equals(securityanswer)) {
            System.out.println("tulis password baru ");
            changepass(s.next());
        } else {
            System.out.println("jawaban anda salah");
        }
    }

}
