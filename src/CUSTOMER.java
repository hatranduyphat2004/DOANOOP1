import java.io.Serializable;
import java.util.Scanner;

public class CUSTOMER implements PERSON,Serializable {
    private String name;
    private String sdt;
    private String email;
    private ADDRESS address;
    private DATE dob;
    private String ma;
    private String sex;
    private int n;
    public static int count=0;
    
    Scanner sc = new Scanner(System.in);

    public CUSTOMER(int n,String name, String sdt, ADDRESS address, String email, String ma, DATE dob, String sex) {
        this.name = name;
        this.sdt = sdt;
        this.address = address;
        this.email = email;
        this.ma = ma;
        this.dob = dob;
        this.sex = sex;
        this.n=n;
        count++;
    }

    public CUSTOMER() {
        count++;
        name = null;
        sdt = null;
        email = null;
        address = new ADDRESS();
        dob = new DATE();
        ma = null;
        sex = null;
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

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public void nhapPerson() {
        name = Check.nhapChuoi("Ho va ten: ", "Error");
        sex = Check.nhapChuoi("Gioi tinh: ", "Error");
        ma = Check.nhapChuoi("Ma so khach hang: ", "Error");
        dob = Check.nhapNgayThang("Ngay thang nam sinh: ", "error");
        sdt = Check.nhapChuoi("So dien thoai: ", "Error");
        email = Check.nhapChuoi("Email: ", "Error ");
        address = Check.nhapDiaChi("Dia chi: ", "Error");
        sc.nextLine();
    }



    @Override
    public void xuatPerson() {
        System.out.printf("%-5d%-5s%-25s%-12s%-12s%-15s%-25s%-45s\n",n,ma,name,sex,dob,sdt,email,address);
    }

    @Override
    public String toString() {
        return n+" "+name+" "+sex+" "+dob+" "+sdt+" "+email+" "+address;
    }

    public static void main(String[] args) {
    }
}
