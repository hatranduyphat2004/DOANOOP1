import java.io.Serializable;
import java.util.Scanner;
public class PhieuXuat implements Serializable{
    private String maPhieuXuat;
    private String maNhanVien;
    private String maKhachHang;
    private DATE ngayXuat;
    transient Scanner sc = new Scanner(System.in);
    
    public PhieuXuat(String maNhanVien, String maKhachHang, DATE ngayXuat,String maPhieuXuat) {
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.ngayXuat = ngayXuat;
        this.maPhieuXuat=maPhieuXuat;
    }
    public PhieuXuat(){
        maPhieuXuat=null;
        maNhanVien = null;
        maKhachHang = null;
        ngayXuat = new DATE();
    }
    
    public String getMaPhieuXuat() {
        return maPhieuXuat;
    }
    public void setMaPhieuXuat(String maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }
    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    public String getMaKhachHang() {
        return maKhachHang;
    }
    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    public DATE getNgayXuat() {
        return ngayXuat;
    }
    public void setNgayXuat(DATE ngayXuat) {
        this.ngayXuat = ngayXuat;
    }
    
    public void nhap() {
        maPhieuXuat=Check.nhapChuoi("Nhap ma phieu xuat: ","Error");
        ngayXuat=Check.nhapNgayThang("Nhap ngay nhap phieu: ", "Error");
    }
    public void xuat() {
        System.out.println("                          -------------PHIEU XUAT-------------");
        System.out.println("                                          ++++");
        System.out.printf("KHACH HANG: %-25sNHAN VIEN: %-25sMPX: %-10sNGAY XUAT: %-18s\n",maKhachHang,maNhanVien,maPhieuXuat,ngayXuat);
        System.out.printf("%-5s%-10s%-15s%-20s%-15s%-15s%-15s\n","STT","MPX","MA SAN PHAM","TEN SAN PHAM","SO LUONG","DON GIA","THANH TIEN");
    }
    @Override
    public String toString() {
        return maPhieuXuat+" "+maNhanVien+" "+maKhachHang+" "+ngayXuat.toString();
    }
    public static void main(String[] args) {
        PhieuXuat px = new PhieuXuat();
        px.nhap();
        px.xuat();
    }
}
