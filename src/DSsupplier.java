import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DSsupplier {
    public SUPPLIER[] dssupplier;
    public PRODUCT[] product;
    public CTphieunhap[] dsctpn;
    public PhieuNhap[] dspn;
    public List<SUPPLIER> list;
    private int n;
    private FILE fi;
    Scanner sc=new   Scanner(System.in);
    
    public DSsupplier(SUPPLIER[] dssupplier, int n, PRODUCT[] product, CTphieunhap[] dsctpn, PhieuNhap[] dspn) {
        this.dssupplier = dssupplier;
        this.n = n;
        this.product = product;
        this.dsctpn = dsctpn;
        this.dspn = dspn;

    }
    public DSsupplier(){
        dssupplier=null;
        n=0;
        product=null;
        list=null;
        fi=new FILE();
    }
    public void nhapsupplier(){
        System.out.print("Nhap vao so nha cung cap: ");
        n=sc.nextInt();
        dssupplier=new SUPPLIER[n];
        SUPPLIER a;
        for(int i=0;i<dssupplier.length;i++){
            a=new SUPPLIER();
            a.nhapPerson();
            dssupplier[i]=a;
            System.out.println();
        }
        list=new ArrayList<SUPPLIER>(Arrays.asList(dssupplier));
    }
    public void FindbyName(){
        System.out.print("Nhap vao nha cung cap tim kiem: ");
        String ten=sc.nextLine();
        for(int i=0;i<dssupplier.length;i++)
            if(dssupplier[i].getname().equalsIgnoreCase(ten))
                dssupplier[i].xuatPerson();
    }

    public void FindbyID(){
        System.out.print("Nhap vao ma nha cung cap tim kiem: ");
        String ma=sc.nextLine();
        for(int i=0;i<dssupplier.length;i++)
            if(dssupplier[i].getMa().equalsIgnoreCase(ma))
               dssupplier[i].xuatPerson();
    }
    public void Delete(){
        int count=0;
        System.out.print("Nhap vao ten nha cung cap muon xoa: ");
        String name=sc.nextLine();
        for(int i=0;i<dssupplier.length;i++)
            if(dssupplier[i].getname().equalsIgnoreCase(name))
               count++;
        if(count==1){
            for(int i=0;i<n;i++)
                if(dssupplier[i].getname().equalsIgnoreCase(name)){
                    for(int j=i;j<n-1;j++)
                        dssupplier[j]=dssupplier[j+1];
                    n--;
                    break;
                }
        }
        else if(count>1){
            System.out.println("Trung ten nha cung cap");
            System.out.println("Vui long nhap vao ma nha cung cap xoa");
            String ma=sc.nextLine();
            for(int i=0;i<n;i++){
                if(dssupplier[i].getMa().equalsIgnoreCase(ma)){
                    for(int j=i;j<n-1;j++)
                        dssupplier[j]=dssupplier[j+1];
                    n--;
                    break;
            } 
        }
    }
        for(int k=0;k<n;k++)
            dssupplier[k].xuatPerson();
    }
    public void Add(){
        SUPPLIER supplier=new SUPPLIER();
        System.out.println("Nhap nha cung cap them");
        supplier.nhapPerson();
        dssupplier=Arrays.copyOf(dssupplier,dssupplier.length + 1);
        dssupplier[n]=supplier;
        n++;
    }
    public void Edit(){
        System.out.println("Nhap ma nha cung cap muon chinh sua:");
        String ma=sc.nextLine();
        int choice=0;
        for(int i=0;i<dssupplier.length;i++){
            while (choice!=7) {
                System.out.println("1. Ho va ten");
                System.out.println("2. Ngay kinh doanh");
                System.out.println("3. So dien thoai");
                System.out.println("4. Email");
                System.out.println("5. Dia chi");
                System.out.println("6. Ma nha cung cap");
                System.out.println("7. EXIT!!!");
                switch (choice) {
                    case 1:
                        dssupplier[i].setname(inputname());
                        break;
                    case 2:
                        dssupplier[i].setDob(inputdob());
                        break;
                    case 3:
                        dssupplier[i].setsdt(inputsdt());
                        break;
                    case 4:
                        dssupplier[i].setemail(inputemail());
                        break;
                    case 5:
                        dssupplier[i].setaddress(inputaddress());
                        break;
                    case 6:
                        dssupplier[i].setMa(inputma());
                        break;
                    default:
                        break;
                }
            }
        }
        for(SUPPLIER a:dssupplier)
            a.xuatPerson();
    }
    public String inputsdt(){
        return Check.nhapChuoi("Nhap vao so dien thoai moi: ","Error");
    }
    public String inputname(){
        return Check.nhapChuoi("Nhap ho va ten moi: " ,"Error");
    }
    public String inputma(){
        return Check.nhapChuoi("Nhap ma nha cung cap moi: " ,"Error");
    }
    public String inputemail(){
        return Check.nhapChuoi("Nhap email moi: " ,"Error");
    }
    public ADDRESS inputaddress(){
        return Check.nhapDiaChi("Nhap dia chi moi: ","Error");
    }
    public DATE inputdob(){
        return Check.nhapNgayThang("Nhap ngay kinh doanh moi: ","Error");
    }
    public void xuatsupplier(){
        System.out.println("                                <---------------DANH SACH CONG TY--------------->");
        System.out.println("                                                     ++++");
        System.out.printf("%-5s%-5s%-20s%-18s%-18s%-20s%-25s\n","STT","MA","CONG TY","NGAY KINH DOANH","SO DIEN THOAI","EMAIL","DIA CHI");
        for(SUPPLIER a:dssupplier)
            a.xuatPerson();
    }
    public void phieunhap(PhieuNhap pn){
        String mancc;
        int k=0;
        do{
            System.out.print("Nhap vao ma nha cung cap muon chon de nhap hang: ");
            mancc=sc.nextLine();
            for(int i=0;i<dssupplier.length;i++)
                if(dssupplier[i].getMa().equalsIgnoreCase(mancc)){
                    pn.setMaNhaCungCap(dssupplier[i].getMa());
                    k++;
                }
            if(k==0)
                System.out.println("Ma nha cung cap khong ton tai");
        }while(k!=1);
    }
    public void Khoitao(){
        dssupplier = new SUPPLIER[5];
        ADDRESS address = new ADDRESS("99", "so 1", "quan 1", "Ho Chi Minh");
        DATE date = new DATE(19, 2, 2000);
        SUPPLIER a = new SUPPLIER(1,"LG", "0364523882", "LG@gmail.com", address, "N01", date);
        SUPPLIER a1 = new SUPPLIER(2,"ASUS", "0956644231", "asus@gmail.com", address, "N02", date);
        SUPPLIER a2 = new SUPPLIER(3,"BM", "03644746223", "bm@gmail.com", address, "N03", date);
        SUPPLIER a3 = new SUPPLIER(4,"Hades", "0922364121", "hades@gmail.com", address, "N04", date);
        SUPPLIER a4 = new SUPPLIER(5,"Samsung", "0357362937", "samsung@gmail.com", address, "N05", date);
        dssupplier[0] = a;
        dssupplier[1] = a1;
        dssupplier[2] = a2;
        dssupplier[3] = a3;
        dssupplier[4] = a4;
        list =new ArrayList<SUPPLIER>(Arrays.asList(dssupplier));
    }
    
    public void writefile(){
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try{
            ADDRESS address = new ADDRESS("99", "so 1", "quan 1", "Ho Chi Minh");
            DATE date = new DATE(19, 2, 2000);
            SUPPLIER a = new SUPPLIER(1,"LG", "0364523882", " ", address, "N01", date);
            SUPPLIER a1 = new SUPPLIER(2,"ASUS", "0956644231", " ", address, "N02", date);
            SUPPLIER a2 = new SUPPLIER(3,"BM", "03644746223", " ", address, "N03", date);
            SUPPLIER a3 = new SUPPLIER(4,"Hades", "0922364121", " ", address, "N04", date);
            SUPPLIER a4 = new SUPPLIER(5,"Samsung", "0357362937", " ", address, "N05", date);
            fos=new FileOutputStream("text.txt",true);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(a);
            oos.writeObject(a1);
            oos.writeObject(a2);
            oos.writeObject(a3);
            oos.writeObject(a4);
            oos.close();
            fos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readfile(){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        Object obj=new Object();
        try{
            fis=new FileInputStream("text.txt");
            try{
                ois=new ObjectInputStream(fis);
                if(obj==null)
                    System.out.println("Trong");
                else{
                    while (fis.available()>0) {
                        obj=ois.readObject();
                        System.out.println(obj);
                    }
                    ois.close();
                    fis.close();
                }
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        DSsupplier a=new DSsupplier();
        a.Khoitao();
        a.xuatsupplier();
    }
}
