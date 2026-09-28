package entity;

public class Sach extends TaiLieu{
    private String tenTacGia;
    private int soTrang;

    public Sach() {
    }

    public Sach(String maTaiLieu, int soBanPhatHanh, String tenNhaXb, String tenTacGia, int soTrang) {
        super(maTaiLieu, soBanPhatHanh, tenNhaXb);
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }
}
