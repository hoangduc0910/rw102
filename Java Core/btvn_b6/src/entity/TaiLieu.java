package entity;

public class TaiLieu {
    private String maTaiLieu;
    private String tenNhaXb;
    private int soBanPhatHanh;

    public TaiLieu(){

    }

    public TaiLieu(String maTaiLieu, int soBanPhatHanh, String tenNhaXb) {
        this.maTaiLieu = maTaiLieu;
        this.soBanPhatHanh = soBanPhatHanh;
        this.tenNhaXb = tenNhaXb;
    }

    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public int getSoBanPhatHanh() {
        return soBanPhatHanh;
    }

    public void setSoBanPhatHanh(int soBanPhatHanh) {
        this.soBanPhatHanh = soBanPhatHanh;
    }

    public String getTenNhaXb() {
        return tenNhaXb;
    }

    public void setTenNhaXb(String tenNhaXb) {
        this.tenNhaXb = tenNhaXb;
    }
}
