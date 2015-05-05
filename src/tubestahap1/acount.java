package tubestahap1;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class acount implements Serializable {
    private int idacount;
    protected String nama;
    protected String email;
    public String username;
    private String password;
    protected Date birthdate;
    private String alamat;
    private String sekolah;
    protected String job;
    protected String gender;
    private acount friend[];
    private group grup[];
    private String securityquestion;
    private String securityanswer;
    private ArrayList<message> pesan;
    private ArrayList<text> status;
    private int numberoffriend;
    private int numberofgroup;
    
   // private String notification;//hapus

    public acount(int idacount,String nama,String email, String username, String password, Date tanggal,String alamat, String sekolah, String job, String gender,String securityquestion, String securityanswer  ) {
        this.idacount=idacount;
        this.nama=nama;
        this.email=email;
        this.username=username;
        this.password=password;
        this.birthdate=tanggal;
        this.alamat=alamat;
        this.sekolah=sekolah;
        this.job=job;
        this.gender=gender;
        this.securityquestion=securityquestion;
        this.securityanswer=securityanswer;
                
        friend = new acount[100];
        grup = new group[100];
        pesan = new ArrayList<>();
        status = new ArrayList<>();//status
    }
    public acount(int idacount, String nama,String username)
    {
        this.idacount=idacount;
        this.nama=nama;
        this.username=username;
    }

    //setter dan getter 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getSekolah() {
        return sekolah;
    }

    public void setSekolah(String sekolah) {
        this.sekolah = sekolah;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public acount[] getFriend() {
        return friend;
    }

    public void setFriend(acount[] friend) {
        this.friend = friend;
    }

    public group[] getGrup() {
        return grup;
    }

    public void setGrup(group[] grup) {
        this.grup = grup;
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
    
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getIdacount() {
        return idacount;
    }
    public String getUsername()
    {
        return username;
    }
    
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

    /*public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }*/
    
  
    public acount getFriend(int id) {
        return friend[id];
    }
    public boolean isFriend(int id)
    {
        boolean exist=false;
        for (int i=0;i<numberoffriend;i++)
        {
            if(friend[i].getIdacount()==id)
                exist=true;
        }
        return exist;
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
        if (ketemu == true) 
            return a;
        return a;
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
    

}
