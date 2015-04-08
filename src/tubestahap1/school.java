class school  {
	private String schoolname;
	private  int yearattended;
	private int yeargraduated;

	public school(String schoolname, int yearattended){
		this.schoolname=schoolname;
		this.yearattended=yearattended;
	}
	public void setschoolname(String schoolname){
		this.schoolname=schoolname;
	}
	public void setyearattended(int yearattended){
		this.yearattended=yearattended;
	}
	public void setyeargraduated(int yeargraduated){ 
		this.yeargraduated=yeargraduated;
	}
	public String schoolname(){
		return  schoolname;
	}
	public  int yeargraduated(){
		return yeargraduated;
	}
	public  int yearattended(){
		return yearattended;
	}
	public void editsekolah(String name , int yeara , int yearg){
			System.out.println("=== edit sekolah =====");
			System.out.println("masukan nama sekolah:");
			setschoolname(name);
			System.out.println("masukan tahun masuk : ");
			setyearattended(yeara);
			System.out.println("masukan tahun lulus : ");
			setyeargraduated(yearg);
	}

}