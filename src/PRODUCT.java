import java.io.Serializable;
import java.util.Scanner;

public abstract class PRODUCT implements Serializable{
    protected String brand;
    protected String tensp;
    protected String masp;
    protected long dongia;
    protected int soluong;
    protected DATE NSX;
    public static int count = 0;
    transient Scanner sc = new Scanner(System.in);
    
    public PRODUCT(String brand, String tensp, String masp, long dongia, int soluong, DATE NSX) {
        this.brand = brand;
        this.tensp = tensp;
        this.masp = masp;
        this.dongia = dongia;
        this.soluong = soluong;
        this.NSX = NSX;
        count++;
    }

    public PRODUCT() {
        brand = null;
        tensp = null;
        masp = null;
        dongia = 0;
        soluong = 0;
        count++;
    }

    public String getbrand() {
        return brand;
    }

    public String gettensp() {
        return tensp;
    }

    public String getmasp() {
        return masp;
    }

    public long getdongia() {
        return dongia;
    }

    public int getsoluong() {
        return soluong;
    }

    public DATE getNSX() {
        return NSX;
    }

    public static int getCount() {
        return count;
    }

    public void setbrand(String brand) {
        this.brand = brand;
    }

    public void settensp(String tensp) {
        this.tensp = tensp;
    }

    public void setmasp(String masp) {
        this.masp = masp;
    }

    public void setdongia(long dongia) {
        this.dongia = dongia;
    }

    public void setsoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setNSX(DATE NSX) {
        this.NSX = NSX;
    }

    public abstract void nhapPRODUCT();

    public abstract String toString();

    public abstract void xuatPRODUCT();

    public static void main(String[] args) {
    }
}
