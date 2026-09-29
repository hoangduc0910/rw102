package entity;

public class Bao extends TaiLieu {
    private int ngayPhatHanh;

    public Bao() {
    }

    public Bao(String maTaiLieu, int soBanPhatHanh, String tenNhaXb, int ngayPhatHanh) {
        super(maTaiLieu, soBanPhatHanh, tenNhaXb);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public int getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(int ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }
}
