/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubestahap1;

import java.util.Scanner;
import java.util.*;

public class home {

    Scanner input = new Scanner(System.in);
    network friendsbook = new network(10, 5);//menginisiasi network dan mengeset jumlah akun yang akan tersedia 10 , jumlah grup 5 
    boolean exit = false;

    public void menu(acount a) {
        int i =0;
        while (i != 5) {
            System.out.println("1. Messages");
            System.out.println("2. Search");
            System.out.println("3. Timeline");
            System.out.println("4. Group");
            System.out.println("5. Logout & exit ");
            System.out.println("Pilih menu :");
            i = input.nextInt();
            switch (i) {
                case 1:
                //view messages from friends
                    //send messages
                    break;
                case 2:
                //searchGroup
                    //SearchFriendbyUsername
                    //SearchFriendbyCity
                    //SearchFriendbySchool
                    //add/join group/friends

                    break;
                case 3:
                //add status
                    //like commet
                    //view friends timeline
                    break;
                case 4:
                //create  Group
                    //show joined group
                    //show group profile
                    //Show group messages
                    //send chat messages in group
                    //invite group
                    //addnote
                    break;
                case 5:
                    exit = true;
                    break;
            }
        }
    }

    public void login() {
        //fungsi agar user dapat melakukan login
        boolean ketemu = false;
        acount tmp = null; // akun yang akan 
        System.out.println("Log In menu");
        System.out.println("Username :");
        String username = input.next();
        System.out.println("Password :");
        String password = input.next();
        for (int i = 0; i < friendsbook.getnumberofakun(); i++) {
            if (friendsbook.getakun(i).getUsername().equalsIgnoreCase(username) && friendsbook.getakun(i).getPassword().equalsIgnoreCase(password)) {
                tmp = friendsbook.getakun(i);
                ketemu = true;
                break;
            }
        }
        if (ketemu == true) {
            menu(tmp);
        } else {
            System.out.println("username atau password salah");
        }
    }

    public void home() {
        acount a = new acount("sa", "jobs", "p", "kimsarichan", "1235", "adres", "adres", new Date(1995, 11, 11));
        acount b = new acount("sari", "jobs", "p", "adrian", "1235", "adres", "adres", new Date(1995, 11, 11));
        acount c = new acount("ada", "jobs", "p", "myra", "1235", "adres", "adres", new Date(1995, 11, 11));
        friendsbook.addakun(a);
        friendsbook.addakun(b);
        friendsbook.addakun(c);
        System.out.println("Welcome to FriendsBook");
        System.out.println("1. Log in to Friendsbook");
        System.out.println("2. Sign Up now !!");
        System.out.println("3. Forgot pass ");
        System.out.println("Pilih menu awal :");
        int main_menu = input.nextInt();
        switch (main_menu) {
            case 1:
                login();
                break;

            case 2:
                break;
            case 3:

                break;
        }
    }

}
