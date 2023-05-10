/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiemCatToc.Model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author MSI PC
 */
public class LichHen {
    private String maLH;
    private String tenKh;
    private int sdt;
    private LocalDate ngayDat;
    private LocalTime gioDat;

    public LichHen(String maLH, String tenKh, int sdt, LocalDate ngayDat, LocalTime gioDat) {
        this.maLH = maLH;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.ngayDat = ngayDat;
        this.gioDat = gioDat;
    }
    
    public LichHen(String tenKh, int sdt, LocalDate ngayDat, LocalTime gioDat) {
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.ngayDat = ngayDat;
        this.gioDat = gioDat;
    }

    public String getTenKh() {
        return tenKh;
    }

    public int getSdt() {
        return sdt;
    }

    public LocalDate getNgayDat() {
        return ngayDat;
    }

    public LocalTime getGioDat() {
        return gioDat;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public void setNgayDat(LocalDate ngayDat) {
        this.ngayDat = ngayDat;
    }

    public void setGioDat(LocalTime gioDat) {
        this.gioDat = gioDat;
    }

    public LichHen(String tenKh, int sdt) {
        this.tenKh = tenKh;
        this.sdt = sdt;
    }

    public String getMaLH() {
        return maLH;
    }

    public void setMaLH(String maLH) {
        this.maLH = maLH;
    }

    @Override
    public String toString() {
        return "LichHen{" + "maLH=" + maLH + ", tenKh=" + tenKh + ", sdt=" + sdt + ", ngayDat=" + ngayDat + ", gioDat=" + gioDat + '}';
    }
    
   
    
}
