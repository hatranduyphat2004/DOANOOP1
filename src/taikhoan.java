import java.util.Scanner;

public class taikhoan{
    Scanner sc=new   Scanner(System.in);
    public int dangnhap(DSAdmin admin,DSNHANVIEN nv,DScustomer kh){
        String tk,mk;
        int A=0;
        do{
            tk=Check.nhapChuoi("Ten dang nhap: ","Error");
            mk=Check.nhapChuoi(("Mat khau: "),"Error");
            for(int i=0;i<admin.dsAdmins.length;i++)
                if(admin.dsAdmins[i].getTendangnhap().equalsIgnoreCase(tk) && admin.dsAdmins[i].getMatkhau().equalsIgnoreCase(mk)){
                    A++;
                    System.out.println("Dang nhap thanh cong\n");
                    return 1;
                }
            for(int i=0;i<nv.dsnhanvien.length;i++)
                if(nv.dsnhanvien[i].getTk().equalsIgnoreCase(tk) && nv.dsnhanvien[i].getMk().equalsIgnoreCase(mk)){
                    A++;
                    System.out.println("Dang nhap thanh cong\n");
                    return 2;
                }
        }while(A!=1);
        return 0;
    }
    public static void main(String[] args){}
}

