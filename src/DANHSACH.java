
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

public class DANHSACH {
    public PRODUCT[] danhsach;
    public List<PRODUCT> list;
    private int n;
    private FILE fi;
    transient Scanner sc=new Scanner(System.in);
    public DANHSACH(int n,PRODUCT[] danhsach){
        this.n=n;
        this.danhsach=danhsach;
    }
    public DANHSACH(){
        danhsach=null;
        n=0;
        fi=new FILE();
        list=null;
    }
    public void nhapdanhsach(){
        System.out.print("Nhap vao so luong cac loai san pham: ");
        n=sc.nextInt();
        danhsach=new PRODUCT[n];
        PRODUCT a;
        int choice;
        for(int i=0;i<n;i++){
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
                       danhsach[i]=a;
                       break;
                case 2:a=new Digital();
                       a.nhapPRODUCT();
                       danhsach[i]=a;
                       break;
                case 3:a=new Food();
                       a.nhapPRODUCT();
                       danhsach[i]=a;
                       break;
                default:break;
            }
        }
        list=new ArrayList<PRODUCT>(Arrays.asList(danhsach));
    }
    public void demPR(){
        int countP,countD,countF;
        countD=countP=countF=0;
        for(int i=0;i<danhsach.length;i++){
            if(danhsach[i] instanceof Physical)
               countP++;
            else if(danhsach[i] instanceof Digital)
               countD++;
            else if(danhsach[i] instanceof Food)
               countF++;
        }
        System.out.println("So luong san pham Physical: "+countP);
        System.out.println("So luong san pham Digital: "+countD);
        System.out.println("So luong san pham Food: "+countF);
        System.out.println("Tong so luong san pham: "+(countD+countF+countP));
    }
    public void xuatdanhsach(){
        System.out.println("                                       <--------------DANH SACH SAN PHAM-------------->");
        System.out.println("                                                             +++++");
        System.out.printf("%-5s%-20s%-25s%-15s%-18s%-12s%-12s%-8s%-8s%-15s%-10s\n","STT","THUONG HIEU","TEN SAN PHAM","MA SAN PHAM","NGAY SAN XUAT","DON GIA","SOLUONG","SIZE","COLOR","HSD/BAO HANH","CONG SUAT");
        for(PRODUCT a:danhsach)
           a.xuatPRODUCT();
        System.out.println();
        demPR();
    }
    public void FindbyName(){
        System.out.print("Nhap vao ten san pham tim kiem: ");
        String ten=sc.nextLine();
        for(int i=0;i<danhsach.length;i++)
            if(danhsach[i].gettensp().equalsIgnoreCase(ten))
                danhsach[i].xuatPRODUCT();
    }
    
    public void FindbyID(){
        System.out.print("Nhap vao ma san pham tim kiem: ");
        String ma=sc.nextLine();
        for(int i=0;i<danhsach.length;i++)
            if(danhsach[i].getmasp().equalsIgnoreCase(ma))
               danhsach[i].xuatPRODUCT();
    }

    public void Delete(){
        int count=0;
        System.out.print("Nhap vao ten san pham muon xoa: ");
        String name=sc.nextLine();
        for(int i=0;i<danhsach.length;i++)
            if(danhsach[i].gettensp().equalsIgnoreCase(name))
               count++;
        if(count==1){
            for(int i=0;i<n;i++)
                if(danhsach[i].gettensp().equalsIgnoreCase(name)){
                    for(int j=i;j<n-1;j++)
                        danhsach[j]=danhsach[j+1];
                    n--;
                    break;
                }
        }
        else if(count>1){
            System.out.println("San pham bi trung ten");
            System.out.println("Vui long nhap vao ma san pham de xoa");
            String ma=sc.nextLine();
            for(int i=0;i<n;i++){
                if(danhsach[i].getmasp().equalsIgnoreCase(ma)){
                    for(int j=i;j<n-1;j++)
                        danhsach[j]=danhsach[j+1];
                    n--;
                    break;
            } 
        }
    }
        for(int k=0;k<n;k++)
            danhsach[k].xuatPRODUCT();
    }
    public void add(PRODUCT a){
        danhsach=Arrays.copyOf(danhsach,danhsach.length+1);
        danhsach[n]=a;
        n++;
    }
    public void Add(){
        System.out.println(" Chon san pham muon them");
        int choice;
        PRODUCT a=new Physical();
        PRODUCT b=new Digital();
        PRODUCT c=new Food();
        do{
            System.out.println("1.Physical");
            System.out.println("2.Digital");
            System.out.println("3.Food");
            System.out.println("Please choose one");
            choice=sc.nextInt();
        }while(choice<1 || choice>4);
        switch(choice){
            case 1: 
                    a.nhapPRODUCT();
                    add(a);
                    break;
            case 2: 
                    b.nhapPRODUCT();
                    add(a);
                    break;
            case 3: 
                    c.nhapPRODUCT();
                    add(a);
                    break;
            case 4: System.exit(0);
                    break;
            default: break;
        }
        for(int j=0;j<danhsach.length;j++)
           danhsach[j].xuatPRODUCT();
    }

    public void Edit(){
        System.out.print("Nhap vao ma san pham muon chinh sua: ");
        String ma=sc.nextLine();
        for(int i=0;i<danhsach.length;i++){
            if(danhsach[i].getmasp().equalsIgnoreCase(ma)){
                 if(danhsach[i] instanceof Physical){
                    Physical a=(Physical)danhsach[i];
                    int choice=0;
                    while (choice !=9) {
                        System.out.println("1. Sua thuong hieu");
                        System.out.println("2. Sua ten san pham");
                        System.out.println("3. Sua ma san pham");
                        System.out.println("4. Sua don gia cua san pham");
                        System.out.println("5. Sua so luong");
                        System.out.println("6. Sua size");
                        System.out.println("7. Sua mau sac");
                        System.out.println("8. Sua ngay san xuat"); 
                        System.out.println("9. EXIT!!!");
                        choice=Check.nhapSoNguyen("Su lua chon: ","Error");
                        switch (choice) {
                            case 1:
                                a.setbrand(inputBrand());
                                break;
                            case 2:
                                a.settensp(inputName());
                                break;
                            case 3:
                                a.setmasp(inputId());
                                break;
                            case 4:
                                a.setdongia(inputPrice());
                                break;
                            case 5:
                                a.setsoluong(inputQuantity());
                                break;
                            case 6:
                                a.setsize(inputSize());
                                break;
                            case 7:
                                a.setcolor(inputColor());
                                break;
                            case 8:
                                a.setNSX(inputNSX());
                                break;    
                            default:
                                break;
                        }
                    }
                 }
                 else if(danhsach[i] instanceof Digital){
                    Digital a=(Digital)danhsach[i];
                    int choice=0;
                    while (choice !=9) {
                        System.out.println("1. Sua thuong hieu");
                        System.out.println("2. Sua ten san pham");
                        System.out.println("3. Sua ma san pham");
                        System.out.println("4. Sua don gia cua san pham");
                        System.out.println("5. Sua so luong");
                        System.out.println("6. Sua cong suat");
                        System.out.println("7. Sua thoi gian bao hanh");
                        System.out.println("8. Sua ngay san xuat"); 
                        System.out.println("9. EXIT!!!");
                        choice=Check.nhapSoNguyen("Su lua chon: ","Error");
                        switch (choice) {
                            case 1:
                                a.setbrand(inputBrand());
                                break;
                            case 2:
                                a.settensp(inputName());
                                break;
                            case 3:
                                a.setmasp(inputId());
                                break;
                            case 4:
                                a.setdongia(inputPrice());
                                break;
                            case 5:
                                a.setsoluong(inputQuantity());
                                break;
                            case 6:
                                a.setCongsuat(inputWattage());
                                break;
                            case 7:
                                a.setbaohanh(inputWarranty());
                                break;
                            case 8:
                                a.setNSX(inputNSX());
                                break;    
                            default:
                                break;
                        }
                    }
                 }
                 else{
                    Food a=(Food)danhsach[i];
                    int choice=0;
                    while (choice !=8) {
                        System.out.println("1. Sua thuong hieu");
                        System.out.println("2. Sua ten san pham");
                        System.out.println("3. Sua ma san pham");
                        System.out.println("4. Sua don gia cua san pham");
                        System.out.println("5. Sua so luong");
                        System.out.println("6. Sua han su dung");
                        System.out.println("7. Sua ngay san xuat"); 
                        System.out.println("8. EXIT!!!");
                        choice=Check.nhapSoNguyen("Su lua chon: ","Error");
                        switch (choice) {
                            case 1:
                                a.setbrand(inputBrand());
                                break;
                            case 2:
                                a.settensp(inputName());
                                break;
                            case 3:
                                a.setmasp(inputId());
                                break;
                            case 4:
                                a.setdongia(inputPrice());
                                break;
                            case 5:
                                a.setsoluong(inputQuantity());
                                break;
                            case 6:
                                a.setHSD(inputHSD());
                                break;
                            case 7:
                                a.setNSX(inputNSX());
                                break;    
                            default:
                                break;
                        }
                    }
                   
                 }
            }
        }
        for(PRODUCT a:danhsach)
            a.xuatPRODUCT();
    }
    public String inputName(){
        return Check.nhapChuoi("Nhap vao ten san pham moi: ", "error");
    }
    public String inputBrand(){
        return Check.nhapChuoi("Nhap vao ten thuong hieu moi: ","error");
    }
    public String inputId(){
        return Check.nhapChuoi("Nhap vao ma san pham moi: ","error");
    }
    public long inputPrice(){
        System.out.print("Nhap vao gia san pham: ");
        while (true) {
            try{
                long id=Check.nhapSoNguyenL("Nhap vao ma san pham: ","error");
                return id;
            }catch (Exception e){
                System.out.print("KHONG HOP LE!!!!! Nhap lai ma san pham: ");
            }
        }
    }
    public int inputQuantity(){
        System.out.print("Nhap vao so luong: ");
        while (true) {
            try{
                int quantity=Check.nhapSoNguyen("Nhap vao so luong kho: ","error");
                return quantity;
            }catch (Exception e){
                System.out.print("KHONG HOP LE!!!!! Nhap lai so luong: ");
            }
        }
    }
    public DATE inputNSX(){
        return Check.nhapNgayThang("Nhap lai ngay san xuat: ","error");
    }
    public String inputColor(){
        return Check.nhapChuoi("Nhap vao mau moi: ","error");
    }
    public String inputSize(){
        return Check.nhapChuoi("Nhap vao kich thuoc moi: ","error");
    }
    public DATE inputWarranty(){
        return Check.nhapNgayThang("Nhap lai thoi gian bao hanh: ","error");
    }
    public int inputWattage(){
        System.out.print("Nhap vao cong suat: ");
        while (true) {
            try{
                int wattage=Check.nhapSoNguyen("Nhap vao cong suat: ","error");
                return wattage;
            }catch (Exception e){
                System.out.print("KHONG HOP LE!!!!! Nhap lai cong suat: ");
            }
        }
    }
    public DATE inputHSD(){
        return Check.nhapNgayThang("Nhap lai han su dung: ","error");
    }
    
    public void Khoitao(){
        danhsach = new PRODUCT[9];
        DATE nsx = new DATE(10, 10, 2021);
        DATE ad = new DATE(10, 10, 2023);
        PRODUCT b = new Physical(4,"Hades", "Ao thun", "004", 200000, 99, ad, "M", "Den");
        PRODUCT b1 = new Physical(5,"Hades", "Quan Short", "005", 250000, 99, ad, "L", "Xanh");
        PRODUCT b2 = new Physical(6,"Hades", "Quan Jean", "006", 320000, 99, ad, "M", "Den");
        PRODUCT a = new Digital(1,"ASUS", "Asus Vivobook 2023", "001", 18000000, 99, ad, nsx, 110);
        PRODUCT a1 = new Digital(2,"LG", "Tivi LG", "002", 3800000, 99, ad, nsx, 110);
        PRODUCT a2 = new Digital(3,"Samsung", "Samsung A50", "003", 12000000, 99, ad, nsx, 4000);
        PRODUCT c = new Food(7,"Chups chups", "Keo deo", "008", 30000, 30, ad, nsx);
        PRODUCT c1 = new Food(8,"Vonka", "Chocolate", "009", 54000, 100, ad, nsx);
        PRODUCT c2 = new Food(9,"HaoHao", "Mi goi", "010", 5000, 299, ad, nsx);
        danhsach[0] = a;
        danhsach[1] = a1;
        danhsach[2] = a2;
        danhsach[3] = b;
        danhsach[4] = b1;
        danhsach[5] = b2;
        danhsach[6] = c;
        danhsach[7] = c1;
        danhsach[8] = c2;
        list = new ArrayList<PRODUCT>(Arrays.asList(danhsach));
    }
    public void writefile(){
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try{
            DATE nsx = new DATE(10, 10, 2021);
            DATE ad = new DATE(10, 10, 2023);
            PRODUCT b = new Physical(1,"Hades", "Ao thun", "004", 200000, 99, ad, "M", "Den");
            PRODUCT b1 = new Physical(2,"Hades", "Quan Short", "005", 250000, 99, ad, "L", "Xanh");
            PRODUCT b2 = new Physical(3,"Hades", "Quan Jean", "006", 320000, 99, ad, "M", "Den");
            PRODUCT a = new Digital(4,"ASUS", "Asus Vivobook 2023", "001", 18000000, 99, ad, nsx, 110);
            PRODUCT a1 = new Digital(5,"LG", "Tivi LG", "002", 3800000, 99, ad, nsx, 110);
            PRODUCT a2 = new Digital(6,"Samsung", "Samsung A50", "003", 12000000, 99, ad, nsx, 4000);
            PRODUCT c = new Food(7,"Chups chups", "Keo deo", "008", 30000, 30, ad, nsx);
            PRODUCT c1 = new Food(8,"Vonka", "Chocolate", "009", 54000, 100, ad, nsx);
            PRODUCT c2 = new Food(9,"HaoHao", "Mi goi", "010", 5000, 299, ad, nsx);
            fos=new FileOutputStream("text.dat",true);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(a);
            oos.writeObject(a1);
            oos.writeObject(a2);
            oos.writeObject(b);
            oos.writeObject(b1);
            oos.writeObject(b2);
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
            fis=new FileInputStream(" text.dat");
            try {
                ois=new ObjectInputStream(fis);
                if(obj==null)
                    System.out.println("Nothing");
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
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }catch (IOException ex) {
                ex.printStackTrace();
            } 
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(); 
        }
    }
    public static void main(String[] args){
        DANHSACH a=new DANHSACH();
        a.Khoitao();
        a.xuatdanhsach();
    }
}
