package tubestahap1;

class adress {

    private String city;
    private String nation;
    private String fulladress;

    public adress(String city, String nation, String fulladress) {
        this.city = city;
        this.nation = nation;
        this.fulladress = fulladress;
    }

    public void setcity(String city) {
        this.city = city;
    }


    public void setnation(String nation) {
        this.nation = nation;
    }

    public void setfulladress(String fulladress) {
        this.fulladress = fulladress;
    }

    public String getcity() {
        return city;
    }

    public String getnation() {
        return nation;
    }

    public String getfulladress() {
        return fulladress;
    }

}
