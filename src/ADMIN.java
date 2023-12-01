public class ADMIN {
    public String tendangnhap;
    public String matkhau;
    public String getTendangnhap() {
        return tendangnhap;
    }
    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }
    public String getMatkhau() {
        return matkhau;
    }
    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
    public ADMIN(String tendangnhap, String matkhau) {
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
    }
    public ADMIN(){
        tendangnhap=null;
        matkhau=null;
    }
    public static void main(String[] args){}
}