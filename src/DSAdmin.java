public class DSAdmin {
    public ADMIN[] dsAdmins;
    private int n;
    public DSAdmin(ADMIN[] dsAdmins,int n){
        this.dsAdmins=dsAdmins;
        this.n=n;
    }
    public DSAdmin(){
        dsAdmins=null;
        n=0;
    }
    public void admin(){
        n=2;
        dsAdmins=new ADMIN[n];
        ADMIN a=new ADMIN();
        a.setTendangnhap("admin1");
        a.setMatkhau("123456@");
        dsAdmins[0]=a;
        ADMIN b=new ADMIN();
        b.setTendangnhap("admin2");
        b.setMatkhau("@123456");
        dsAdmins[1]=b;
    }
    public void xuatadmin(){
        System.out.println(dsAdmins[0].getTendangnhap());
        System.out.println(dsAdmins[0].getMatkhau());
        System.out.println(dsAdmins[1].getTendangnhap());
        System.out.println(dsAdmins[1].getMatkhau());
    }
    public static void main(String[] args){
        DSAdmin a=new DSAdmin();
        a.admin();
        a.xuatadmin();
    }
}
