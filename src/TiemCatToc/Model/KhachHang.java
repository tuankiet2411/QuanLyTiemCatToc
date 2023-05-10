/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiemCatToc.Model;

/**
 *
 * @author MSI PC
 */
public class KhachHang {
    private String maKH;

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public KhachHang(String maKH, LichHen lh, double tienDichVu) {
        this.maKH = maKH;
        this.lh = lh;
        this.tienDichVu = tienDichVu;
    }

   

    public String getMaKH() {
        return maKH;
    }

    public KhachHang(String maKH, LichHen lh, String dichVu, double tienDichVu) {
        this.maKH = maKH;
        this.lh = lh;
        this.dichVu = dichVu;
        this.tienDichVu = tienDichVu;
    }
    private LichHen lh;
    private String dichVu;
    private double tienDichVu;

    public LichHen getLh() {
        return lh;
    }

    public String getDichVu() {
        return dichVu;
    }

    public double getTienDichVu() {
        return tienDichVu;
    }

    public KhachHang(LichHen lh) {
        this.lh = lh;
    }

    public KhachHang(LichHen lh, String dichVu, double tienDichVu) {
        this.lh = lh;
        this.dichVu = dichVu;
        this.tienDichVu = tienDichVu;
    }

    public void setLh(LichHen lh) {
        this.lh = lh;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "lh=" + lh + ", dichVu=" + dichVu + ", tienDichVu=" + tienDichVu + '}';
    }

    public void setDichVu(String dichVu) {
        this.dichVu = dichVu;
    }

    public void setTienDichVu(double tienDichVu) {
        this.tienDichVu = tienDichVu;
    }
    
}
