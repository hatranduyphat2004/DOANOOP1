import java.io.Serializable;
import java.util.Scanner;

public class ADDRESS  implements Serializable{
    private String sonha;
    private String street;
    private String district;
    private String city;
    Scanner sc=new Scanner(System.in);
    public ADDRESS(String sonha,String street,String district,String city){
        this.sonha=sonha;
        this.street=street;
        this.district=district;
        this.city=city;
    }
    public ADDRESS(){
        sonha=null;
        street=null;
        district=null;
        city=null;
    }
    public void setsonha(String sonha){
        this.sonha=sonha;
    }
    public String getsonha(){
        return sonha;
    }
    public void setstreet(String street){
        this.street=street;
    }
    public String getstreet(){
        return street;
    }
    public void setdistrict(String district){
        this.district=district;
    }
    public String getdistrict(){
        return district;
    }
    public void setcity(String city){
        this.city=city;
    }
    public String getcity(){
        return city;
    }
    public void nhapADDRESS(){
        System.out.print("Nhap vao so nha: ");
        sonha=sc.nextLine();
        System.out.print("Nhap vao ten duong: ");
        street=sc.nextLine();
        System.out.print("Nhap vao ten/so quan: ");
        district=sc.nextLine();
        System.out.print("Nhao vao thanh pho: ");
        city=sc.nextLine();
    }
    public void xuatADDRESS(){
        System.out.print(sonha+" "+street+" "+district+" "+city);
    }
    public String toString(){
        return sonha+" "+street+" "+district+" "+city;
    }
    public static void main(String[] args){
        ADDRESS a=new ADDRESS();
        a.nhapADDRESS();
        a.xuatADDRESS();
    }

    
}
