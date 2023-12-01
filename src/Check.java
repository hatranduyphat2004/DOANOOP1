import java.util.InputMismatchException;
//import java.util.regex.Pattern ;

public class Check {
    public static String RegexNgayThang = ""; // Biểu thức chính quy (regex) để kiểm tra định dạng ngày
    public static String nhapChuoi(String thongBao, String thongBaoLoi) {
        String chuoiNhap = "";
        boolean kiemTra = false;
        while (!kiemTra) {
            // khối try-catch để bắt và xử lý ngoại lệ nếu người dùng nhập sai
            try {
                chuoiNhap = Common.nhapChuoi(thongBao); // lấy một ký tự để kiểm tra hợp lệ
                if (chuoiNhap.length() == 0) {
                    System.out.println(thongBaoLoi); // hiển thị thông báo lỗi
                } else {
                    kiemTra = true;
                }
            } catch (Exception e) {
                System.out.println(thongBaoLoi); // hiển thị thông báo lỗi
            }
        }
        return chuoiNhap;
    }
    public static int nhapSoNguyen(String thongBao, String thongBaoLoi) {
        int soNguyenNhap = 0;
        boolean kiemTra = false;

        do {
            try {
                soNguyenNhap = Common.nhapSoNguyen(thongBao);
                kiemTra = true;
            } catch (InputMismatchException e) {
                System.out.println(thongBaoLoi);
                Common.scanner.nextLine(); // Đọc và loại bỏ giá trị không hợp lệ từ scanner
            }
        } while (!kiemTra);

        return soNguyenNhap;
    }
    public static long nhapSoNguyenL(String thongBao, String thongBaoLoi) {
        long soNguyenNhap = 0;
        boolean kiemTra = false;

        do {
            try {
                soNguyenNhap = Common.nhapSoNguyenL(thongBao);
                kiemTra = true;
            } catch (InputMismatchException e) {
                System.out.println(thongBaoLoi);
                Common.scanner.nextLine(); // Đọc và loại bỏ giá trị không hợp lệ từ scanner
            }
        } while (!kiemTra);

        return soNguyenNhap;
    }
    public static float nhapSoThuc(String thongBao, String thongBaoLoi) {
        float NhapSoThuc = 0;
        boolean kiemTra = false;
        while (!kiemTra) {
            try {
                NhapSoThuc = Common.nhapSoThuc(thongBao);
                kiemTra = true;
            } catch (Exception e) {
                System.out.println(thongBaoLoi);
            }
        }
        return NhapSoThuc;
    }
    public static double nhapSoThapPhan(String thongBao, String thongBaoLoi) {
        double NhapSoThapPhan = 0;
        boolean kiemTra = false;
        while (!kiemTra) {
            try {
                NhapSoThapPhan = Common.nhapSoThapPhan(thongBao);
                kiemTra = true;
            } catch (Exception e) {
                System.out.println(thongBaoLoi);
            }
        }
        return NhapSoThapPhan;
    }
    public static char nhapKyTu(String thongBao, String thongBaoLoi) {
        char NhapKyTu = 0;
        boolean kiemTra = false;
        while (!kiemTra) {
            try {
                NhapKyTu = Common.nhapKyTu(thongBao );
                kiemTra = true;
            } catch (Exception e) {
                System.out.println(thongBaoLoi);
            }
        }
        return NhapKyTu;
    }
    public static boolean nhapBoolean(String thongBao, String thongBaoLoi) {
        boolean NhapBoolean = false;
        boolean kiemTra = false;
        while (!kiemTra) {
            try {
                NhapBoolean = Common.nhapBoolean(thongBao);
                kiemTra = true;
            } catch (Exception e) {
                System.out.println(thongBaoLoi);
            }
        }
        return NhapBoolean;
    }
    public static DATE nhapNgayThang(String thongBao, String thongBaoLoi) {
        DATE NhapNgay = null;
        boolean kiemTra = false;
        while (!kiemTra) {
            try {
                NhapNgay = Common.nhapNgayThang(thongBao);
                kiemTra = NhapNgay.checkDate();
            } catch (Exception e) {
                System.out.println(thongBaoLoi);
            }
        }
        return NhapNgay;
    }
    public static ADDRESS nhapDiaChi(String thongBao, String thongBaoLoi) {
        ADDRESS diaChi = Common.nhapDiaChi(thongBao);
        // Kiểm tra dữ liệu địa chỉ sau khi đã nhập
        if (diaChi.getsonha().isEmpty() || diaChi.getstreet().isEmpty() || diaChi.getcity().isEmpty()
                || diaChi.getcity().isEmpty()) {
            System.out.println(thongBaoLoi);
            return nhapDiaChi(thongBao, thongBaoLoi); // Yêu cầu nhập lại nếu dữ liệu không hợp lệ
        } else {
            return diaChi;
        }
    }
}
