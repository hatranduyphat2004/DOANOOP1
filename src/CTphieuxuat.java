import java.io.Serializable;
import java.util.Scanner;
public class CTphieuxuat implements Serializable{
    private String maSanPham;
    private String maPhieuXuat;
    private String tenSanPham;
    private int soLuong;
    private int n;
    private long tongTien;
    private long dongia;
    public static int count=0;
    transient  Scanner sc = new Scanner(System.in);
    public CTphieuxuat(int n,String maPhieuXuat,String maSanPham,String tenSanpham,int soluong,long dongia,long tongTien){
        this.tenSanPham=tenSanpham;
        this.maPhieuXuat=maPhieuXuat;
        this.soLuong=soluong;
        this.dongia=dongia;
        this.tongTien=tongTien;
        this.n=n;
        count++;
    }
    public CTphieuxuat() {
        count++;
        maPhieuXuat=null;
        maSanPham =null;
        tenSanPham =null;
        soLuong = 0;
        dongia=0;
        tongTien = soLuong*dongia;
        n=count;
    }
    
    public String getMaPhieuXuat() {
        return maPhieuXuat;
    }
    public void setMaPhieuXuat(String maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }
    public long getDongia() {
        return dongia;
    }
    public void setDongia(long dongia) {
        this.dongia = dongia;
    }
    public int getCount(){
        return count;
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
    public void nhap() {
        
    }
    public void xuat() {
        System.out.printf("%-5d%-10s%-15s%-20s%-15d%-15d%-15d\n",n,maPhieuXuat,maSanPham,tenSanPham,soLuong,dongia,tongTien);
    }
    
    @Override
    public String toString() {
        return n+" "+maPhieuXuat+" "+maSanPham+" "+tenSanPham+" "+soLuong+" "+dongia+" "+tongTien;
    }
    public static void main(String[] args) {
        CTphieuxuat ctpx = new CTphieuxuat();
        ctpx.nhap();
        ctpx.xuat();
    }
}
