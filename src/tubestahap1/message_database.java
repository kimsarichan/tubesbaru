/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tubestahap1;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A450LC W8
 */
public class message_database {
    Database db;
    acount activea,friend;
    public message_database(acount activea,acount friend){
        this.activea=activea;
        db= new Database();
    };
    public void save_message(message m){
       db.connect();
       String query="INSERT INTO `log_message_personal`( `time_log_message_p`, `sender_idaccount_p`, `receiver_idaccount`, `message_p`) VALUES (NOW(),"+m.getP().getIdacount()+","+m.getR().getIdacount()+",'"+m.getM()+"')";
       System.out.println(query);
       db.execute(query);
    }
    public ArrayList<message> loadmessage(){
        db.connect();
        ArrayList<message> pesan = new ArrayList();
        String query= "SELECT nama, `time_log_message_p`,  `message_p` FROM `log_message_personal` join account on (sender_idaccount_p=id_account)  WHERE (sender_idaccount_p= "+activea.getIdacount()+" and receiver_idaccount_p = "+friend.getIdacount()+" ) or (sender_idaccount_p = "+friend.getIdacount()+" and receiver_idaccount"+activea.getIdacount()+" )";
        System.out.println(query);
        ResultSet rs= db.getData(query);
        try {
            while(rs.next()){
                String a=rs.getString(1)+" : "+rs.getString(3);
                message m= new message(a,rs.getDate(2));
                pesan.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(message_database.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.close();
        return pesan;
    }
    public void save_message_group(group g , String message_group ){
       db.connect();
       String query="INSERT INTO `log_message_group`( `id_group`, `time_log_message_g`, `message_g`) VALUES ("+g.getIdgroup()+",NOW(),'"+message_group+"')";;
       System.out.println(query);
       db.execute(query);
       System.out.println(query);
       db.execute(query);
    }
    public ArrayList<String> message_group(group g){
        ArrayList<String> pesan = new ArrayList();
        String query= "SELECT `nama`, `time_log_message_g`,  `message_g`,  FROM `log_message_group` join account using(id_account)  WHERE (id_group= "+g.getIdgroup()+") ORDER BY id_messsage_g DESC";
        System.out.println(query);
        ResultSet rs= db.getData(query);
        try {
            while(rs.next()){
                String a=rs.getString(1)+" : "+rs.getString(3);
                pesan.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(message_database.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.close();
        return pesan;
    }
}
