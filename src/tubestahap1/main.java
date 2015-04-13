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
        people.setAlamat("bandung", "indonesia", "riung ");
        list_akun.add(people);
        acount p = new acount("adrian ", "pelajar", "M", "bla", "bla", "bla", "bla", new Date(), "a@gmail.com");
        people.setAlamat("bandung", "indonesia", "riung ");
        list_akun.add(p);
        text b = new text("nooooo ", new Date());
        list_akun.get(0).addstatus(b);
    }

    public void registrasi() throws Exception {
        System.out.println("Registration");
        System.out.println("1. Username 		: ");
        String username = input.next();
        //cek username ganda
        boolean sama = false;
        for (acount c : list_akun) {
            if (username.equals(username)) {
                sama = true;
                break;
            }
        }
        if (sama) {
            System.out.println("username dapat diterima ");
        } else {
            throw new Exception("Username sudah ada");
        }
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
        //end password sama 
        System.out.println("Security Question : What is your favorite animal ?");
        input.nextLine();
        String securityquestion = ("What is your favorite animal?");
        input.nextLine();
        System.out.println("6. Answer	: ");
        String securityanswer = input.nextLine();
        System.out.println("7. Gender(M/F) 		: ");
        String gender = input.next();
        System.out.println("8. Birthdate(dd-MM-yyyy): ");
        String birth_date = input.next();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate;
        //parse tanggal string to date
        try {
            startDate = df.parse(birth_date);
        } catch (ParseException e) {
            throw e;
        }
        //end parse tanggal
        System.out.println("9. Job	: ");
        String job = input.next();
        System.out.println("Masukan alamat pribadi anda ");
        System.out.println("A. Enter your City	: ");
        String city = input.next();
        System.out.println("B. Enter your Nationality	: ");
        String nationality = input.next();
        input.nextLine();
        System.out.println("C. Enter your FullAdress	: ");
        String fulladress = input.nextLine();
        acount people = new acount(nama, job, gender, username, password, securityanswer, securityquestion, startDate, email);
        people.setAlamat(city, nationality, fulladress);
        System.out.println("data pribadi berhasil di simpan ");
        list_akun.add(people);

    }//done

    public void menu_teman(acount people, acount teman) {
        int pil = 0;
        while (pil != 3) {
            System.out.println("1. Lihat Profile  ");
            System.out.println("2. Kirim pesan ");
            System.out.println("3. exit ");
            pil = input.nextInt();
            switch (pil) {
                case 1:
                    //profile teman
                    System.out.println("nama        : " + teman.getNama());
                    System.out.println("gender      : " + teman.getGender());
                    System.out.println("pekerjaan   : " + teman.getJob());
                    System.out.println("Kota        : " + teman.getAlamat().getcity());
                    System.out.println("Negara      : " + teman.getAlamat().getnation());
                    System.out.println("email       : " + teman.getEmail());

                    break;
                case 2:
                    //kirim pesan pada teman 
                    input.nextLine();
                    System.out.println("tulis pesan anda");
                    String a = input.nextLine();
                    message m = new message(a, new Date(), people);
                    people.sendmessage(teman, m);
                    people.getPesan().get(0);

            }
        }

    }//done

    public void menu_pesan(acount people) throws Exception {
        int pil = 0;
        while (pil != 3) {
            System.out.println("1. Kirim pesan");
            System.out.println("2. Lihat pesan  ");
            pil = input.nextInt();
            switch (pil) {
                case 1:
                    //mengirim pesan 
                    System.out.println("masukan usename teman yang akan di kirimkan pesan ");
                    try {
                        String username = input.next();
                        acount p = people.searchfriend(username);
                        input.nextLine();
                        System.out.println("masukan pesan yang ingin anda kirim ");
                        String pesan = input.nextLine();
                        message m = new message(pesan, new Date(), people);
                        people.sendmessage(p, m);

                    } catch (Exception ex) {
                        throw new Exception("terjadi kesalahan ");
                    } finally {
                        Scanner input = new Scanner(System.in);
                    }
                    break;
                case 2:
                    //melihat pesan yang ada pada akun
                    for (message pes : people.getPesan()) {
                        System.out.println("from :" + pes.getP().getNama());
                        System.out.println(pes.getM());
                    }
                    break;
            }
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
        try {
            System.out.println("Timeline");
            int k = 1;
            ArrayList<text> tmp = new ArrayList<>();
            for (int i = 0; i < people.getNumberoffriend(); i++) {
                for (int j = 0; j < people.getFriend(i).getStatus().size(); i++) {
                    tmp.add(people.getFriend(i).getStatus().get(j));
                    System.out.println(k + ". " + people.getFriend(i).getStatus().get(j).getT());
                    System.out.println("jumlah like :" + people.getFriend(i).getStatus().get(j).getLike());
                    k++;
                }
            }
            for (text s : people.getStatus()) {
                tmp.add(s);
                System.out.println(k + ". " + s.getT());
                System.out.println("jumlah like :" + s.getLike());
                k++;
            }
            System.out.println("Comment atau like Status ");
            System.out.println("Masukan nomor Status  ");
            int cl = input.nextInt();
            cl=cl-1;
            System.out.println("Comment tekan 1 ");
            System.out.println("Like tekan 2 ");
            int cpm = input.nextInt();
            input.nextLine();
            switch (cpm) {
                case 1:
                   
                    System.out.println("Masukan comment anda ");
                    String a = input.nextLine();
                    tmp.get(cl).setComment(a);
                    System.out.println(tmp.get(cpm));
                    if(tmp.get(cl).getComment()!= null){
                        for (String c : tmp.get(cl).getComment()) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 2:
                    tmp.get(cl).addlike();
                    System.out.println("status berhasil di like ");
                    break;
            }
        } catch (NullPointerException e) {
            System.out.println("Variable null ditemukan");
        } finally {
            Scanner input = new Scanner(System.in);
        }

    }//done

    public void menu_grup(acount people, group grup) {
        int pil = 0;
        while (pil != 5) {
            System.out.println(grup.getNama());
            System.out.println(grup.getDescription());
            System.out.println("1. Lihat timeline group");
            System.out.println("2. Lihat pesan group ");
            System.out.println("3. Kirim pesan group ");
            System.out.println("4. Lihat anggota group ");
            System.out.println("5. Keluar ");
            pil = input.nextInt();
            switch (pil) {
                case 1:
                    //meihat status status yang dibuat pada grup
                    int k = 0;
                    ArrayList<text> tmp = new ArrayList<>();
                    for (text s : grup.getStatus()) {
                        tmp.add(s);
                        System.out.println(k + " . " + s.getT());
                        System.out.println("jumlah like :" + s.getLike());
                        k++;
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
                            for (String c : tmp.get(cpm).getComment()) {
                                System.out.println(c);
                            }
                            break;
                        case 2:
                            tmp.get(cpm).addlike();
                            break;
                    }

                    break;
                case 2:
                    //melihat pesan yang ada pada grup
                    int a = 0;
                    for (message m : grup.getPesan()) {
                        System.out.println(a + " . " + m.getP());
                        a++;
                    }
                    break;
                case 3:
                    //mengirim pesan pada grup
                    input.nextLine();
                    System.out.println("masukan pesan yang ingin anda kirim ");
                    String pesan = input.nextLine();
                    pesan = "this is grup message \n" + pesan;
                    message m = new message(pesan, new Date(), people);
                    grup.sendpesan(m);
                    break;
                case 4:
                    //melihat daftar nama member pada grup
                    input.nextLine();
                    System.out.println("Daftar member  ");
                    for (int i = 0; i < grup.getNumberofmember(); i++) {
                        grup.getMember(i).getNama();
                    }
                    break;
            }
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
            System.out.println("7. Log Out dan keuar");
            pil = input.nextInt();
            switch (pil) {
                case 1:
                    //menambahkan teman baru dan melihat profile teman yang ada
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
                    //melihat profile user
                    System.out.println("nama        : " + people.getNama());
                    System.out.println("gender      : " + people.getGender());
                    System.out.println("pekerjaan   : " + people.getJob());
                    System.out.println("Kota        : " + people.getAlamat().getcity());
                    System.out.println("Negara      : " + people.getAlamat().getnation());
                    System.out.println("email       : " + people.getEmail());
                    break;
                case 3:
                    // melihat timeline user yang berisi status status 
                    timeline(people);
                    break;
                case 4:
                    //mengirim pesan dan melihat semua pesan 
                    menu_pesan(people);
                    break;
                case 5:
                    //melakukan interaksi pada grup
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
                            System.out.println("Apakah anda ingin bergabung dengan group ini ? (Y/N)");
                            String ans = input.next();

                            break;
                        case 3:
                            System.out.println("masukan nama grup      :");
                            String nama_grup = input.nextLine();
                            group groups = people.searchgrup(nama_grup);
                            menu_grup(people, groups);
                            break;

                    }
                    break;
                case 6:
                    //menulis status baru 
                    System.out.println("Tulis status anda   ");
                    input.nextLine();
                    String a = input.nextLine();
                    text s = new text(a, new Date());
                    people.addstatus(s);
                    break;
            }
        }
    }// done

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

    public void menu_utama() {
        int pil = 0;
        Scanner input = new Scanner(System.in);
        try {
            while (pil != 3) {
                testing_user();
                System.out.println("Welcome to friendsbook");
                System.out.println("1. Registrasi");
                System.out.println("2. Login");
                System.out.println("3. Forget password  ");
                System.out.println("4. Exit  ");
                pil = input.nextInt();
                switch (pil) {
                    case 1:
                        registrasi();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                        break;
                }

            }
        } catch (InputMismatchException e) {

            System.out.print("Input harus integer");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        main m = new main();
        m.menu_utama();

    }//test 

}
