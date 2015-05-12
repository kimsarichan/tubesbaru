/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tubestahap1;

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
public class timeline {
    Database db;
    ArrayList<text> Stat;
    acount activea;
    public timeline(acount activea){
         this.activea=activea;
         db= new Database();
    }
    public void savestatus(String s)
    {
        db.connect();
        text status= new text(activea.getNama(), s, new Date()); 
        String query = "INSERT INTO `status`(`id_account`, `status_desc`, `tanggal`) VALUES ('"+activea.getIdacount()+"','"+status.getT()+"','"+ new java.sql.Date(status.getTglkirim().getTime())+"')";
        db.execute(query);
        db.close();
    }
    public text loadstat(int id_status){
        text s=null;
        try {
            db.connect();
            String query="Select id_status, nama , status_desc, tanggal from status where id_status = "+id_status;
            ResultSet rs = db.getData(query);
            s= new text(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getDate(4));
            db.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(timeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    public ArrayList<text>  loadstatus()
    {
        ArrayList<text>  list= new ArrayList();
        try {
            db.connect();
            String query="SELECT id_status , nama, status_desc, tanggal\n" +
            "FROM \n" +
            "STATUS JOIN account\n" +
            "USING ( id_account ) \n" +
            "WHERE status.id_account IN ( \n" +
            "SELECT id_account2\n" +
            "FROM log_friend\n" +
            "WHERE id_account1 ="+activea.getIdacount()+" ) \n" +
            "OR id_account ="+ activea.getIdacount() +"\n" + "OR id_account IN (SELECT id_account1 from log_friend WHERE id_account2 ="+activea.getIdacount()+") ORDER BY id_status  DESC ";
            ResultSet rs = db.getData(query);
            while(rs.next()){
                text stat = new text(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getDate(4));
                list.add(stat);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(timeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.close();
        return list;
    }
    public void updatelike(text t){
        db.connect();
        String query= "INSERT INTO `log_activity_status`( `id_status`, `time_activity_status`, `like_idaccount`) VALUES ("+t.getId_status()+",NOW(), "+t.getLike()+")";
        db.execute(query);
        db.close();
    }
    public int loadlike(text t){
        db.connect();
        String query= "SELECT COUNT( like_idaccount ) \n" +
        "FROM  `log_activity_status` \n" +
        "WHERE id_status = "+t.getId_status();
        ResultSet rs = db.getData(query);
        int a = 0;
        try {
            while(rs.next()){
                a= rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(timeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.close();
        return a;
        
    }
     public void updatecomment(text t, String c){
        db.connect();
        String query= "INSERT INTO `log_activity_status`( `id_status`, `time_activity_status`, `id_account`, comment_desc) VALUES ("+t.getId_status()+",NOW(), "+activea.getIdacount()+",'"+c+"')";
        db.execute(query);
        db.close();
    }
     public ArrayList<String> load_comment(text t){
        db.connect();
        String query= "SELECT nama, comment_desc\n" +
        "FROM  `log_activity_status` \n" +
        "JOIN account\n" +
        "USING ( id_account ) \n" +
        "WHERE id_status = "+t.getId_status()+"\n" +
        "LIMIT 0 , 30";
        ResultSet rs = db.getData(query);
        ArrayList<String> list= new ArrayList(); 
        String comment = null;
        try {
            while(rs.next()){
                comment = rs.getString(1)+" : "+rs.getString(2);
                list.add(comment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(timeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
     }
}
