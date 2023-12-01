import java.io.Serializable;
import java.util.Scanner;
public class PhieuNhap implements Serializable{
    private String mapn;
    private String maNhanVien;
    private String maNhaCungCap;
    private DATE ngaynhap;
    transient Scanner sc = new Scanner(System.in);
    public PhieuNhap(String maNhanVien, String maNhaCungCap, DATE ngaynhap,String mapn) {
        this.maNhanVien = maNhanVien;
        this.maNhaCungCap = maNhaCungCap;
        this.ngaynhap = ngaynhap;
        this.mapn=mapn;
    }
    public PhieuNhap() {
        maNhanVien = null;
        maNhaCungCap = null;
        ngaynhap = new DATE();
        mapn=null;
        
    }
    public String getMapn() {
        return mapn;
    }
    public void setMapn(String mapn){
        this.mapn=mapn;
    }
    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }
    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }
    public DATE getNgaynhap() {
        return ngaynhap;
    }
    public void setNgaynhap(DATE ngaynhap) {
        this.ngaynhap = ngaynhap;
    }
    public void nhap() {
        mapn=Check.nhapChuoi("Nhap ma phieu nhap: ", "Error");
        ngaynhap=Check.nhapNgayThang("Ngay nhap phieu: ","Error");
    }
    public void xuat() {
        System.out.println("                          -------------PHIEU NHAP-------------");
        System.out.println("                                          ++++");
        System.out.printf("CONG TY: %-25sNHANVIEN: %-25sMPN: %-10sNGAY NHAP: %-18s\n",maNhaCungCap,maNhanVien,mapn,ngaynhap);
        System.out.printf("%-5s%-10s%-15s%-20s%-15s%-15s%-15s\n","STT","MPN","MA SAN PHAM","TEN SAN PHAM","SO LUONG","DON GIA","THANH TIEN");
    }
    
    @Override
    public String toString() {
        return mapn+" "+maNhanVien+" "+maNhaCungCap+" "+ngaynhap.toString();
    }
    public static void main(String[] args) {
        
    }
}
