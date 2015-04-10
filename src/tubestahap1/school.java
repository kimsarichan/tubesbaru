package tubestahap1;

class school {

    private String schoolname;
    private int yearattended;
    private int yeargraduated;
    
    //constructor
    public school(String schoolname, int yearattended) {
        this.schoolname = schoolname;
        this.yearattended = yearattended;
    }
    
    //setter and getter
    public void setschoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public void setyearattended(int yearattended) {
        this.yearattended = yearattended;
    }

    public void setyeargraduated(int yeargraduated) {
        this.yeargraduated = yeargraduated;
    }

    public String schoolname() {
        return schoolname;
    }

    public int yeargraduated() {
        return yeargraduated;
    }

    public int yearattended() {
        return yearattended;
    }
    //edit
    public void editsekolah(String name, int yeara, int yearg) {
        setschoolname(name);
        setyearattended(yeara);
        setyeargraduated(yearg);
    }

}
