import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Xuathang {
    public CTphieuxuat[] ctpx;
    public PhieuXuat[] px;
    public List<CTphieuxuat> listctpx;
    public List<PhieuXuat> listpx;
    private int n;
    private int m;
    private FILE fi;
    transient Scanner sc=new Scanner(System.in);
    public Xuathang(int n,int m, PhieuXuat[] px, CTphieuxuat[] ctpx) {
        this.m = m;
        this.px = px;
        this.ctpx = ctpx;
        this.n=n;
    }
    public Xuathang(){
        n=0;
        m=0;
        px=null;
        ctpx=null;
        fi=new FILE();
    }
    public void nhapphieuxuat(DANHSACH ds,DSNHANVIEN dsnv,DScustomer dskh){
        px=new PhieuXuat[m];
        PhieuXuat p=new PhieuXuat();
        dsnv.phieuxuat(p);
        dskh.phieuxuat(p);
        p.nhap();
        px=Arrays.copyOf(px,px.length+1);
        px[m]=p;
        m++;
        ctpx=new CTphieuxuat[n];
        CTphieuxuat a;
        int input,k;
        do{
            do{
                String masp=Check.nhapChuoi("Nhap vao ma san pham muon mua hang: ","Error");
                k=0;
                for(int i=0;i<ds.danhsach.length;i++){
                    a=new CTphieuxuat();
                    a.setMaPhieuXuat(p.getMaPhieuXuat());
                    if(ds.danhsach[i].getmasp().equalsIgnoreCase(masp)){
                        a.setTenSanPham(ds.danhsach[i].gettensp());
                        a.setMaSanPham(ds.danhsach[i].getmasp());
                        a.setSoLuong(inputquantity());
                        a.setDongia(ds.danhsach[i].getdongia());
                        a.setTongTien(ds.danhsach[i].getdongia()*a.getSoLuong());
                        ctpx=Arrays.copyOf(ctpx,ctpx.length+1);
                        ctpx[n]=a;
                        n++;
                        k++;
                    }
                }
                if(k==0)
                    System.out.println("Ma san pham khon ton tai");
            }while(k!=1);
            System.out.println("Ban co muon mua hang tiep?");
            System.out.println("1. Mua tiep");
            System.out.println("2. Exit");
            input=Check.nhapSoNguyen("Chon: ","Error");
        }while(input!=2);
        listctpx=new ArrayList<CTphieuxuat>(Arrays.asList(ctpx));
        listpx=new ArrayList<PhieuXuat>(Arrays.asList(px));
    }
    public void nhapphieuxuat(DANHSACH ds,DScustomer dskh){
        px=new PhieuXuat[m];
        PhieuXuat p=new PhieuXuat();
        dskh.phieuxuat(p);
        p.setMaNhanVien("ADMIN");
        p.nhap();
        px=Arrays.copyOf(px,px.length+1);
        px[m]=p;
        m++;
        ctpx=new CTphieuxuat[n];
        CTphieuxuat a;
        int input,k;
        do{
            do{
                String masp=Check.nhapChuoi("Nhap vao ma san pham muon mua hang: ","Error");
                k=0;
                for(int i=0;i<ds.danhsach.length;i++){
                    a=new CTphieuxuat();
                    a.setMaPhieuXuat(p.getMaPhieuXuat());
                    if(ds.danhsach[i].getmasp().equalsIgnoreCase(masp)){
                        a.setTenSanPham(ds.danhsach[i].gettensp());
                        a.setMaSanPham(ds.danhsach[i].getmasp());
                        a.setSoLuong(inputquantity());
                        a.setDongia(ds.danhsach[i].getdongia());
                        a.setTongTien(ds.danhsach[i].getdongia()*a.getSoLuong());
                        ctpx=Arrays.copyOf(ctpx,ctpx.length+1);
                        ctpx[n]=a;
                        m++;
                        k++;
                    }
                }
                if(k==0)
                    System.out.println("Ma san pham khon ton tai");
            }while(k!=1);
            System.out.println("Ban co muon mua hang tiep?");
            System.out.println("1. Mua tiep");
            System.out.println("2. Exit");
            input=Check.nhapSoNguyen("Chon: ","Error");
        }while(input!=2);
        listctpx=new ArrayList<CTphieuxuat>(Arrays.asList(ctpx));
        listpx=new ArrayList<PhieuXuat>(Arrays.asList(px));
    }
    public DATE inputdate(){
        return Check.nhapNgayThang("Nhap ngay xuat phieu: ","Error");
    }
    public int inputquantity(){
        while (true) {
            try{
                int sl=Check.nhapSoNguyen("Nhap vao so luong muon mua hang: ","Error");
                return sl;
            }catch (Exception e){
                System.out.print("KHONG HOP LE!!! Nhap lai so luong: ");
            }
        }
    }
    public void xemphieuxuatkhachhang(){
        for(CTphieuxuat a:ctpx)
            a.xuat();
    }
    public void Delete(){
        System.out.print("Nhap vao ma phieu xuat muon xoa: ");
        String name=sc.nextLine();
        int i,j,k;
        for(i=0;i<px.length;i++)
            if(px[i].getMaPhieuXuat().equalsIgnoreCase(name)){
                for(j=i;j<px.length-1;j++)
                    px[j]=px[j+1];
                m--;
                break;
            }
        for(i=0;i<ctpx.length;j++){
            for(j=0;j<px.length;j++){
                if (!px[j].getMaPhieuXuat().equalsIgnoreCase(ctpx[i].getMaPhieuXuat())) {
                    for(k=j;k<ctpx.length-1;k++)
                        ctpx[k]=ctpx[k+1];
                    n--;
                }
            }
        }
    }
    public void xuatphiexuat(){
        for(int j=0;j<px.length;j++){
            px[j].xuat();
            for(int i=0;i<ctpx.length;i++)
                if(ctpx[i].getMaPhieuXuat().equalsIgnoreCase(px[j].getMaPhieuXuat()))
                    ctpx[i].xuat();
        }
        System.out.println();
    }
    public void Khoitao(){}
    public static void main(String[] args){}
}
