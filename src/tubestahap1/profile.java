import java.util.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
class profile  {
	SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
	protected String nama;
	protected String job;
	protected school sekolah[]=new school[5] ;
	protected int nsekolah;
	protected String gender;
	public adress alamat;
	public  String username;
	private String password;
	protected String securityquestion;
	protected String securityanswer;
	protected Date tgl;
	public profile(String nama , String job , String gender , String username , String password , String securityanswer , String securityquestion , String tanggal ){
		try { 
			this.nama=nama;
			this.gender=gender;
			this.job=job;
			this.username=username;
			this.password=password;
			this.securityanswer=securityanswer;
			this.securityquestion=securityquestion;
			tgl = format.parse(tanggal);
		}
		catch (ParseException e) {
			System.out.println("salah format tanggal "); 
		}

	}
	public void addschool(String schoolname, int yearattended){
		sekolah[nsekolah]= new school(schoolname,yearattended);
		nsekolah=nsekolah+1;
	}
	public void changepass(String p){
		password=p;
	}
	public void forgetpass(String securityans){
		Scanner s= new Scanner(System.in);
		System.out.println("jawab pertanyaan dibawah ini ");
		System.out.println(s.next());
		if (securityans.equals(securityanswer)) {
			System.out.println("tulis password baru ");
			changepass(s.next());
		}
		else {
			System.out.println("jawaban anda salah");
		}
	}

}