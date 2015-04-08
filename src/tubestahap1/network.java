package tubestahap1;

class network {

    public acount[] akun;
    public group[] grup;
    private int numberofakun;
    private int numberofgrup;

    public network(int na, int ng) {
        akun = new acount[na];
        grup = new group[ng];
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

    }

}
