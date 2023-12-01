import java.io.Serializable;

public class Food extends PRODUCT{
    private DATE HSD;
    private int n;
    public Food(int n,String brand, String tensp, String masp, long dongia, int soluong, DATE NSX, DATE HSD) {
        super(brand, tensp, masp, dongia, soluong, NSX);
        this.HSD = HSD;
        this.n=n;
    }
    public Food(){
        super();
        HSD=new DATE();
        n=count;
    }
    public void setHSD(DATE HSD){
        this.HSD=HSD;
    }
    public DATE getHSD(){
        return HSD;
    }

    public void nhapPRODUCT(){
        System.out.println("Day la thuc an");
        brand=Check.nhapChuoi("Thuong hieu: ","Error");
        tensp=Check.nhapChuoi("Ten san pham: ","Error");
        masp=Check.nhapChuoi("Ma san pham: ","Error");
        dongia=Check.nhapSoNguyenL("Don gia: ","Error");
        soluong=Check.nhapSoNguyen("So luong:","Error");
        do{
            NSX=Check.nhapNgayThang("Ngay san xuat: ","Error");
            HSD=Check.nhapNgayThang("Han su dung: ","Error");
        }while(HSD.getTime() < NSX.getTime());

    }
    public void xuatPRODUCT(){
        System.out.printf("%-5d%-20s%-25s%-15s%-18s%-12d%-12d%-8s%-8s%-15s%-10s\n",n,brand,tensp,masp,NSX,dongia,soluong," "," ",HSD," ");    
    }
    public String toString(){
        return n+" "+brand+" "+tensp+" "+masp+" "+dongia+" "+soluong+" "+NSX.toString()+" "+HSD.toString();
    }
    public static void main(String[] args){}
}