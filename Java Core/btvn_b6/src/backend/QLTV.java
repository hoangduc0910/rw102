package backend;

import entity.Bao;
import entity.Sach;
import entity.TaiLieu;
import entity.TapChi;

import java.util.ArrayList;
import java.util.List;

public class QLTV implements IQLTV{

    private List<TaiLieu> danhSachTaiLieu;

    public QLTV(){
        danhSachTaiLieu = new ArrayList<>();
        danhSachTaiLieu.add(new TaiLieu("101",20,"nxb1"));
        danhSachTaiLieu.add(new TaiLieu("102",30,"nxb2"));
        danhSachTaiLieu.add(new TaiLieu("103",15,"nxb3"));
        danhSachTaiLieu.add(new TaiLieu("104",10,"nxb2"));
    }


    @Override
    public void themMoiTaiLieu() {

    }

    @Override
    public void xoaTaiLieuTheoMa() {


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
        System.out.println("Nhập tài liệu cần tìm");
        
    }
}
