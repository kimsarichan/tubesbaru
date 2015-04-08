import java.text.SimpleDateFormat;
import java.util.Date;
class acount extends profile {
	private  acount friend[]=new acount[100]; 
	private  message pesan[]=new message[100];
	private  status stat[]=new status[100];
	private  int numberoffriend;
	private  int numberofgroup;
	private  int numberofpesan;
	private  int numberofstatus;
	private  String notification;
	public 	acount(String nama , String job , String gender , String username , String password , String securityanswer , String securityquestion , String tanggal ){
		super( nama ,  job ,  gender ,  username , password , securityanswer , securityquestion , tanggal );
	}
	public void addfriend(acount f){
			friend[numberoffriend]=f;
			numberoffriend=numberoffriend+1;
	}
	public acount searchfriend(String nama) throws Exception{
		int i=0;
		acount a= null;
		boolean ketemu=false;
		while(i<numberoffriend && ketemu == false){
			if (friend[i].nama.equals(nama)) {
				a= friend[i];
				ketemu=true;
			}
			i++;
		}
		if (ketemu == true ) {
			return a;
		}
		else{
			throw new notfoundexception("teman tidak ditemukan");
		}
		
	}
	public void sendmessage(acount f, message m){
		pesan[numberofpesan]=m;
		numberofpesan=numberofpesan+1;
	}
	public void addstatus(status s){
		stat[numberofstatus]=s;
		numberofstatus=numberofstatus;
	}
	public String getnotification(){
		return  notification;
	}

	public static void main(String[] args) {
		try{
			acount a= new acount("sa", "jobs" ,"p", "sarichantik" , "1235","adres" , "adres" , "20/02/1995");
			acount b= new acount("sari", "jobs" ,"p", "sarichantik" , "1235","adres" , "adres" , "20/02/1995");
			acount c= new acount("ada", "jobs" ,"p", "sarichantik" , "1235","adres" , "adres" , "20/02/1995");
			a.addfriend(b);		
			a.addfriend(c);
			System.out.println(a.searchfriend("ada").nama);
			System.out.println(a.searchfriend("yusril").nama); 

			message m=new message()
		}
		catch (ParseException e) {
			System.out.println("salah format tanggal "); 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}