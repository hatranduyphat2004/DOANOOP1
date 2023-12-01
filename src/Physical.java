import java.io.Serializable;
import java.util.Scanner;

public class  Physical extends PRODUCT{
    private String size;
    private String color;
    private int n;
    transient Scanner sc=new Scanner(System.in);
    public Physical(int n,String brand, String tensp, String masp, long dongia, int soluong, DATE NSX, String size,String color) {
        super(brand, tensp, masp, dongia, soluong, NSX);
        this.size = size;
        this.color = color;
        this.n=n;
    }
    public Physical(){
        super();
        size=null;
        color=null;
        n=count;
    }
    public void setsize(String size){
        this.size=size;
    }
    public String getsize(){
        return size;
    }
    public void setcolor(String color){
        this.color=color;
    }
    public String getcolor(){
        return color;
    }
    public void nhapPRODUCT(){
        System.out.println("Day la quan ao");
        brand=Check.nhapChuoi("Thuong hieu: ","Error");
        tensp=Check.nhapChuoi("Ten san pham: ","Error");
        masp=Check.nhapChuoi("Ma san pham: ","Error");
        dongia=Check.nhapSoNguyenL("Don gia: ","Error");
        soluong=Check.nhapSoNguyen("So luong: ","Error");
        size=Check.nhapChuoi("Nhap vao kich thuoc: ","error");
        color=Check.nhapChuoi("Nhap vao mau: ","error");
        NSX=Check.nhapNgayThang("Ngay san xuat: ","Error");
    }
    @Override
    public void xuatPRODUCT(){
        System.out.printf("%-5d%-20s%-25s%-15s%-18s%-12d%-12d%-8s%-8s%-15s%-10s\n",n,brand,tensp,masp,NSX,dongia,soluong,size,color," "," ");
    }
    public String toString(){
        return n+" "+brand+" "+tensp+" "+masp+" "+dongia+" "+NSX.toString()+" "+soluong+" "+size+" "+color;
    }
    public static void main(String[] args){
        Physical a=new Physical();
        a.nhapPRODUCT();
        a.xuatPRODUCT();
    }
}
