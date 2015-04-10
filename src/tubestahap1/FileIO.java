/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tubestahap1;

import java.io.*;

/**
 *
 * @author A450LC W8
 */
public class FileIO {
    public void saveLog(String log , String filename)throws IOException{
        try{
         FileWriter fw = new FileWriter(filename,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(log+ System.lineSeparator());
            bw.close();
            fw.close();
            System.out.println("Done");
        }
        catch(Exception e){
            throw e;
        }
       
    }
    public String readLog(String filename ) throws IOException {
        String isi= "";
        try{
            FileReader f = new FileReader(filename);
            BufferedReader br = new BufferedReader(f);
                String line ="";
                while ((line = br.readLine()) != null) {
                    isi += line + "\n";
                }
             br.close();
             f.close();
        }
        catch(Exception e){
            throw e;
        }
        return isi ;
    }   
    public void saveObject (Object o , String filename)throws FileNotFoundException, IOException{
	try{
            FileOutputStream fos=new FileOutputStream(filename,true);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(o);
            oos.flush();
            fos.close();
        }
        catch(Exception e){
            throw e;
        }

    }
    public Object loadObject (String filename) throws FileNotFoundException , IOException, ClassNotFoundException, EOFException{
        Object o= null;
        try(FileInputStream fis =new FileInputStream(filename)){
            ObjectInputStream ois=new ObjectInputStream(fis);
            o = ois.readObject();
        }
        catch(Exception e){
            throw e;
        }
        return o;
    }
}
