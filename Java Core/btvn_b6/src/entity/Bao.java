package entity;

public class Bao extends TaiLieu {
    private String ngayPhatHanh;

    public Bao() {
    }

    public Bao(String maTaiLieu, int soBanPhatHanh, String tenNhaXb, String ngayPhatHanh) {
        super(maTaiLieu, soBanPhatHanh, tenNhaXb);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public String getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }
}
