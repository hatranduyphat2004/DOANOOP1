import java.io.Serializable;
import java.util.Scanner;

public class SUPPLIER implements PERSON,Serializable {
    private String name;
    private String sdt;
    private String email;
    private ADDRESS address;
    private DATE dob;
    private String ma;
    private int n;
    public static int count=0;
    transient Scanner sc = new Scanner(System.in);

    public SUPPLIER(int n,String name, String sdt, String email, ADDRESS address, String ma, DATE dob) {
        this.name = name;
        this.sdt = sdt;
        this.email = email;
        this.address = address;
        this.ma = ma;
        this.dob = dob;
        this.n=n;
        count++;
    }
    
    public SUPPLIER(){
        count++;
        name = null;
        sdt = null;
        email = null;
        address = new ADDRESS();
        dob = new DATE();
        ma = null;
        n=count;
    }

    public DATE getDob() {
        return dob;
    }

    public void setDob(DATE dob) {
        this.dob = dob;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getemail() {
        return email;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getname() {
        return name;
    }

    public void setsdt(String sdt) {
        this.sdt = sdt;
    }

    public String getsdt() {
        return sdt;
    }

    public void setaddress(ADDRESS address) {
        this.address = address;
    }

    public ADDRESS getaddress() {
        return address;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    @Override
    public void nhapPerson() {
        System.out.println("Day la nha cung cap");
        name = Check.nhapChuoi("Nha cung cap: ", "Error");
        ma = Check.nhapChuoi("Ma so doanh nghiep: ", "Error");
        sdt = Check.nhapChuoi("So dien thoai: ", "Error");
        email = Check.nhapChuoi("Email: ", "Error ");
        address = Check.nhapDiaChi("Dia chi: ", "Error");
        dob = Check.nhapNgayThang("Ngay kinh doanh: ", "error");
    }
    
    @Override
    public void xuatPerson() {
        System.out.printf("%-5d%-5s%-20s%-18s%-18s%-20s%-25s\n",n,ma,name,dob,sdt,email,address);
    }

    @Override
    public String toString() {
        return n+" "+name+" "+ma+" "+dob+" "+sdt+" "+email+" "+address;
    }

    public static void main(String[] args) {}
}
