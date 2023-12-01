import java.io.Serializable;
import java.util.Scanner;

public class STAFF implements PERSON,Serializable {
    private String name;
    private String sdt;
    private String email;
    private ADDRESS address;
    private DATE dob;
    private String ma;
    private String sex;
    public String tk;
    public String mk;
    public static int count=0;
    private int n;

    Scanner sc = new Scanner(System.in);

    public STAFF(int n,String name, String sdt, ADDRESS address, String email, String ma, DATE dob, String sex, String tk, String mk) {
        this.name = name;
        this.sdt = sdt;
        this.address = address;
        this.email = email;
        this.ma = ma;
        this.dob = dob;
        this.sex = sex;
        this.tk=tk;
        this.mk=mk;
        this.n=n;
        count++;
    }

    public STAFF() {
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

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public void nhapPerson() {
        name = Check.nhapChuoi("Ho va ten: ", "Error");
        sex = Check.nhapChuoi("Gioi tinh: ", "Error");
        ma = Check.nhapChuoi("Ma nhan vien: ", "Error");
        sdt = Check.nhapChuoi("So dien thoai: ", "Error");
        email = Check.nhapChuoi("Email: ", "Error ");
        tk=Check.nhapChuoi("Ten dang nhap tai khoan: ","Error");
        mk=Check.nhapChuoi("Mat khau: ","Error");
        dob=Check.nhapNgayThang("Nhap ngay thang nam sinh: ","Error");
        address=Check.nhapDiaChi("Nhap dia chi: ","Error");
    }

    @Override
    public void xuatPerson() {
        System.out.printf("%-5d%-5s%-25s%-12s%-12s%-15s%-25s%-45s%-13s%-10s\n",n,ma,name,sex,dob,sdt,email,address,tk,mk);
    }

    @Override
    public String toString() {
        return n+" "+name+" "+sex+" "+dob.toString()+" "+sdt+" "+email+" "+address+" "+tk+" "+mk;
    }

    public static void main(String[] args) {
        PERSON a = new STAFF();
        a.nhapPerson();
        System.out.println(a);
    }
}
