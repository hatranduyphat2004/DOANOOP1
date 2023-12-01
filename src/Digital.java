import java.io.Serializable;

public class Digital extends PRODUCT {
    private DATE baohanh;
    private int congsuat;
    private int n;
    public Digital(int n,String brand, String tensp, String masp, long dongia, int soluong, DATE NSX, DATE baohanh,int congsuat) {
        super(brand, tensp, masp, dongia, soluong, NSX); 
        this.baohanh = baohanh;
        this.congsuat = congsuat;
        this.n=n;
    }
    public Digital(){
        super();    
        baohanh=new DATE();
        congsuat=0;
        n=count;
    }
    public double getCongsuat() {
        return congsuat;
    }
    public void setCongsuat(int congsuat) {
        this.congsuat = congsuat;
    }
    public void setbaohanh(DATE baohanh){
        this.baohanh=baohanh;
    }
    public DATE getbaohanh(){
        return baohanh;
    }
    public void dientu(){
        System.out.println("Day la thiet bi dien tu");
    }
    public void nhapPRODUCT(){
        dientu();
        brand=Check.nhapChuoi("Thuong hieu: ","Error");
        tensp=Check.nhapChuoi("Ten san pham: ","Error");
        masp=Check.nhapChuoi("Ma san pham: ","Error");
        congsuat=Check.nhapSoNguyen("Cong suat: ","Error");
        dongia=Check.nhapSoNguyenL("Don gia: ","Error");
        soluong=Check.nhapSoNguyen("So luong:","Error");
        do{
            NSX=Check.nhapNgayThang("Ngay san xuat: ","Error");
            baohanh=Check.nhapNgayThang("Thoi gian bao hanh: ","Error");
        }while(NSX.getTime() > baohanh.getTime());
        
    }
    public void xuatPRODUCT(){
        System.out.printf("%-5d%-20s%-25s%-15s%-18s%-12d%-12d%-8s%-8s%-15s%-10d\n",n,brand,tensp,masp,NSX,dongia,soluong," "," ",baohanh,congsuat);
    }
    public String toString(){
        return n+" "+brand+" "+tensp+" "+masp+" "+dongia+" "+soluong+" "+NSX.toString()+" "+baohanh.toString()+" "+congsuat;
    }
    public static void main(String[] args){ }
}
