/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiemCatToc.Model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author MSI PC
 */
public class QuanLyModel {

    private ArrayList<LichHen> lh;
    private ArrayList<KhachHang> kh;
    private double doanhThu;

    public QuanLyModel() {
        this.lh = new ArrayList<>();
        this.kh = new ArrayList<>();
        this.doanhThu = 0;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    public ArrayList<LichHen> getLh() {
        return lh;
    }

    public ArrayList<KhachHang> getKh() {
        return kh;
    }

    public void setLh(ArrayList<LichHen> lh) {
        this.lh = lh;
    }

    public void setKh(ArrayList<KhachHang> kh) {
        this.kh = kh;
    }

    public void insert(LichHen lichHen) {
        this.lh.add(lichHen);
    }

    public void insert(KhachHang khachHang) {
        this.kh.add(khachHang);
    }

    public void update(LichHen lichhen) {
        for (LichHen l : lh) {
            if (l.getTenKh().equals(lichhen.getTenKh()) && l.getSdt() == lichhen.getSdt()) {
                l.setNgayDat(lichhen.getNgayDat());
                l.setGioDat(lichhen.getGioDat());
            }
        }
    }
    public void update(KhachHang khachHang){
        for(KhachHang k :kh){
            if(k.getMaKH().equals(khachHang.getMaKH())){
                k.getLh().setTenKh(khachHang.getLh().getTenKh());
                k.getLh().setSdt(khachHang.getLh().getSdt());
                k.setTienDichVu(khachHang.getTienDichVu());
                System.out.println(k);
            }
        }
    }
    public void remove(LichHen lichHen) {
        
        for(LichHen l :lh){
            System.out.println(l.getMaLH() +  " || " + lichHen.getMaLH());
            System.out.println(l.getMaLH().equals(lichHen.getMaLH()));
            if(l.getMaLH().equals(lichHen.getMaLH())){
                lh.remove(l);
                break;
            }
        }
    }

    public void remove(KhachHang khachHang) {
       for(KhachHang k :kh){
            if(k.getMaKH().equals(khachHang.getMaKH())){
                kh.remove(k);
                break;
            }
        }
    }

    public void doanhThu(LocalDate ngay) {
        double total = 0;
        for (KhachHang khachHang : kh) {
            if(khachHang.getLh().getNgayDat().compareTo(ngay) == 0){
                total += khachHang.getTienDichVu();
            }
        }
        this.doanhThu = total;
    }

    public boolean kiemTraMaLH(String maLH) {
        boolean k = false;
        for (LichHen l : lh) {
            if (l.getMaLH().equals(maLH)) {
                k = true;
            }
        }

        return k;
    }

    public boolean kiemTraMaKH(String maLH) {
        boolean k = false;
        for (LichHen l : lh) {
            if (l.getMaLH().equals(maLH)) {
                k = true;
            }
        }

        return k;
    }

    public boolean kiemTraLich(LichHen lich) {
        boolean k = false;
        for (LichHen l : lh) {
            if (l.getTenKh().equals(lich.getTenKh()) && l.getSdt() == lich.getSdt()) {
                k = true;
            }
        }

        return k;
    }

    public LichHen layLichHen(LichHen lich) {
        LichHen Lich = null;
        for (LichHen l : lh) {
            if (l.getTenKh().equals(lich.getTenKh()) && l.getSdt() == lich.getSdt()) {
                Lich = l;
            }
        }
        return Lich;
    }

    public boolean kiemTraNgayHen(LichHen lich) {
       boolean k = false;
        for (LichHen l : lh) {
            if (l.getTenKh().equals(lich.getTenKh()) && l.getSdt() == lich.getSdt()) {
               if(l.getNgayDat().compareTo(LocalDate.now()) == 0){
                   return true;
               }
            }
        }

        return k;
    }
  
   

}
