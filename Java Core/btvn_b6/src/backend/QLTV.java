package backend;

import entity.Bao;
import entity.Sach;
import entity.TaiLieu;
import entity.TapChi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLTV implements IQLTV{

    private List<TaiLieu> danhSachTaiLieu;
    private Scanner sc = new Scanner(System.in);

    public QLTV(){
        danhSachTaiLieu = new ArrayList<>();
        danhSachTaiLieu.add(new TaiLieu("101",20,"nxb1"));
        danhSachTaiLieu.add(new TaiLieu("102",30,"nxb2"));
        danhSachTaiLieu.add(new TaiLieu("103",15,"nxb3"));
        danhSachTaiLieu.add(new TaiLieu("104",10,"nxb2"));
    }


    @Override
    public void themMoiTaiLieu() {
        System.out.print("=== Thêm mới tài liệu ===");
        System.out.print("Nhập mã tài liệu");
        String maTaiLieu = sc.nextLine();
        System.out.print("Nhập số bản phát hành");
        int soBanPhatHanh = 0;
        while (true){
            if (!sc.hasNextInt()){
            sc.nextLine();
                System.out.println("Vui lòng nhập số bản phát hành");
            }else {
                soBanPhatHanh = sc.nextInt();
                sc.nextLine();
                if (soBanPhatHanh <= 0) {
                    System.out.println("Số bản phát hành ko được dưới 0");
                }else {
                    break;

                }
            }
        }
            System.out.print("Nhập tên nhà xuất bản");
        String tenNhaXb = sc.nextLine();
        //loại tài liệu: sách, báo, tạp chí
        System.out.print("Chọn loại tài liệu: 1.Sách    2.Báo    Khác.Tạp chí");
        String choice = sc.nextLine();
        switch (choice){
            case "1":
                System.out.println("Nhập tên tác giả");
                String tenTacGia = sc.nextLine();
                System.out.println("Nhập số trang");
                int soTrang = 0;
                while (true){
                    if (!sc.hasNextInt()){
                        sc.nextLine();
                        System.out.println("Vui lòng nhập số nguyên dương ");
                    }else {
                    soTrang = sc.nextInt();
                    sc.nextLine();
                    if (soTrang <= 0){
                        System.out.println("Số trang ko được dưới 0");
                    }else {
                        break;
                    }
                    }
                }
                TaiLieu sach = new Sach(maTaiLieu,soBanPhatHanh, tenNhaXb, tenTacGia, soTrang );
                danhSachTaiLieu.add(sach);
                System.out.println("thêm tài liệu sách thành công");
                break;
            case "2":
                System.out.println("Nhập ngày phát hành");
                int ngayPhatHanh;
                while (true){
                    if (!sc.hasNextInt()){
                        System.out.println("Vui lòng nhập số nguyên dương ");
                    }else {
                        ngayPhatHanh = sc.nextInt();
                        sc.nextLine();
                        if (ngayPhatHanh <1 || ngayPhatHanh >31){
                            System.out.println("Vui lòng nhập ngày phát hành từ 1-31");
                        }else {
                            break;
                        }
                    }
                }
                TaiLieu bao = new Bao(maTaiLieu,soBanPhatHanh, tenNhaXb, ngayPhatHanh);
                danhSachTaiLieu.add(bao);
                System.out.println("thêm tài liệu báo thành công");
                break;
            default:
                System.out.println("Nhập số phát hành");
                int soPhatHanh = 0;
                while (true){
                    if (!sc.hasNextInt()){
                        sc.nextLine();
                        System.out.println("Vui lòng nhập số nguyên dương ");
                    }else {
                        soPhatHanh = sc.nextInt();
                        sc.nextLine();
                        if (soBanPhatHanh <= 0){
                            System.out.println("Số pht hành ko được dưới 0");
                        }else {
                            break;
                        }
                    }
                }

                System.out.println("Nhập tháng phát hành ");
                int thangPhatHanh;
                while (true){
                   if (!sc.hasNextInt()){
                   sc.nextLine();
                       System.out.println("Vui lòng nhập số nguyên dương");
                   }else {
                       thangPhatHanh = sc.nextInt();
                       sc.nextLine();
                       if (thangPhatHanh <1 || thangPhatHanh >12){
                           System.out.println("Vui lòng nhập tháng phát hành từ 1-12");
                       }else {
                           break;
                       }
                   }
                }
                System.out.println("Thêm tài liệu tạp chí thành công ");
                TaiLieu tapChi = new TapChi(maTaiLieu,soPhatHanh,tenNhaXb,soPhatHanh,thangPhatHanh);
                danhSachTaiLieu.add(tapChi);
                System.out.println("Thêm tài liệu tạp chí thành công");
        }

    }

    @Override
    public void xoaTaiLieuTheoMa() {
        System.out.println("=== Xóa tài liệu ===");
        System.out.println("Nhập mã tài liệu cần xóa");
        String name = sc.nextLine();
        List<TaiLieu> danhSachXoa = new ArrayList<>();
            for (TaiLieu tl : danhSachTaiLieu){
                if (tl.getMaTaiLieu().equals(name)){
                danhSachXoa.add(tl);
                }
            }
        if (danhSachXoa.isEmpty()){
            System.out.println("Tài liệu ko có trên hệ thống");
        }else{
            danhSachTaiLieu.removeAll(danhSachXoa);
            System.out.println("Xóa tài liệu thành công");
        }
    }

    @Override
    public void hienThiTaiLieu() {
        System.out.println("=== Hiển thị toàn bộ tài liệu");
        System.out.println("+---------------+--------------------+----------+");
        System.out.printf("|%15s|%20s|%10s|\n", "Mã tài liệu", "Tên nhà xuất bản", "Số bản phát hành");
        System.out.println("+---------------+--------------------+----------+");
        for (TaiLieu tl: danhSachTaiLieu){
            System.out.printf("|%15s|%20s|%10s|\n",tl.getMaTaiLieu(), tl.getTenNhaXb(), tl.getSoBanPhatHanh());
        }
        System.out.println("+---------------+--------------------+----------+");
    }

    @Override
    public void timKiemTheoLoai() {
        System.out.println("=== Tìm kiếm ===");
        System.out.println("Nhập tên tài liệu cần tìm");
        String name = sc.nextLine();

        System.out.println("+---------------+--------------------+----------+");
        System.out.println("+---------------+--------------------+----------+");
        for (TaiLieu tl: danhSachTaiLieu){
            if (tl.getMaTaiLieu().contains(name)){
                System.out.printf("|%15s|%20s|%10s|\n",tl.getMaTaiLieu(), tl.getTenNhaXb(), tl.getSoBanPhatHanh());
            }
        }
        System.out.println("+---------------+--------------------+----------+");

    }
}
