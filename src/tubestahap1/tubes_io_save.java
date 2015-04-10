/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tubestahap1;
import java.io.*;
import java.util.*;
/**
 *
 * @author A450LC W8
 */
public class tubes_io_save {
    private ArrayList<acount> list_akun ;
    private ArrayList<group> list_grup ;
    private FileIO data;
    public tubes_io_save(){
        list_akun= new ArrayList<>();
        list_grup= new ArrayList<>();
    }
    
    // save and load 
    public void saveakun(acount a) throws IOException {
        try{
            data.saveObject(list,"data_akun.txt");
        }
        catch(IOException e){
            throw new IOException("error IO");
        } 
    }
    public void loadakun() throws IOException {
        try{
            list_akun = (ArrayList<acount>)data.loadObject("data_akun.txt");
        }
        catch(EOFException e){
            list_akun = new ArrayList<>() ;
        }
        catch(FileNotFoundException e){
            File F = new File("data_akun.txt");    
        } 
        catch(IOException e){
            System.out.print("error IO"); 
        } 
        catch (ClassNotFoundException ex) {
            System.out.print("kelas tidak ditemukan");
        } 
    }
    
}
