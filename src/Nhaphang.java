import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Nhaphang {
    public PhieuNhap[] pn;
    public PRODUCT[] products;
    public CTphieunhap[] ctpn;
    public List<PhieuNhap> listpn;
    public List<CTphieunhap> listctpn;
    public List<PRODUCT> listproduct;
    private int k;
    private int j;
    private int n;
    private FILE fi;
    transient Scanner sc=new   Scanner(System.in);
    
    public Nhaphang(int j,int k,PRODUCT[] products, int n, PhieuNhap[] pn, CTphieunhap[] ctpn, FILE fi, List<CTphieunhap> listctpn,List<PRODUCT> listproduct,List<PhieuNhap> listpn) {
        this.products = products;
        this.n = n;
        this.j=j;
        this.pn = pn;
        this.ctpn = ctpn;
        this.fi = fi;
        this.listctpn = listctpn;
        this.listproduct = listproduct;
        this.listpn=listpn;
        this.k=k;
    }
    public Nhaphang(){
        k=0;
        j=0;
        products =null;
        n=0;
        pn=null;
        ctpn=null;
        fi=new FILE();
        listctpn=null;
        listproduct=null;
        listpn=null;
    }
    public void nhaphang(){
        System.out.println("Nhap vao so luong san pham: ");
        n=Integer.parseInt(sc.nextLine());
        products=new PRODUCT[n];
        PRODUCT a;
        int choice;
        for(int i=0;i<products.length;i++){
            do{
                System.out.println("1.Physical");
                System.out.println("2.Digital");
                System.out.println("3.Food");
                System.out.println("Please choice one");
                choice=sc.nextInt();
                }while(choice<1 || choice>3);
                switch(choice){
                    case 1:a=new Physical();
                           a.nhapPRODUCT();
                           products[i]=a;
                           break;
                    case 2:a=new Digital();
                           a.nhapPRODUCT();
                           products[i]=a;
                           break;
                    case 3:a=new Food();
                           a.nhapPRODUCT();
                           products[i]=a;
                           break;
                    default:break;
                }
        }
        listproduct=new ArrayList<PRODUCT>(Arrays.asList(products));
    }
    public void xuathang(){
        System.out.println("                                       <--------------DANH SACH SAN PHAM-------------->");
        System.out.println("                                                             +++++");
        System.out.printf("%-5s%-20s%-25s%-15s%-18s%-12s%-12s%-8s%-8s%-15s%-10s\n","STT","THUONG HIEU","TEN SAN PHAM","MA SAN PHAM","NGAY SAN XUAT","DON GIA","SOLUONG","SIZE","COLOR","HSD/BAO HANH","CONG SUAT");
        for(PRODUCT a:products)
           a.xuatPRODUCT();
        System.out.println();
    }
    public void nhapphieunhap(DSNHANVIEN dsnv,DSsupplier dsncc){
        PhieuNhap p;
        CTphieunhap a;
        int choice;
        ctpn=new CTphieunhap[j];
        pn=new PhieuNhap[k];
        do{
            p=new PhieuNhap();
            dsnv.phieunhap(p);
            dsncc.phieunhap(p);
            p.nhap();
            int input,v;
            pn=Arrays.copyOf(pn,pn.length+1);
            pn[k]=p;
            k++;
            do{
                do{
                    v=0;
                    String masp=Check.nhapChuoi("Nhap vao ma san pham muon nhap hang: ","Error");
                    for(int i=0;i<products.length;i++){
                        a=new CTphieunhap();
                        a.setMapn(p.getMapn());
                        if(products[i].getmasp().equalsIgnoreCase(masp)){
                            a.setTenSanPham(products[i].gettensp());
                            a.setMaSanPham(products[i].getmasp());
                            a.setSoLuong(inputquantity());
                            a.setTongTien(products[i].getdongia()*a.getSoLuong());
                            ctpn=Arrays.copyOf(ctpn,ctpn.length +1);
                            ctpn[j]=a;
                            j++;
                            v++;
                        }
                    }
                    if (v==0)
                        System.out.println("Ma san pham khon ton tai");
                }while(v!=1);
                System.out.println("Ban co muon nhap hang tiep?");
                System.out.println("1. Nhap tiep");
                System.out.println("2. Exit");
                input=Check.nhapSoNguyen("Chon: ","Error");
            }while(input!=2);
            System.out.println("Tao phieu nhap tiep theo");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice=Check.nhapSoNguyen("Chon: ","Error");
            if(choice==1) 
                xuatphieunhap();
        }while(choice!=2);
        listpn=new ArrayList<PhieuNhap>(Arrays.asList(pn));
        listctpn=new ArrayList<CTphieunhap>(Arrays.asList(ctpn));
    }
    public void xuatphieunhap(){
        for(int i=0;i<pn.length;i++){
            pn[i].xuat();
            for(int j=0;j<ctpn.length;j++)
                if (ctpn[j].getMapn().equalsIgnoreCase(pn[i].getMapn()))
                    ctpn[j].xuat();
        }
    }
    public DATE inputdate(){
        return Check.nhapNgayThang("Nhap ngay nhap phieu: ","Error");
    }
    public int inputquantity(){
        while (true) {
            try{
                int sl=Check.nhapSoNguyen("Nhap vao so luong  muon nhap hang: ","Error");
                return sl;
            }catch (Exception e){
                System.out.print("KHONG HOP LE!!! Nhap lai so luong");
            }
        }
    }
    public void Khoitao(){
        products = new PRODUCT[10];
        ctpn =new CTphieunhap[1];
        pn=new PhieuNhap[1];
        DATE abh = new DATE(10, 10, 2021);
        DATE ad = new DATE(10, 10, 2023);
        PhieuNhap PN=new PhieuNhap("001","N01",ad,"PN1");
        CTphieunhap ct=new CTphieunhap(1,"001","ao",20,2000,40000,"PN1");
        PRODUCT a = new Digital(1,"ASUS", "Asus Vivobook 2023", "001", 18000000, 99, ad, abh, 110);
        PRODUCT a1 = new Digital(2,"LG", "Tivi LG", "002", 3800000, 99, ad, abh, 110);
        PRODUCT a2 = new Digital(3,"Samsung", "Samsung A50", "003", 12000000, 99, ad, abh, 4000);
        PRODUCT b = new Physical(4,"Hades", "Ao thun", "004", 200000, 99, ad, "M", "Den");
        PRODUCT b1 = new Physical(5,"Hades", "Quan Short", "005", 250000, 99, ad, "L", "Xanh");
        PRODUCT b2 = new Physical(6,"Hades", "Quan Jean", "006", 320000, 99, ad, "M", "Den");
        PRODUCT b3 = new Physical(7,"Hades", "Jacket", "007", 330000, 99, ad, "XL", "Trang");
        PRODUCT c = new Food(8,"BM", "Banh mi", "008", 30000, 30, ad, abh);
        PRODUCT c1 = new Food(9,"Oshi", "Snack", "009", 10000, 100, ad, abh);
        PRODUCT c2 = new Food(10,"HaoHao", "Mi goi", "009", 5000, 67, ad, abh);
        products[0]=a;
        products[1]=a1;
        products[2]=a2;
        products[3]=b;
        products[4]=b1;
        products[5]=b2;
        products[6]=b3;
        products[7]=c;
        products[8]=c1;
        products[9]=c2;
        ctpn[0]=ct;
        pn[0]=PN;
        listproduct=new ArrayList<PRODUCT>(Arrays.asList(products));
        listctpn=new ArrayList<CTphieunhap>(Arrays.asList(ctpn));
        listpn=new ArrayList<PhieuNhap>(Arrays.asList(pn));
    }
    public void writefile(){
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            DATE abh = new DATE(10, 10, 2021);
            DATE ad = new DATE(10, 10, 2023);
            Digital a = new Digital(1,"ASUS", "Asus Vivobook 2023", "001", 18000000, 99, ad, abh, 110);
            Digital a1 = new Digital(2,"LG", "Tivi LG", "002", 3800000, 99, ad, abh, 110);
            Digital a2 = new Digital(3,"Samsung", "Samsung A50", "003", 12000000, 99, ad, abh, 4000);
            Physical b = new Physical(4,"Hades", "Ao thun", "004", 200000, 99, ad, "M", "Den");
            Physical b1 = new Physical(5,"Hades", "Quan Short", "005", 250000, 99, ad, "L", "Xanh");
            Physical b2 = new Physical(6,"Hades", "Quan Jean", "006", 320000, 99, ad, "M", "Den");
            Physical b3 = new Physical(7,"Hades", "Jacket", "007", 330000, 99, ad, "XL", "Trang");
            Food c = new Food(8,"BM", "Banh mi", "008", 30000, 30, ad, abh);
            Food c1 = new Food(9,"Oshi", "Snack", "009", 10000, 100, ad, abh);
            Food c2 = new Food(10,"HaoHao", "Mi goi", "009", 5000, 67, ad, abh);
            fos=new FileOutputStream("text.txt",true);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(a);
            oos.writeObject(a1);
            oos.writeObject(a2);
            oos.writeObject(b);
            oos.writeObject(b1);
            oos.writeObject(b2);
            oos.writeObject(b3  );
            oos.writeObject(c);
            oos.writeObject(c1);
            oos.writeObject(c2);
            oos.close();
            fos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }   

    public void readfile()
    {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        Object obj=new Object();
        try {
            fis=new FileInputStream("text.txt");
            try {
                ois=new ObjectInputStream(fis);
                if(obj==null)
                    System.out.println("Trong");
                else
                {
                    while(fis.available()>0)
                    {
                        obj=ois.readObject();
                        System.out.println(obj);
                    }
                    ois.close();
                    fis.close();
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(); 
        }
    }
    public static void main(String[] args) {
        Nhaphang a=new Nhaphang();
        a.Khoitao();
        a.xuatphieunhap();
    }
}
