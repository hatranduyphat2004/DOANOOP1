public class Nhapdanhsach {
    public static void main(String[] args){
        DANHSACH ds=new DANHSACH();
        DSNHANVIEN dsnv=new DSNHANVIEN();
        DScustomer dskh=new DScustomer();
        DSsupplier dsncc=new DSsupplier();
        Nhaphang nhaphang=new Nhaphang();
        ds.nhapdanhsach();
        dsnv.nhapstaff();
        dskh.nhapcustomer();
        dsncc.nhapsupplier();
        nhaphang.nhaphang();
    }
    
}
