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
            "WHERE status.id_account = ( \n" +
            "SELECT id_account2\n" +
            "FROM log_friend\n" +
            "WHERE id_account1 ="+activea.getIdacount()+" ) \n" +
            "OR id_account ="+ activea.getIdacount() +"\n" +
            "LIMIT 0 , 30";
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
        t.addlike();
        String query= "INSERT INTO `log_activity_status`( `id_status`, `time_activity_status`, `like_idaccount`) VALUES ("+t.getId_status()+",NOW(), "+t.getLike()+")";
        db.execute(query);
        db.close();
    }
     public void updatecomment(text t, String c){
        db.connect();
        t.setComment(c);
        String query= "INSERT INTO `log_activity_status`( `id_status`, `time_activity_status`, `comment_idaccount`, comment_desc) VALUES ("+t.getId_status()+",NOW(), "+activea.getIdacount()+",'"+t.getComment()+"')";
        db.execute(query);
        db.close();
    }
}
