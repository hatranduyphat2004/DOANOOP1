import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DScustomer {
    public CUSTOMER[] dscustomer;
    public List<CUSTOMER> list;
    private int n;
    private FILE fi;
    transient Scanner sc=new   Scanner(System.in);
    
    public DScustomer(CUSTOMER[] dscustomer, int n) {
        this.dscustomer = dscustomer;
        this.n = n;
    }
    public DScustomer(){
        dscustomer=null;
        n=0;
        fi=new FILE();
        list=null;
    }
    public void nhapcustomer(){
        System.out.print("Nhap vao so luong khach hang: ");
        n=sc.nextInt();
        dscustomer=new CUSTOMER[n];
        CUSTOMER a;
        for(int i=0;i<dscustomer.length;i++){
            a=new CUSTOMER();
            a.nhapPerson();
            dscustomer[i]=a;
            System.out.println();
        }
        list =new ArrayList<CUSTOMER>(Arrays.asList(dscustomer));
    }
    public void FindbyName(){
        System.out.print("Nhap vao khach hang tim kiem: ");
        String ten=sc.nextLine();
        for(int i=0;i<dscustomer.length;i++)
            if(dscustomer[i].getname().equalsIgnoreCase(ten))
                dscustomer[i].xuatPerson();
    }

    public void FindbyID(){
        System.out.print("Nhap vao ma khach hang tim kiem: ");
        String ma=sc.nextLine();
        for(int i=0;i<dscustomer.length;i++)
            if(dscustomer[i].getMa().equalsIgnoreCase(ma))
               dscustomer[i].xuatPerson();
    }
    public void Delete(){
        int count=0;
        System.out.print("Nhap vao ten khach hang muon xoa: ");
        String name=sc.nextLine();
        for(int i=0;i<dscustomer.length;i++)
            if(dscustomer[i].getname().equalsIgnoreCase(name))
               count++;
        if(count==1){
            for(int i=0;i<n;i++)
                if(dscustomer[i].getname().equalsIgnoreCase(name)){
                    for(int j=i;j<n-1;j++)
                        dscustomer[j]=dscustomer[j+1];
                    n--;
                    break;
                }
        }
        else if(count>1){
            System.out.println("Trung ten khach hang");
            System.out.println("Vui long nhap vao ma khach hang de xoa");
            String ma=sc.nextLine();
            for(int i=0;i<n;i++){
                if(dscustomer[i].getMa().equalsIgnoreCase(ma)){
                    for(int j=i;j<n-1;j++)
                        dscustomer[j]=dscustomer[j+1];
                    n--;
                    break;
            } 
        }
    }
        for(int k=0;k<n;k++)
            dscustomer[k].xuatPerson();
    }
    public void Add(){
        CUSTOMER customer=new CUSTOMER();
        System.out.println("Nhap khach hang them");
       customer.nhapPerson();
        dscustomer=Arrays.copyOf(dscustomer,dscustomer.length+1);
        dscustomer[n]=customer;
        n++;
    }
    public void Edit(){
        System.out.println("Nhap ma khach hang muon chinh sua:");
        String ma=sc.nextLine();
        int choice=0;
        for(int i=0;i<dscustomer.length;i++){
            while (choice!=8) {
                System.out.println("1. Ho va ten");
                System.out.println("2. Gioi tinh");
                System.out.println("3. Ngay thang nam sinh");
                System.out.println("4. So dien thoai");
                System.out.println("5. Email");
                System.out.println("6. Dia chi");
                System.out.println("7. Ma khach hang");
                System.out.println("8. EXIT!!!");
                switch (choice) {
                    case 1:
                        dscustomer[i].setname(inputname());
                        break;
                    case 2:
                        dscustomer[i].setSex(inputsex());
                        break;
                    case 3:
                        dscustomer[i].setDob(inputdob());
                        break;
                    case 4:
                        dscustomer[i].setsdt(inputsdt());
                        break;
                    case 5:
                        dscustomer[i].setemail(inputemail());
                        break;
                    case 6:
                        dscustomer[i].setaddress(inputaddress());
                        break;
                    case 7:
                        dscustomer[i].setMa(inputma());
                        break;
                    default:
                        break;
                }
            }
        }
        for(CUSTOMER a:dscustomer)
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
        return Check.nhapChuoi("Nhap ma khach hang moi: " ,"Error");
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
    public void xuatcustomer(){
        System.out.println("                                         <---------------DANH SACH KHACH HANG--------------->");
        System.out.println("                                                              ++++");
        System.out.printf("%-5s%-5s%-25s%-12s%-12s%-15s%-25s%-45s\n","STT","MA","HO TEN","GIOI TINH","NGAY SINH","SO DIEN THOAI","EMAIL","DIA CHI");
        for(CUSTOMER a: dscustomer)
           a.xuatPerson();
    }
    public void phieuxuat(PhieuXuat px){
        String makh;
        int k=0;
        do{
            System.out.print("Nhap vao ma khach hang: ");
            makh=sc.nextLine();
            for(int i=0;i<dscustomer.length;i++)
                if(dscustomer[i].getMa().equalsIgnoreCase(makh)){
                    px.setMaKhachHang(dscustomer[i].getMa());
                    k++;
                }
        }while(k!=1);

    }
    public void Khoitao(){
        dscustomer=new CUSTOMER[5];
        DATE ad=new DATE(19,8,2004);
        ADDRESS ada=new ADDRESS("2086","Huynh Tan Phat","Nha Be","Ho Chi Minh");
        CUSTOMER a=new CUSTOMER(1,"Nguyen Hoang Tuan Kiet","0798980217",ada,"ngkietbaby19@gmail.com","01",ad,"Nam");
        DATE ad1=new DATE(10,11,2004);
        ADDRESS ada1=new ADDRESS("44C/67","Bui Van Ba","7","Ho Chi Minh");
        CUSTOMER a1=new CUSTOMER(2,"Pham Ngoc Cat Nghi","02948572629",ada1,"catnghi@gmail.com","02",ad1,"Nu");
        DATE ad2=new DATE(19,4,2004);
        ADDRESS ada2=new ADDRESS("So 3","Nguyen Binh Khiem","quan 1","Ho Chi Minh");
        CUSTOMER a2=new CUSTOMER(3,"Nguyen Hoang Tuan Kiet","0987654321",ada2,"tuankiet@gamil.com","03",ad2,"Nam");
        DATE ad3=new DATE(1,1,2000);
        ADDRESS ada3=new ADDRESS("123","An Duong Vuong","quan 5","Ho Chi Minh");
        CUSTOMER a3=new CUSTOMER(4,"Nguyen Ngoc Nhung","0902720212",ada3,"ngocnhung@gmail.com","04",ad3,"Nu");
        DATE ad4=new DATE(31,12,2001);
        ADDRESS ada4=new ADDRESS("384","Ly Thai To","quan 10","Ho Chi Minh");
        CUSTOMER a4=new CUSTOMER(5,"Ha Tran Duy Phat","0799664334",ada4,"haphat@gmail.com","05",ad4,"Nam");
        dscustomer[0]=a;
        dscustomer[1]=a1;
        dscustomer[2]=a2;
        dscustomer[3]=a3;
        dscustomer[4]=a4;
        list=new ArrayList<CUSTOMER>(Arrays.asList(dscustomer));
    }
    public void writefile(){
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            DATE ad=new DATE(19,8,2004);
            ADDRESS ada=new ADDRESS("2086","Huynh Tan Phat","Nha Be","Ho Chi Minh");
            CUSTOMER a=new CUSTOMER(1,"Nguyen Hoang Tuan Kiet","0798980217",ada,"ngkietbaby19@gmail.com","01",ad,"Nam");
            DATE ad1=new DATE(10,11,2004);
            ADDRESS ada1=new ADDRESS("44C/67","Bui Van Ba","7","Ho Chi Minh");
            CUSTOMER a1=new CUSTOMER(2,"Pham Ngoc Cat Nghi","02948572629",ada1,"catnghi@gmail.com","02",ad1,"Nu");
            DATE ad2=new DATE(19,4,2004);
            ADDRESS ada2=new ADDRESS("So 3","Nguyen Binh Khiem","quan 1","Ho Chi Minh");
            CUSTOMER a2=new CUSTOMER(3,"Nguyen Hoang Tuan Kiet","0987654321",ada2,"tuankiet@gamil.com","03",ad2,"Nam");
            DATE ad3=new DATE(1,1,2000);
            ADDRESS ada3=new ADDRESS("123","An Duong Vuong","quan 5","Ho Chi Minh");
            CUSTOMER a3=new CUSTOMER(4,"Nguyen Ngoc Nhung","0902720212",ada3,"ngocnhung@gmail.com","04",ad3,"Nu");
            DATE ad4=new DATE(31,12,2001);
            ADDRESS ada4=new ADDRESS("384","Ly Thai To","quan 10","Ho Chi Minh");
            CUSTOMER a4=new CUSTOMER(5,"Ha Tran Duy Phat","0799664334",ada4,"haphat@gmail.com","05",ad4,"Nam");
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
        DScustomer a=new DScustomer();
        a.Khoitao();
        a.xuatcustomer();
    }
    
}
