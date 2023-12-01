import java.util.Scanner;

public class DANGNHAP extends taikhoan{
    static Scanner sc=new   Scanner(System.in);
    public void showmenu1(){
        System.out.println("1.Them");
        System.out.println("2.Tim kiem bang ten");
        System.out.println("3.Tim kiem bang ma");
        System.out.println("4.Xoa");
        System.out.println("5.Chinh sua");
        System.out.println("6.Xem tat ca");
        System.out.println("7.Thoat");
    }
    public void showmenu(){
        System.out.println("1.San pham");
        System.out.println("2.Nhan vien");
        System.out.println("3.Khach hang");
        System.out.println("4.Nha cung cap");
        System.out.println("5.Nhap hang");
        System.out.println("6.Xuat hang");
        System.out.println("7.Phieu Nhap");
        System.out.println("8.Phieu Xuat");
        System.out.println("9.Thong ke");
        System.out.println("10.So luong ton kho");
        System.out.println("11.Exit");
    }
    public void showmenu2(){
        System.out.println("1.Tim kiem bang ten");
        System.out.println("2.Tim kiem bang ma");
        System.out.println("3.Xem tat ca");
        System.out.println("4.Xuat hang");
        System.out.println("5.Thoat");
    }

    public static void main(String[] args){
        int choice,choice1,choice2;
        DSAdmin admin=new DSAdmin();
        DANHSACH ds=new DANHSACH();
        DSNHANVIEN dsnv=new DSNHANVIEN();
        DScustomer dskh=new DScustomer();
        DSsupplier dsncc=new DSsupplier();
        DANGNHAP dangnhap=new DANGNHAP();
        Nhaphang nhaphang=new Nhaphang();
        Xuathang xuathang=new Xuathang();
        FILE fi=new FILE();
        taikhoan account=new taikhoan();
        admin.admin();
        ds.Khoitao();
        dskh.Khoitao();
        dsnv.Khoitao();
        dsncc.Khoitao();
        nhaphang.Khoitao();
        do{
            int acc=account.dangnhap(admin,dsnv,dskh);
            if (acc ==1) {
                System.out.println("Day la Admin");
                do{
                    do{
                        dangnhap.showmenu();
                        choice=Check.nhapSoNguyen("Chon: ","Error");
                    }while(choice <1 || choice >7);
                    switch (choice) {
                        case 1:
                            ds.xuatdanhsach();
                            do{
                                do{
                                    dangnhap.showmenu1();
                                    choice1=Check.nhapSoNguyen("Chon: ","Error");
                                }while(choice1<1 || choice1 >7);
                                switch (choice1) {
                                    case 1: ds.Add();
                                            break;
                                    case 2: ds.FindbyName();
                                            break;
                                    case 3: ds.FindbyID();
                                            break;
                                    case 4: ds.Delete();
                                            break;
                                    case 5: ds.Edit();
                                            break;
                                    case 6: ds.xuatdanhsach();
                                            System.out.println();
                                            break;
                                    default:break;
                                }
                                System.out.println();
                            }while(choice1 !=7);
                            break;
                        case 2:
                            dsnv.xuatstaff();
                            do{
                                do{
                                    dangnhap.showmenu1();
                                    choice1=Check.nhapSoNguyen("Chon: ", "Error");
                                }while(choice1<1 || choice1>7);
                                switch (choice1) {
                                    case 1: dsnv.Add();
                                            break;
                                    case 2: dsnv.FindbyName();
                                            break;
                                    case 3: dsnv.FindbyID();
                                            break;
                                    case 4: dsnv.Delete();
                                            break;
                                    case 5: dsnv.Edit();
                                            break;
                                    case 6: dsnv.xuatstaff();
                                            break;
                                    default:break;
                                }
                                System.out.println();
                            }while(choice1 !=7);
                            break;
                        case 3:
                            dskh.xuatcustomer();
                            do{
                                do{
                                    dangnhap.showmenu1();
                                    choice1=Check.nhapSoNguyen("Chon: ", "Error");
                                }while(choice1<1 || choice1>7);
                                switch (choice1) {
                                    case 1: dskh.Add();
                                            break;
                                    case 2: dskh.FindbyName();
                                            break;
                                    case 3: dskh.FindbyID();
                                            break;
                                    case 4: dskh.Delete();
                                            break;
                                    case 5: dskh.Edit();
                                            break;
                                    case 6: dskh.xuatcustomer();
                                            break;
                                    default:break;
                                }
                            }while(choice1 !=7);
                            break;
                        case 4:
                            dsncc.xuatsupplier();
                            do{
                                do{
                                    dangnhap.showmenu1();
                                    choice1=Check.nhapSoNguyen("Chon: ", "Error");
                                }while(choice1<1 || choice>7);
                                switch (choice1) {
                                    case 1: dsncc.Add();
                                            break;
                                    case 2: dsncc.FindbyName();
                                            break;
                                    case 3: dsncc.FindbyID();
                                            break;
                                    case 4: dsncc.Delete();
                                            break;
                                    case 5: dsncc.Edit();
                                            break;
                                    case 6: dsncc.xuatsupplier();
                                            break;
                                    default:break;
                                }
                                System.out.println();
                            }while(choice1 !=7);
                            break;
                        case 5: dsncc.xuatsupplier();
                                nhaphang.xuathang();
                                nhaphang.nhapphieunhap(dsnv,dsncc);
                                nhaphang.xuatphieunhap();
                                break;
                        case 6: dskh.xuatcustomer();
                                ds.xuatdanhsach();
                                System.out.println();
                                xuathang.nhapphieuxuat(ds, dskh);
                                xuathang.xuatphiexuat();
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        default:break;
                    }
                    System.out.println();
                }while(choice!=7);
            }
            else if(acc==2){
                System.out.println("Day la nhan vien");
                ds.xuatdanhsach();
                    do{
                        do{
                            dangnhap.showmenu2();
                            choice=Check.nhapSoNguyen("Chon: ","Error");
                        }while(choice<1 || choice>5);
                        switch (choice) {
                            case 1: ds.FindbyName();
                                    break;
                            case 2: ds.FindbyID();
                                    break;
                            case 3: ds.xuatdanhsach();
                                    break;
                            case 4: ds.xuatdanhsach();
                                    dskh.xuatcustomer();
                                    xuathang.nhapphieuxuat(ds, dsnv, dskh);
                                    xuathang.xuatphiexuat();
                                    break;
                            default:break;
                        }
                        System.out.println();
                    }while(choice !=5);
            }
            System.out.println("Dang nhap tiep tuc?");
            System.out.println("1.Yes");
            System.out.println("2.No");
            choice2=Check.nhapSoNguyen("","Error");
        }while(choice2!=2);
    }
}