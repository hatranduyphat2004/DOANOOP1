import java.io.Serializable;
import java.util.Scanner;

public class CTphieunhap implements Serializable{
    private String maSanPham;
    private String tenSanPham;
    private int soLuong;
    private long tongTien;
    private long dongia;
    private int n;
    private String mapn;
    public static int count=0;
    transient Scanner sc = new Scanner(System.in);

    public CTphieunhap(int n,String maSanPham, String tenSanPham, int soLuong,long dongia, long tongTien,String mapn) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.dongia=dongia;
        this.n=n;
        this.mapn=mapn;
        count++;
    }
    public CTphieunhap() {
        super();
        count++;
        maSanPham = "";
        tenSanPham = "";
        soLuong = 0;
        tongTien = soLuong*dongia;
        dongia=0;
        n=count;
        mapn=null;
    }
    
    public String getMapn() {
        return mapn;
    }
    public void setMapn(String mapn) {
        this.mapn = mapn;
    }
    public long getDongia() {
        return dongia;
    }
    public void setDongia(long dongia) {
        this.dongia = dongia;
    }
    public String getMaSanPham() {
        return maSanPham;
    }
    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }
    public String getTenSanPham() {
        return tenSanPham;
    }
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public long getTongTien() {
        return tongTien;
    }
    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }
    public void xuat() {
        System.out.printf("%-5d%-10s%-15s%-20s%-15d%-15d%-15d\n",n,mapn,maSanPham,tenSanPham,soLuong,dongia,tongTien);
    }
    public String toString(){
        return n+" "+mapn+" "+maSanPham+" "+tenSanPham+" "+soLuong+dongia+"  "+tongTien;
    }
    public static void main(String[] args) {
        CTphieunhap ctpn = new CTphieunhap();
        ctpn.xuat();
    }
}
