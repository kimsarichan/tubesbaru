package tubestahap1;

class network {

    private acount[] akun;
    private  group[] grup;
    private int numberofakun;
    private int numberofgrup;

    public network(int na, int ng) {
        akun = new acount[na];
        grup = new group[ng];
    }
    public acount getakun(int id){
        return akun[id];
    }
    public group getgrup(int id){
        return grup[id];
    }
    public int getnumberofakun(){
        return numberofakun;
    }
     public int getnumberofgroup(){
        return numberofgrup;
    }
    public void addakun(acount a) {
        akun[numberofakun] = a;
        numberofakun = numberofakun + 1;
    }

    public void addgrup(group g) {
        grup[numberofgrup] = g;
        numberofgrup = numberofgrup + 1;
    }

    public acount searchakunbyusername(String i) {
        //mencari akun berdasarkan username 
        return null;

    }
    public acount searchakunbycity(String i) {
        return null;

    }
    public acount searchakunbysekolah(String s){
        return null ;
    }
}
