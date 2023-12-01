import java.io.Serializable;
import java.util.Scanner;

interface PERSON extends Serializable{
    Scanner sc = new Scanner(System.in);

    void setDob(DATE dob);

    DATE getDob();

    void setemail(String email);

    String getemail();

    void setname(String name);

    String getname();

    void setsdt(String sdt);

    String getsdt();

    void setaddress(ADDRESS address);

    ADDRESS getaddress();

    void setMa(String ma);

    String getMa();

    void nhapPerson();

    String toString();

    void xuatPerson();

}
