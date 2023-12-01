import java.io.File;
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

public class DSNHANVIEN {
    public STAFF[] dsnhanvien;
    public List<STAFF> list;
    private int n;
    private FILE fi;
    transient Scanner sc=new   Scanner(System.in);

    public DSNHANVIEN(STAFF[] dsnhanvien, int n) {
        this.dsnhanvien = dsnhanvien;
        this.n = n;
    }
    public DSNHANVIEN(){
        dsnhanvien=null;
        n=0;
        fi=new FILE();
        list=null;
    }
    public void nhapstaff(){
        System.out.print("Nhap vao so luong nhan vien: ");
        n=sc.nextInt();
        dsnhanvien=new STAFF[n];
        STAFF a;
        for(int i=0;i<dsnhanvien.length;i++){
            a=new STAFF();
            a.nhapPerson();
            dsnhanvien[i]=a;
            System.out.println();
        }
        list =new ArrayList<STAFF>(Arrays.asList(dsnhanvien));
    }
    public void FindbyName(){
        System.out.print("Nhap vao ten nhan vien tim kiem: ");
        String ten=sc.nextLine();
        for(int i=0;i<dsnhanvien.length;i++)
            if(dsnhanvien[i].getname().equalsIgnoreCase(ten))
                dsnhanvien[i].xuatPerson();
    }

    public void FindbyID(){
        System.out.print("Nhap vao ma nhan vien tim kiem: ");
        String ma=sc.nextLine();
        for(int i=0;i<dsnhanvien.length;i++)
            if(dsnhanvien[i].getMa().equalsIgnoreCase(ma))
               dsnhanvien[i].xuatPerson();
    }
    public void Delete(){
        int count=0;
        System.out.print("Nhap vao ten nhan vien muon xoa: ");
        String name=sc.nextLine();
        for(int i=0;i<dsnhanvien.length;i++)
            if(dsnhanvien[i].getname().equalsIgnoreCase(name))
               count++;
        if(count==1){
            for(int i=0;i<n;i++)
                if(dsnhanvien[i].getname().equalsIgnoreCase(name)){
                    for(int j=i;j<n-1;j++)
                        dsnhanvien[j]=dsnhanvien[j+1];
                    n--;
                    break;
                }
        }
        else if(count>1){
            System.out.println("Trung ten nhan voen");
            System.out.println("Vui long nhap vao ma nhan vien de xoa");
            String ma=sc.nextLine();
            for(int i=0;i<n;i++){
                if(dsnhanvien[i].getMa().equalsIgnoreCase(ma)){
                    for(int j=i;j<n-1;j++)
                        dsnhanvien[j]=dsnhanvien[j+1];
                    n--;
                    break;
            } 
        }
    }
        for(int k=0;k<n;k++)
            dsnhanvien[k].xuatPerson();
    }
    public void Add(){
        STAFF staff=new STAFF();
        System.out.println("Nhap nhan vien them");
        staff.nhapPerson();
        dsnhanvien=Arrays.copyOf(dsnhanvien,dsnhanvien.length+1);
        dsnhanvien[n]=staff;
        n++;
        xuatstaff();
        for(int k=0;k<n;k++)
            dsnhanvien[k].xuatPerson(); 
    }
    public void Edit(){
        System.out.println("Nhap ma nhan vien muon chinh sua:");
        String ma=sc.nextLine();
        int choice=0;
        for(int i=0;i<dsnhanvien.length;i++){
            while (choice!=8) {
                System.out.println("1. Ho va ten");
                System.out.println("2. Gioi tinh");
                System.out.println("3. Ngay thang nam sinh");
                System.out.println("4. So dien thoai");
                System.out.println("5. Email");
                System.out.println("6. Dia chi");
                System.out.println("7. Ma nhan vien");
                System.out.println("8. EXIT!!!");
                switch (choice) {
                    case 1:
                        dsnhanvien[i].setname(inputname());
                        break;
                    case 2:
                        dsnhanvien[i].setSex(inputsex());
                        break;
                    case 3:
                        dsnhanvien[i].setDob(inputdob());
                        break;
                    case 4:
                        dsnhanvien[i].setsdt(inputsdt());
                        break;
                    case 5:
                        dsnhanvien[i].setemail(inputemail());
                        break;
                    case 6:
                        dsnhanvien[i].setaddress(inputaddress());
                        break;
                    case 7:
                        dsnhanvien[i].setMa(inputma());
                        break;
                    default:
                        break;
                }
            }
        }
        for(STAFF a:dsnhanvien)
            a.xuatPerson();
    }
    public String inputsdt(){
        return Check.nhapChuoi("Nhap vao so dien thoai moi: ","Error");
    }
    public String inputname(){
        return Check.nhapChuoi("Nhap ho va ten moi: " ,"Error");
    }
    public String inputsex(){
        return Check.nhapChuoi("Nhap gioi tinh moi: " ,"Error");
    }
    public String inputma(){
        return Check.nhapChuoi("Nhap ma nhan vien moi: " ,"Error");
    }
    public String inputemail(){
        return Check.nhapChuoi("Nhap email moi: " ,"Error");
    }
    public ADDRESS inputaddress(){
        return Check.nhapDiaChi("Nhap dia chi moi: ","Error");
    }
    public DATE inputdob(){
        return Check.nhapNgayThang("Nhap ngay thang nam sinh moi: ","Error");
    }
    public void xuatstaff(){
        System.out.println("                                         <---------------DANH SACH NHAN VIEN--------------->");
        System.out.println("                                                              ++++");
        System.out.printf("%-5s%-5s%-25s%-12s%-12s%-15s%-25s%-45s%-13s%-10s\n","STT","MA","HO TEN","GIOI TINH","NGAY SINH","SO DIEN THOAI","EMAIL","DIA CHI","TAI KHOAN","MAT KHAU");
        for(STAFF a: dsnhanvien)
           a.xuatPerson();
    }
    public void Khoitao(){
        dsnhanvien=new STAFF[5];
        ADDRESS ada=new ADDRESS("12/284/23","Nguyen Trai","quan 5","Ho Chi Minh");
        DATE ad=new DATE(2,2,1999);
        STAFF a=new STAFF(1,"Nguyen Le Nguyen Khang","019287852",ada,"nguyenkhang@gmail.com","001",ad,"Nam","nhanvien1","123456");
        ADDRESS ada1=new ADDRESS("98","Tan My","quan 7","Ho Chi Minh");
        DATE ad1=new DATE(29,10,2000);
        STAFF a1=new STAFF(2,"Nguyen Thi My Tuyet","0758365739",ada1,"mytuyet@gmail.com","002",ad1,"Nu","nhanvien2","123456");
        ADDRESS ada2=new ADDRESS("209/209/128C","Ben Van Don","quan 4","Ho Chi Minh");
        DATE ad2=new DATE(31,12,2002);
        STAFF a2=new STAFF(3,"Le Ngoc Tu Han","0592856389",ada2,"tuhan@gmail.com","003",ad2,"Nu","nhanvien3","123456");
        ADDRESS ada3=new ADDRESS("123","Duong Ba Trac","quan 8","Ho Chi Minh");
        DATE ad3=new DATE(19,4,2001);
        STAFF a3=new STAFF(4,"Nguyen Ngo Thao Tram","0727877865",ada3,"thaotram@gmail.com","004",ad3,"Nu","nhanvien4","123456");
        ADDRESS ada4=new ADDRESS("so 10","Nguyen Van Cu","quan 5","Ho Chi Minh");
        DATE ad4=new DATE(24,6,2001);
        STAFF a4=new STAFF(5,"Duong Quang Loc","0765789652",ada4,"quangloc@gmail.com","004",ad4,"Nam","nhanvien5","123456");
        dsnhanvien[0]=a;
        dsnhanvien[1]=a1;
        dsnhanvien[2]=a2;
        dsnhanvien[3]=a3;
        dsnhanvien[4]=a4;
        list=new ArrayList<STAFF>(Arrays.asList(dsnhanvien));
    }
    public void writefile(){
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try{
            ADDRESS ada=new ADDRESS("12/284/23","Nguyen Trai","quan 5","Ho Chi Minh");
            DATE ad=new DATE(2,2,1999);
            STAFF a=new STAFF(1,"Nguyen Le Nguyen Khang","019287852",ada,"nguyenkhang@gmail.com","001",ad,"Nam","nhanvien1","123456");
            ADDRESS ada1=new ADDRESS("98","Tan My","quan 7","Ho Chi Minh");
            DATE ad1=new DATE(29,10,2000);
            STAFF a1=new STAFF(2,"Nguyen Thi My Tuyet","0758365739",ada1,"mytuyet@gmail.com","002",ad1,"Nu","nhanvien2","123456");
            ADDRESS ada2=new ADDRESS("209/209/128C","Ben Van Don","quan 4","Ho Chi Minh");
            DATE ad2=new DATE(31,12,2002);
            STAFF a2=new STAFF(3,"Le Ngoc Tu Han","0592856389",ada2,"tuhan@gmail.com","003",ad2,"Nu","nhanvien3","123456");
            ADDRESS ada3=new ADDRESS("123","Duong Ba Trac","quan 8","Ho Chi Minh");
            DATE ad3=new DATE(19,4,2001);
            STAFF a3=new STAFF(4,"Nguyen Ngo Thao Tram","0727877865",ada3,"thaotram@gmail.com","004",ad3,"Nu","nhanvien4","123456");
            ADDRESS ada4=new ADDRESS("so 10","Nguyen Van Cu","quan 5","Ho Chi Minh");
            DATE ad4=new DATE(24,6,2001);
            STAFF a4=new STAFF(5,"Duong Quang Loc","0765789652",ada4,"quangloc@gmail.com","004",ad4,"Nam","nhanvien5","123456");
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
        try {
            fis=new FileInputStream("text.txt");
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
        }catch (FileNotFoundException ex) {
            ex.printStackTrace(); 
        }
    }
    public void phieunhap(PhieuNhap pn){
        String manv;
        int k=0;
        do{
            System.out.print("Nhap vao ma nhan vien: ");
            manv=sc.nextLine();
            for(int i=0;i<dsnhanvien.length;i++)
                if(dsnhanvien[i].getMa().equalsIgnoreCase(manv)){
                    pn.setMaNhanVien(dsnhanvien[i].getMa());
                    k++;
                }
        }while(k!=1);
    }
    public void phieuxuat(PhieuXuat px){
        String manv;
        int k=0;
        do{
            System.out.print("Nhap vao ma nhan vien: ");
            manv=sc.nextLine();
            for(int i=0;i<dsnhanvien.length;i++)
                if(dsnhanvien[i].getMa().equalsIgnoreCase(manv)){
                    px.setMaNhanVien(dsnhanvien[i].getMa());
                    k++;
                }
            if(k==0)
                System.out.println("Ma nhan vien khong ton tai");
        }while(k!=1);
    }
    public static void main(String[] args){
        DSNHANVIEN a=new DSNHANVIEN();
        a.Khoitao();
        a.xuatstaff();
    }
}
