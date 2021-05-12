package thi_module2.exceptions;

public class GioiTinhException extends Exception {
    public GioiTinhException() {
        super("Nhập giới tính là male,female hoặc unknown");
    }
}
