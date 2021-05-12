package thi_module2.model;

public class DanhBa {
    public String soDienThoai;
    private String nhomDanhBa;
    private String hoten;
    private String gioitinh;
    private String diachi;
    private String ngaySinh;
    private String email;

    public DanhBa() {
    }

    public DanhBa(String soDienThoai, String nhomDanhBa, String hoten, String gioitinh, String diachi, String ngaySinh, String emial) {
        this.soDienThoai = soDienThoai;
        this.nhomDanhBa = nhomDanhBa;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.ngaySinh = ngaySinh;
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNhomDanhBa() {
        return nhomDanhBa;
    }

    public void setNhomDanhBa(String nhomDanhBa) {
        this.nhomDanhBa = nhomDanhBa;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return soDienThoai +
                "," + nhomDanhBa+
                "," + hoten+
                "," + gioitinh+
                "," + diachi+
                "," + ngaySinh+
                "," + email;
    }

    public void showInfor() {
        System.out.println(this.toString());
    }
}
