/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubestahap1;

import java.util.*;
import java.io.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A450LC W8
 */
public class main {

    //case menggunakan array list
    private ArrayList<acount> list_akun = new ArrayList<>();
    private ArrayList<group> list_grup = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void testing_user() {
        acount people = new acount("sari", "pelajar", "M", "saya", "bla", "bla", "bla", new Date(), "s@gmail.com");
        list_akun.add(people);
        acount p = new acount("sari", "pelajar", "M", "bla", "bla", "bla", "bla", new Date(), "a@gmail.com");
        list_akun.add(p);
        text a = new text("ga tahu", new Date());
        text b = new text("nooooo ", new Date());
        list_akun.get(0).addstatus(a);
        list_akun.get(1).addstatus(b);
    }

    public void registrasi() throws Exception {
        System.out.println("Registration");
        System.out.println("1. Username 		: ");
        String username = input.next();
        //cek username ganda
        //end cek username ganda
        System.out.println("2. Nama 			: ");
        String nama = input.next();
        System.out.println("3. Email 			: ");
        String email = input.next();
        System.out.println("4. password 		: ");
        String password = input.next();
        System.out.println("5. Re-type password	: ");
        String repassword = input.next();
        //cek kesamaan password dan repassword
        if (password.equals(repassword)) {
            System.out.println("Ok");
        } else {
            throw new Exception("Password tidak sama");
        }
        System.out.println("Security Question : What is your favorite animal ?");
        String securityquestion = ("What is your favorite animal?");
        System.out.println("6. Answer	: ");
        String securityanswer = input.next();
        System.out.println("data pribadi berhasil di simpan ");
        System.out.println("7. Gender(M/F) 		: ");
        String gender = input.next();
        System.out.println("8. Birthdate(dd-MM-yyyy): ");
        String birth_date = input.next();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate;
        try {
            startDate = df.parse(birth_date);
        } catch (ParseException e) {
            throw e;
        }
        System.out.println("9. Job	: ");
        String job = input.next();
        System.out.println("Masukan alamat pribadi anda ");
        System.out.println("A. Enter your City	: ");
        String city = input.next();
        System.out.println("B. Enter your Nationality	: ");
        String nationality = input.next();
        System.out.println("C. Enter your FullAdress	: ");
        String fulladress = input.next();
        acount people = new acount(nama, job, gender, username, password, securityanswer, securityquestion, startDate, email);
        people.setAlamat(city, nationality, fulladress);
        System.out.print(people.getNama());
        list_akun.add(people);

    }//done

    public void menu_teman(acount people, acount teman) {
        System.out.println("1. Lihat Profile  ");
        System.out.println("2. Kirim pesan ");
        System.out.println("3. exit ");
        int pil = input.nextInt();
        switch (pil) {
            case 1:
                System.out.println("nama        : " + teman.getNama());
                System.out.println("gender      : " + teman.getGender());
                System.out.println("pekerjaan   : " + teman.getJob());
                System.out.println("Kota        : " + teman.getAlamat().getcity());
                System.out.println("Negara      : " + teman.getAlamat().getnation());
                System.out.println("email       : " + teman.getEmail());

                break;
            case 2:
                System.out.println("tulis pesan anda");
                String a = input.nextLine();
                message m = new message(a, new Date(), people);
                people.sendmessage(teman, m);
                people.getPesan().get(0);

        }

    }//done

    public void menu_pesan(acount people) throws Exception {
        System.out.println("1. Kirim pesan");
        System.out.println("2. Lihat pesan  ");
        int pil = input.nextInt();
        switch (pil) {
            case 1:
                System.out.println("masukan usename teman yang akan di kirimkan pesan ");
                try {
                    String username = input.next();
                    acount p = people.searchfriend(username);
                    input.nextLine();
                    System.out.println("masukan pesan yang ingin anda kirim ");
                    String pesan = input.nextLine();
                    message m = new message(pesan, new Date(), p);
                    people.sendmessage(p, m);

                } catch (Exception ex) {
                    throw new Exception("terjadi kesalahan ");
                } finally {
                    Scanner input = new Scanner(System.in);
                }
                break;
            case 2:
                for (message pes : people.getPesan()) {
                    System.out.println("to :" + pes.getP().getNama());
                    System.out.println(pes.getM());
                }
                break;
            case 3:
                break;
        }
    }// done 

    public acount cari_akun() {
        System.out.println("Masukan username :");
        acount tmp = null;
        boolean ketemu = false;
        String t = input.next();
        for (acount people : list_akun) {
            if (people.getUsername().equalsIgnoreCase(t)) {
                tmp = people;
                ketemu = true;
                break;
            }
        }
        return tmp;
    }// done 

    public group cari_group() {
        input.nextLine();
        System.out.println("masukan nama grup yang ingin diikuti :");
        String nama_cari = input.nextLine();
        group tmp = null;
        boolean ketemu = false;
        String t = input.next();
        for (group g : list_grup) {
            if (g.getNama().equalsIgnoreCase(nama_cari)) {
                tmp = g;
                ketemu = true;
                break;
            }
        }
        return tmp;
    }//done

    public void timeline(acount people) {
        System.out.println("Timeline");
        int k = 1;
        ArrayList<text> tmp = new ArrayList<>();
        for (int i = 0; i < people.getNumberoffriend(); i++) {
            for (int j = 0; j < people.getFriend(i).getStatus().size(); i++) {
                tmp.add(people.getFriend(i).getStatus().get(j));
                System.out.println(k + ". " + people.getFriend(i).getStatus().get(j).getT());
                System.out.println("jumlah like :" + people.getFriend(i).getStatus().get(j).getLike());
            }
        }
        System.out.println("Comment atau like Status ");
        System.out.println("Masukan nomor Status  ");
        int cl = input.nextInt();
        System.out.println("Comment tekan 1 ");
        System.out.println("Like tekan 2 ");
        int cpm = input.nextInt();
        input.nextLine();
        switch (cpm) {
            case 1:
                String a = input.nextLine();
                tmp.get(cpm).setComment(a);
                System.out.println(tmp.get(cpm));
                for(String c : tmp.get(cpm).getComment()){
                    System.out.println(c);
                }
                break;
            case 2:
                tmp.get(cpm).addlike();
                break;
        }

    }//done

    public void menu_grup(acount people, group grup ) {
        System.out.println(grup.getNama());
        System.out.println(grup.getDescription());
        System.out.println("1. Lihat timeline group");
        System.out.println("2. Lihat pesan group ");
        System.out.println("3. Kirim pesan group ");
        System.out.println("4. Lihat anggota group ");
        int pil = input.nextInt();
        switch(pil){
            case 1:
                int k=0;
                ArrayList<text> tmp = new ArrayList<>();
                for(text s:grup.getStatus()){
                    tmp.add(s);
                    System.out.println(k+" . "+s.getT());
                    System.out.println("jumlah like :" + s.getLike());
                    k++;
                }
                break;
            case 2: 
                int a=0;
                for(message m:grup.getPesan()){
                    System.out.println(a+" . "+m.getP());
                    a++;
                }
                break;
            case 3: 
                break;
        }
    }//not done

    public void menu_pribadi(acount people) throws Exception {
        int pil = 0;
        while (pil != 7) {
            System.out.println("1. Teman ");
            System.out.println("2. Profile ");
            System.out.println("3. Timeline ");
            System.out.println("4. Pesan ");
            System.out.println("5. Group ");
            System.out.println("6. Buat Status baru");
            pil = input.nextInt();
            switch (pil) {
                case 1:
                    System.out.println("1. Cari Teman   ");
                    System.out.println("2. Lihat daftar teman ");
                    System.out.println("3. Tambahkan teman ");
                    int p = input.nextInt();
                    switch (p) {
                        case 1:
                            //mencari teman dan menampilkan data teman 
                            System.out.println("Masukan username : ");
                            String u = input.next();
                            menu_teman(people, people.searchfriend(u));

                            break;
                        case 2:
                            //menampilkan  nama teman yang dimiliki
                            System.out.println("Daftar nama teman");
                            for (int i = 0; i < people.getNumberoffriend(); i++) {
                                int num = i + 1;
                                System.out.println(num + " " + people.getFriend(i).getNama());
                            }
                            break;
                        case 3:
                            //mencari teman baru berdasarkan username 
                            try {
                                acount c = cari_akun();
                                System.out.println("nama :" + c.getNama());
                                System.out.println("Tambahkan sebagai teman (Y/N) ?");
                                String tambah = input.next();
                                if ("Y".equals(tambah)) {
                                    people.addfriend(c);
                                } else if ("N".equals(tambah)) {
                                    System.out.println("Tidak jadi ditambahkan ");
                                }
                            } catch (NullPointerException e) {
                                System.out.println("");
                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.println("nama        : " + people.getNama());
                    System.out.println("gender      : " + people.getGender());
                    System.out.println("pekerjaan   : " + people.getJob());
                    System.out.println("Kota        : " + people.getAlamat().getcity());
                    System.out.println("Negara      : " + people.getAlamat().getnation());
                    System.out.println("email       : " + people.getEmail());
                    break;
                case 3:
                    timeline(people);
                    break;
                case 4:
                    menu_pesan(people);
                    break;
                case 5:
                    System.out.println("1. Buat Grup baru   ");
                    System.out.println("2. Join Grup ");
                    System.out.println("3. Lihat Grup yang diikuti ");
                    int g = input.nextInt();
                    switch (g) {
                        case 1:
                            System.out.println(" Buat group baru ");
                            input.nextLine();
                            System.out.println("masukan nama grup      :");
                            String nama = input.nextLine();
                            input.nextLine();
                            System.out.println("masukan deskripsi grup :");
                            String deskripsi = input.nextLine();
                            group grup = new group(people, nama, deskripsi, new Date());
                            list_grup.add(grup);
                            people.addgroup(grup);
                            break;
                        case 2:
                            group gr = cari_group();
                            System.out.println("Apakah anda ingin bergabung dengan group ini ?");

                            break;
                        case 3:
                            System.out.println("masukan nama grup      :");
                            String nama_grup = input.nextLine();
                            break;

                    }
                    break;
                case 6:
                    System.out.println("Tulis status anda   ");
                    input.nextLine();
                    String a = input.nextLine();
                    text s = new text(a, new Date());
                    people.addstatus(s);
                    break;
            }
        }
    }//not done

    public void login() throws Exception {
        // fungsi agar user dapat melakukan login
        boolean ketemu = false;
        boolean ulang = false;
        while (ulang != true) {
            System.out.println("Log In menu");
            System.out.println("Username :");
            String username = input.next();
            System.out.println("Password :");
            String password = input.next();
            int j = 0;
            while (list_akun.size() > j) {
                if (username.equalsIgnoreCase(list_akun.get(j).getUsername()) && password.equalsIgnoreCase(list_akun.get(j).getPassword())) {
                    ketemu = true;
                    break;
                }
                j++;
            }
            if (!ketemu) {
                //jika password dan username salah 
                System.out.println("username atau password salah");
                System.out.println("ingin mencoba login lagi ?");
                String a = input.next();
                if (a.equalsIgnoreCase("Y")) {
                    ulang = false;
                } else if (a.equalsIgnoreCase("N")) {
                    ulang = true;
                }

            } else {
                menu_pribadi(list_akun.get(j));
                ulang = true;
            }
        }
    }//done

    public static void main(String[] args) {
        main m = new main();
        try {
            m.testing_user();
            m.login();
        } catch (Exception ex) {

        }
    }//test 

}
