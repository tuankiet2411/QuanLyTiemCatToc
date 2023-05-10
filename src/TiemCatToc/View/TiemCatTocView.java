/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiemCatToc.View;

import TiemCatToc.Controller.TiemCatTocController;
import TiemCatToc.Model.CacDichVu;
import TiemCatToc.Model.KhachHang;
import TiemCatToc.Model.LichHen;
import TiemCatToc.Model.QuanLyModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI PC
 */
public class TiemCatTocView extends JFrame {

    private QuanLyModel model;
    private JPanel datLich;
    private JButton xacNhan;
    private JPanel kiemTraThongTin;
    private TiemCatTocController ac;
    private JTextField inputName;
    private JTextField inputSdt;
    private JComboBox<Object> ngayDat;
    private JComboBox<Object> gioDat;
    private JTextField inputNameConfirm;
    private JTextField inputSdtConfirm;
    private JPanel dichVu;
    private ArrayList<Object> listDichVuPhu;
    private ButtonGroup groupButton;
    private KhachHang khachSuDungDV;
    private JLabel title;
    private JPanel jpanelEdit;
    private JTextField inputNameEdit;
    private JTextField inputSdtEdit;
    private JComboBox<Object> ngayDatEdit;
    private JComboBox<Object> gioDatEdit;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JPanel option;
    private JMenuItem itemCustomer;
    private JMenuItem itemManager;
    private JPanel optionCustomer;
    private JTable tableLich;
    private JComboBox<Object> ngayDatLich;
    private JTable tableKhach;
    private JScrollPane scrollPaneLich;
    private JPanel jpanelSearch;
    private JButton luu;
    private JPanel updateGuess;
    private JPanel jpanelCenter;
    private JTextField textFieldMaKH;
    private JTextField textFieldHoTen;
    private JTextField textFieldSdt;
    private JTextField textFieldPhiDichVu;
    private JPanel jpanelDayTotal;
    private JTable tableTongKet;
    private JScrollPane scrollPanelTongKet;
    private JComboBox<Object> ngayTongKet;
    private JLabel tongKet;
    private JPanel formTongKet;
    private JScrollPane scrollPaneKhach;
    private JPanel jpanelTableLich;
    private JPanel header_customer;

    public TiemCatTocView() {
        this.model = new QuanLyModel();
        this.init();
    }

    private void init() {
        this.setTitle("Tiệm cắt tóc");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        ac = new TiemCatTocController(this);
        JMenuBar jmenu = new JMenuBar();
        itemCustomer = new JMenuItem("Customer");
        itemManager = new JMenuItem("Manager");
        itemCustomer.addActionListener(ac);
        itemManager.addActionListener(ac);
        itemCustomer.setOpaque(true);
        itemCustomer.setBackground(Color.GRAY);
        itemCustomer.setForeground(Color.WHITE);
        jmenu.add(itemCustomer);
        jmenu.add(itemManager);
        header_customer = new JPanel();
        header_customer.setLayout(new BorderLayout(20, 20));
        JLabel labelImage = new JLabel();
        URL url = null;
        try {
            url = new URL("https://cl-wpml.s3.ap-southeast-1.amazonaws.com/cam-nang-viec-lam/wp-content/uploads/2023/04/10082824/barber-hipster-vintage-poster-709x1024.jpg");
        } catch (MalformedURLException ex) {
            Logger.getLogger(TiemCatTocView.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon icon = new ImageIcon(url);
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(300, 400, Image.SCALE_DEFAULT);

        option = new JPanel();
        btn1 = new JButton("Đặt lịch");
        btn2 = new JButton("Cắt tóc");
        btn3 = new JButton("Sửa lịch hẹn");
        option.setLayout(new GridLayout(1, 3));
        option.add(btn1);
        option.add(btn2);
        option.add(btn3);
        btn1.addActionListener(ac);
        btn2.addActionListener(ac);
        btn3.addActionListener(ac);

        title = new JLabel("Chào mừng tới tiệm cắt tóc Mesiuu", SwingConstants.CENTER);
        title.setFont(new Font("Times New Roman", Font.PLAIN, 22));

        labelImage.setIcon(new ImageIcon(newImage));
        labelImage.setHorizontalAlignment(SwingConstants.CENTER);
        header_customer.add(title, BorderLayout.NORTH);
        header_customer.add(labelImage, BorderLayout.CENTER);
        this.add(header_customer, BorderLayout.NORTH);
//       
        this.add(option, BorderLayout.SOUTH);
//       

        this.setJMenuBar(jmenu);

        this.setVisible(true);
    }

    public void removeCustomer() {
        if (option != null) {
            this.remove(option);
            this.repaint();
        }
    }

    public void formDatLich() {
        datLich = new JPanel();
        JLabel labelTen = new JLabel("Họ và tên ");
        JLabel labelSdt = new JLabel("Số điện thoại");
        JLabel labelNgay = new JLabel("Ngày đặt");
        JLabel lableGio = new JLabel("Giờ đặt");
        JLabel lableEmpty = new JLabel("");
        inputName = new JTextField();
        inputSdt = new JTextField();
        ngayDat = new JComboBox<>();
        gioDat = new JComboBox<>();
        JButton btnDat = new JButton("Đặt");
        btnDat.addActionListener(ac);
        LocalTime gio;
        for (int i = 8; i <= 21; i++) {
            gio = LocalTime.of(i, 0);
            gioDat.addItem(gio);
        }

        LocalDate now = LocalDate.now();
        ngayDat.addItem(now);
        for (int i = 1; i < 7; i++) {
            ngayDat.addItem(now.plusDays(i));
        }

        datLich.setLayout(new GridLayout(5, 2, 20, 20));
        datLich.add(labelTen);
        datLich.add(inputName);
        datLich.add(labelSdt);
        datLich.add(inputSdt);
        datLich.add(labelNgay);
        datLich.add(ngayDat);
        datLich.add(lableGio);
        datLich.add(gioDat);
        datLich.add(lableEmpty);
        datLich.add(btnDat);

    }

    public void formXacNhan() {
        kiemTraThongTin = new JPanel();
        JLabel labelTen = new JLabel("Họ và tên ");
        JLabel labelSdt = new JLabel("Số điện thoại");
        inputNameConfirm = new JTextField();
        inputSdtConfirm = new JTextField();
        JLabel lableEmpty = new JLabel("");
        xacNhan = new JButton("Xác nhận");
        xacNhan.addActionListener(ac);
        kiemTraThongTin.setLayout(new GridLayout(3, 2, 20, 20));
        kiemTraThongTin.add(labelTen);
        kiemTraThongTin.add(inputNameConfirm);
        kiemTraThongTin.add(labelSdt);
        kiemTraThongTin.add(inputSdtConfirm);
        kiemTraThongTin.add(lableEmpty);
        kiemTraThongTin.add(xacNhan);
    }

    public void xoaTitle() {
        if (header_customer != null) {
            this.remove(header_customer);
            this.repaint();
        }
    }

    public void xoaFormDat() {
        if (datLich != null) {
            this.remove(datLich);
            this.repaint();
        }
    }

    public void xoaFormCatToc() {
        if (kiemTraThongTin != null) {
            this.remove(kiemTraThongTin);
            this.repaint();
        }
    }

    public void xoaFormEdit() {
        if (jpanelEdit != null) {
            this.remove(jpanelEdit);
            this.repaint();
        }
    }

    public void datLich() {
        xoaTitle();
        xoaFormCatToc();
        xoaFormEdit();
        formDatLich();
        this.add(datLich, BorderLayout.NORTH);
        this.setVisible(true);

    }

    public void confirm() {
        xoaTitle();
        xoaFormDat();
        xoaFormEdit();
        formXacNhan();
        this.add(kiemTraThongTin, BorderLayout.NORTH);
        this.setVisible(true);
    }

    public void addLichHen() {
        if (this.inputName.getText().equals("") || this.inputSdt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            String maLH = "LH" + (this.model.getLh().size() + 1);
            String hoTen = this.inputName.getText().trim();
            int sdt = Integer.valueOf(this.inputSdt.getText().trim());
            LocalDate ngay = (LocalDate) this.ngayDat.getSelectedItem();
            LocalTime gio = (LocalTime) this.gioDat.getSelectedItem();

            if (this.model.kiemTraMaLH(maLH)) {
                maLH = "LH" + (this.model.getLh().size() + 2);
            }

            LichHen lh = new LichHen(maLH, hoTen, sdt, ngay, gio);

            this.model.insert(lh);
            JOptionPane.showMessageDialog(this, "Bạn đã đặt lịch thành công");
            resetFormDatLich();

        }

    }

    public void resetFormDatLich() {
        this.inputName.setText("");
        this.inputSdt.setText("");
        this.ngayDat.setSelectedIndex(0);
        this.gioDat.setSelectedIndex(0);
    }

    public void kiemTra() {
        if (this.inputNameConfirm.getText().equals("") || this.inputSdtConfirm.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            String hoTen = this.inputNameConfirm.getText().trim();
            int sdt = Integer.valueOf(this.inputSdtConfirm.getText().trim());
            LichHen lh = new LichHen(hoTen, sdt);
            if (!this.model.kiemTraLich(lh)) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy lịch hẹn của quý khách \n Kiểm tra lại thông tin lịch ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else {
                if (!this.model.kiemTraNgayHen(lh)) {
                    JOptionPane.showMessageDialog(this, "Hôm nay không có lịch hẹn của bạn", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else {
                    khachSuDungDV = new KhachHang(this.model.layLichHen(lh));
                    this.model.remove(this.model.layLichHen(lh));
                    dichVuCatToc();
                }

            }
        }

    }

    public void dichVuCatToc() {

        if (kiemTraThongTin != null) {
            this.remove(kiemTraThongTin);
            this.repaint();
        }
        formCatToc();
        this.add(dichVu, BorderLayout.NORTH);
        this.setVisible(true);
    }

    public void formCatToc() {
        dichVu = new JPanel();
        JLabel chonDichVu = new JLabel("Chọc các dịch vụ ");
        JPanel cacDichVu = new JPanel();
        groupButton = new ButtonGroup();
        JRadioButton combo1 = new JRadioButton("Cắt tóc + gội đầu");
        JRadioButton combo2 = new JRadioButton("Cắt tóc + gội đầu + uốn");
        JRadioButton combo3 = new JRadioButton("Cắt tóc + gội đầu + uốn + nhuộm");
        groupButton.add(combo1);
        groupButton.add(combo2);
        groupButton.add(combo3);
        cacDichVu.setLayout(new GridLayout(3, 1));
        cacDichVu.add(combo1);
        cacDichVu.add(combo2);
        cacDichVu.add(combo3);

        JLabel dichVuKhac = new JLabel("Các dịch vụ khác");
        JPanel cacDichVuKhac = new JPanel();
        JCheckBox dichVuPhu2 = new JCheckBox("Cạo râu");
        JCheckBox dichVuPhu3 = new JCheckBox("Cạo khăn nóng");
        cacDichVuKhac.setLayout(new GridLayout(3, 1));
        cacDichVuKhac.add(dichVuPhu2);
        cacDichVuKhac.add(dichVuPhu3);
        listDichVuPhu = new ArrayList<>();
        listDichVuPhu.add(dichVuPhu2);
        listDichVuPhu.add(dichVuPhu3);
        JLabel empty = new JLabel("");
        JButton btnCatToc = new JButton("Chọn");
        btnCatToc.addActionListener(ac);

        dichVu.setLayout(new GridLayout(3, 2));
        dichVu.add(chonDichVu);
        dichVu.add(cacDichVu);
        dichVu.add(dichVuKhac);
        dichVu.add(cacDichVuKhac);
        dichVu.add(empty);
        dichVu.add(btnCatToc);

    }

    public void thanhToan() {

        int luaChon = JOptionPane.showConfirmDialog(this, "Bạn vui lòng nhấn yes để thanh toán");

        if (luaChon == JOptionPane.YES_OPTION) {
            String cacDichVu = "";
            Enumeration<AbstractButton> selectMonChinh = groupButton.getElements();
            while (selectMonChinh.hasMoreElements()) {
                AbstractButton b = selectMonChinh.nextElement();
                if (b.isSelected()) {

                    cacDichVu = b.getText() + ",";
                }

            }

            for (int i = 0; i < listDichVuPhu.toArray().length; i++) {
                AbstractButton b = (AbstractButton) listDichVuPhu.get(i);
                if (b.isSelected()) {
                    if (i == listDichVuPhu.toArray().length - 1) {
                        cacDichVu = cacDichVu + b.getText();
                    } else {
                        cacDichVu = cacDichVu + b.getText() + ",";
                    }

                }
            }

            CacDichVu dichvu = new CacDichVu();
            double phiDichVU = dichvu.tongTienDichVu(cacDichVu);
            String maKH = "KH" + (this.model.getKh().size() + 1);
            if (this.model.kiemTraMaKH(maKH)) {
                maKH = "KH" + (this.model.getKh().size() + 2);
            }
            this.khachSuDungDV.setMaKH(maKH);
            this.khachSuDungDV.setDichVu(cacDichVu);
            this.khachSuDungDV.setTienDichVu(phiDichVU);
            this.model.insert(khachSuDungDV);
            JOptionPane.showMessageDialog(this, "Cảm ơn bạn đã sử dụng dich vụ của chúng tôi");
            this.remove(dichVu);
            this.repaint();
            this.remove(this);
            this.confirm();

        }
    }

    public void editLich() {
        xoaTitle();
        xoaFormDat();
        xoaFormCatToc();
        formEditLich();
        this.add(jpanelEdit, BorderLayout.NORTH);
        this.setVisible(true);

    }

    public void formEditLich() {
        jpanelEdit = new JPanel();
        JLabel labelTen = new JLabel("Họ và tên ");
        JLabel labelSdt = new JLabel("Số điện thoại");
        JLabel labelNgay = new JLabel("Ngày đặt");
        JLabel lableGio = new JLabel("Giờ đặt");
        JLabel lableEmpty = new JLabel("");
        inputNameEdit = new JTextField();
        inputSdtEdit = new JTextField();
        ngayDatEdit = new JComboBox<>();
        ngayDatEdit.setPreferredSize(new Dimension(200, 20));
        gioDatEdit = new JComboBox<>();
        JButton btnEdit = new JButton("Cập nhật");
        btnEdit.addActionListener(ac);
        LocalTime gio;
        for (int i = 8; i <= 21; i++) {
            gio = LocalTime.of(i, 0);
            gioDatEdit.addItem(gio);
        }
        LocalDate now = LocalDate.now();
        ngayDatEdit.addItem(now);
        for (int i = 1; i < 7; i++) {
            ngayDatEdit.addItem(now.plusDays(i));
        }
        jpanelEdit.setLayout(new GridLayout(5, 2, 20, 20));
        jpanelEdit.add(labelTen);
        jpanelEdit.add(inputNameEdit);
        jpanelEdit.add(labelSdt);
        jpanelEdit.add(inputSdtEdit);
        jpanelEdit.add(labelNgay);
        jpanelEdit.add(ngayDatEdit);
        jpanelEdit.add(lableGio);
        jpanelEdit.add(gioDatEdit);
        jpanelEdit.add(lableEmpty);
        jpanelEdit.add(btnEdit);
    }

    public void updateLich() {
        String hoTen = this.inputNameEdit.getText().trim();
        int sdt = Integer.valueOf(this.inputSdtEdit.getText().trim());
        LocalDate ngay = (LocalDate) this.ngayDatEdit.getSelectedItem();
        LocalTime gio = (LocalTime) this.gioDatEdit.getSelectedItem();

        LichHen lh = new LichHen(hoTen, sdt, ngay, gio);
        this.model.update(lh);
        JOptionPane.showMessageDialog(this, "Lịch hẹn \nTên: " + hoTen + " và  sdt: " + sdt + " đã thay đổi lịch hẹn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        this.resetForm();
    }

    public void resetForm() {
        this.inputNameEdit.setText("");
        this.inputSdtEdit.setText("");
        this.ngayDatEdit.setSelectedIndex(0);
        this.gioDatEdit.setSelectedIndex(0);
    }

    public void movedPage() {
        layoutEmpty();
    }

    public void layoutEmpty() {
        this.removeCustomer();
        this.xoaTitle();
        this.xoaFormCatToc();
        this.xoaFormDat();
        this.xoaFormEdit();
        itemManager.setBackground(Color.GRAY);
        itemManager.setForeground(Color.WHITE);
        itemCustomer.setOpaque(true);
        itemCustomer.setBackground(UIManager.getColor("Menu.background"));
        itemCustomer.setForeground(UIManager.getColor("Menu.foreground"));

        this.formCustomer();
        this.setVisible(true);

    }

    public void formCustomer() {
        optionCustomer = new JPanel();
        JButton quanLiLich = new JButton("Quản lý lịch hẹn");
        quanLiLich.addActionListener(ac);
        JButton quanLiKhach = new JButton("Quản lý khách hàng");
        quanLiKhach.addActionListener(ac);
        JButton quanLiDoanhThu = new JButton("Quản lý doanh thu");
        quanLiDoanhThu.addActionListener(ac);
        optionCustomer.setLayout(new GridLayout(1, 3));
        optionCustomer.add(quanLiLich);
        optionCustomer.add(quanLiKhach);
        optionCustomer.add(quanLiDoanhThu);

        this.add(optionCustomer, BorderLayout.SOUTH);
        this.setVisible(true);

    }

    public void formQuanLiLich() {

        jpanelSearch = new JPanel();
        JLabel labelSearch = new JLabel("Tìm kiếm");
        ngayDatLich = new JComboBox<>();
        LocalDate now = LocalDate.now();
        jpanelTableLich = new JPanel();
        jpanelTableLich.setLayout(new BorderLayout());

        ngayDatLich.addItem(now);
        for (int i = 1; i < 7; i++) {
            ngayDatLich.addItem(now.plusDays(i));
        }
        JButton btnLoc = new JButton("Lọc");
        btnLoc.addActionListener(ac);
        jpanelSearch.setLayout(new GridLayout(1, 3));
        jpanelSearch.add(labelSearch);
        jpanelSearch.add(ngayDatLich);
        jpanelSearch.add(btnLoc);

        tableLich = new JTable();
        tableLich.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã khách hàng", "Họ tên khách", "Số điện thoại", "Ngày đặt", "Giờ đặt"
                }
        ));
        tableLich.setPreferredScrollableViewportSize(new Dimension(800, 250));
        scrollPaneLich = new JScrollPane(tableLich);
        JButton btnXoaLich = new JButton("Xóa lịch");
        JPanel box = new JPanel();
        box.add(btnXoaLich);
        btnXoaLich.addActionListener(ac);
        btnXoaLich.setPreferredSize(new Dimension(100, 20));

        jpanelTableLich.add(scrollPaneLich, BorderLayout.NORTH);
        jpanelTableLich.add(box, BorderLayout.EAST);
        this.add(jpanelSearch, BorderLayout.NORTH);
        this.add(jpanelTableLich, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void tableLich() {
        xoaTableKhach();
        xoaTongKet();
        formQuanLiLich();
        insertTableLich();
    }

    public void resetTable(JTable table) {
        DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
        for (int i = table.getRowCount() - 1; i >= 0; i--) {
            modelTable.removeRow(i);
        }

    }

    public void insertTableLich() {
        LocalDate ngayChon = (LocalDate) this.ngayDatLich.getSelectedItem();
        DefaultTableModel modelTable = (DefaultTableModel) tableLich.getModel();
        for (int i = 0; i < this.model.getLh().size(); i++) {
            LichHen lh = this.model.getLh().get(i);
            if (lh.getNgayDat().compareTo(ngayChon) == 0) {
                modelTable.addRow(new Object[]{
                    lh.getMaLH() + "",
                    lh.getTenKh() + "",
                    lh.getSdt() + "",
                    lh.getNgayDat() + "",
                    lh.getGioDat() + ""
                });
            }

        }
    }

    public void locNgayDat() {
        resetTable(tableLich);
        insertTableLich();
    }

    public LichHen lichHenDuocChon() {
        DefaultTableModel modelTable = (DefaultTableModel) tableLich.getModel();

        int row = tableLich.getSelectedRow();
        String maLh = (modelTable.getValueAt(row, 0) + "").trim();
        String tenKh = (modelTable.getValueAt(row, 1) + "").trim();
        int sdt = Integer.valueOf((modelTable.getValueAt(row, 2) + "").trim());
        LocalDate ngayDat = LocalDate.parse(modelTable.getValueAt(row, 3) + "");
        LocalTime gioDat = LocalTime.parse(modelTable.getValueAt(row, 4) + "");
        LichHen lh = new LichHen(maLh, tenKh, sdt, ngayDat, gioDat);

        return lh;
    }

    public void xoaLichHen() {
        LichHen lh = this.lichHenDuocChon();
        int luaChon = JOptionPane.showConfirmDialog(this, "Bạn vui có chắc muốn xóa lịch hẹn");

        if (luaChon == JOptionPane.YES_OPTION) {
            System.out.println("xóa");
            this.model.remove(lh);
            this.resetTable(tableLich);
            this.insertTableLich();
        }

    }

    public void tableKhach() {
        xoaTableLich();
        xoaTongKet();
        formQuanLiKhach();
        insertDataKhach();
    }

    public void insertDataKhach() {
        DefaultTableModel modelTable = (DefaultTableModel) tableKhach.getModel();
        for (int i = 0; i < this.model.getKh().size(); i++) {
            KhachHang kh = this.model.getKh().get(i);
            modelTable.addRow(new Object[]{
                kh.getMaKH() + "",
                kh.getLh().getTenKh() + "",
                kh.getLh().getSdt() + "",
                kh.getLh().getNgayDat() + "",
                kh.getLh().getGioDat() + "",
                kh.getDichVu() + "",
                kh.getTienDichVu()
            });

        }
    }

    public void formQuanLiKhach() {
        tableKhach = new JTable();
        tableKhach.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã khách hàng", "Họ tên khách", "Số điện thoại", "Ngày đặt", "Giờ đặt", "Dịch vụ sử dụng", "Tiền dịch vụ"
                }
        ));
        tableKhach.setPreferredScrollableViewportSize(new Dimension(800, 250));
        JPanel featureKhach = new JPanel();
        JButton btnUpdateKhach = new JButton("Chỉnh sửa");
        btnUpdateKhach.addActionListener(ac);

        JButton btnDeleteKhach = new JButton("Xóa");
        btnDeleteKhach.addActionListener(ac);
        featureKhach.add(btnUpdateKhach);
        featureKhach.add(btnDeleteKhach);
        jpanelCenter = new JPanel();
        jpanelCenter.setLayout(new BorderLayout());
        jpanelCenter.add(featureKhach, BorderLayout.NORTH);

        scrollPaneKhach = new JScrollPane(tableKhach);

        this.add(scrollPaneKhach, BorderLayout.NORTH);
        this.add(jpanelCenter, BorderLayout.EAST);
        this.setVisible(true);
    }

    public void xoaTableLich() {
        if (jpanelTableLich != null && jpanelSearch != null) {
            this.remove(jpanelTableLich);
            this.remove(jpanelSearch);
            this.revalidate();
            this.repaint();
        }
    }

    public void updateGuess() {
        formUpdateGuess();
    }

    public void formUpdateGuess() {
        updateGuess = new JPanel();

        JLabel labelMaKH = new JLabel("Mã khách hàng");
        JLabel labelTen = new JLabel("Họ và tên ");
        JLabel labelSdt = new JLabel("Số điện thoại");
        JLabel labelPhiDichVu = new JLabel("Phí dịch vụ");
        textFieldMaKH = new JTextField();
        textFieldHoTen = new JTextField();
        textFieldSdt = new JTextField();
        textFieldPhiDichVu = new JTextField();
        inputNameConfirm = new JTextField();
        inputSdtConfirm = new JTextField();
        JLabel lableEmpty = new JLabel("");
        luu = new JButton("Lưu");
        luu.addActionListener(ac);

        KhachHang kh = khDuocChon();
        textFieldMaKH.setText(kh.getMaKH());
        textFieldMaKH.setEditable(false);
        textFieldHoTen.setText(kh.getLh().getTenKh());
        textFieldSdt.setText(kh.getLh().getSdt() + "");
        textFieldPhiDichVu.setText(kh.getTienDichVu() + "");

        updateGuess.setLayout(new GridLayout(5, 2, 20, 20));
        updateGuess.add(labelMaKH);
        updateGuess.add(textFieldMaKH);
        updateGuess.add(labelTen);
        updateGuess.add(textFieldHoTen);
        updateGuess.add(labelSdt);
        updateGuess.add(textFieldSdt);
        updateGuess.add(labelPhiDichVu);
        updateGuess.add(textFieldPhiDichVu);
        updateGuess.add(lableEmpty);
        updateGuess.add(luu);
        updateGuess.setPreferredSize(new Dimension(200, 200));
        jpanelCenter.add(updateGuess, BorderLayout.CENTER);
        this.setVisible(true);

    }

    public KhachHang khDuocChon() {
        DefaultTableModel modelTable = (DefaultTableModel) tableKhach.getModel();

        int row = tableKhach.getSelectedRow();
        String maKh = (modelTable.getValueAt(row, 0) + "").trim();
        String tenKh = (modelTable.getValueAt(row, 1) + "").trim();
        int sdt = Integer.valueOf((modelTable.getValueAt(row, 2) + "").trim());
        double phiDichVu = Double.valueOf((modelTable.getValueAt(row, 6) + "").trim());

        LichHen lh = new LichHen(tenKh, sdt);
        KhachHang kh = new KhachHang(maKh, lh, phiDichVu);

        return kh;
    }

    public void updateTableGuess() {
        String maKh = textFieldMaKH.getText();
        String tenKH = textFieldHoTen.getText();
        int sdt = Integer.valueOf(textFieldSdt.getText());
        double phiDichVu = Double.valueOf(textFieldPhiDichVu.getText());
        LichHen lh = new LichHen(tenKH, sdt);
        KhachHang kh = new KhachHang(maKh, lh, phiDichVu);
        System.out.println(kh);
        System.out.println(lh);
        this.model.update(kh);
        this.resetTable(tableKhach);
        this.insertDataKhach();
        jpanelCenter.remove(updateGuess);
        jpanelCenter.repaint();
    }

    public void deleteGuess() {
        KhachHang kh = khDuocChon();
        this.model.remove(kh);
        this.resetTable(tableKhach);
        this.insertDataKhach();
    }

    public void xoaTableKhach() {
        if (jpanelCenter != null && scrollPaneKhach != null) {
            this.remove(jpanelCenter);
            this.remove(scrollPaneKhach);
            this.repaint();
        }
    }

    public void xoaTongKet() {
        if (jpanelDayTotal != null && formTongKet != null) {
            this.remove(jpanelDayTotal);
            this.remove(formTongKet);
            this.repaint();
        }
    }

    public void formTotalCost() {
        jpanelDayTotal = new JPanel();
        JLabel labelSelect = new JLabel("Ngày");
        ngayTongKet = new JComboBox<>();
        LocalDate now = LocalDate.now();
        ngayTongKet.addItem(now);
        for (int i = 1; i < 7; i++) {
            ngayTongKet.addItem(now.plusDays(-i));
        }
        JButton btnSelect = new JButton("chọn");
        btnSelect.addActionListener(ac);
        jpanelDayTotal.setLayout(new GridLayout(1, 3));
        jpanelDayTotal.add(labelSelect);
        jpanelDayTotal.add(ngayTongKet);
        jpanelDayTotal.add(btnSelect);
        formTongKet = new JPanel();
        formTongKet.setLayout(new BorderLayout());
        tableTongKet = new JTable();
        tableTongKet.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã khách hàng", "Họ tên khách", "Số điện thoại", "Ngày đặt", "Giờ đặt", "Dịch vụ sử dụng", "Tiền dịch vụ"
                }
        ));
        tongKet = new JLabel("Doanh thu: ", JLabel.RIGHT);
        tableTongKet.setPreferredScrollableViewportSize(new Dimension(800, 250));
        scrollPanelTongKet = new JScrollPane(tableTongKet);
        formTongKet.add(scrollPanelTongKet, BorderLayout.NORTH);
        formTongKet.add(tongKet, BorderLayout.CENTER);
        this.add(jpanelDayTotal, BorderLayout.NORTH);
        this.add(formTongKet, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void insertDataKhach(LocalDate ngay) {
        DefaultTableModel modelTable = (DefaultTableModel) tableTongKet.getModel();
        for (int i = 0; i < this.model.getKh().size(); i++) {
            KhachHang kh = this.model.getKh().get(i);
            if (kh.getLh().getNgayDat().compareTo(ngay) == 0) {
                modelTable.addRow(new Object[]{
                    kh.getMaKH() + "",
                    kh.getLh().getTenKh() + "",
                    kh.getLh().getSdt() + "",
                    kh.getLh().getNgayDat() + "",
                    kh.getLh().getGioDat() + "",
                    kh.getDichVu() + "",
                    kh.getTienDichVu()
                });
            }

        }
    }

    public void tongTien() {
        this.model.doanhThu((LocalDate) this.ngayTongKet.getSelectedItem());
        this.tongKet.setText("Doanh thu ngày " + this.ngayTongKet.getSelectedItem() + ":    " + this.model.getDoanhThu());
    }

    public void totalCost() {
        System.out.println("doanh thu");
        this.xoaTableLich();
        this.xoaTableKhach();
        formTotalCost();
        insertDataKhach((LocalDate) this.ngayTongKet.getSelectedItem());
        tongTien();
    }

    public void updateDoanhThu() {
        resetTable(tableTongKet);
        insertDataKhach((LocalDate) this.ngayTongKet.getSelectedItem());
        tongTien();
    }

    public void movedPageCustomer() {
        this.xoaTableLich();
        this.xoaTableKhach();
        this.xoaTongKet();
        this.remove(optionCustomer);
        itemCustomer.setBackground(Color.GRAY);
        itemCustomer.setForeground(Color.WHITE);
        itemManager.setOpaque(true);
        itemManager.setBackground(UIManager.getColor("Menu.background"));
        itemManager.setForeground(UIManager.getColor("Menu.foreground"));
        this.init();
        this.setVisible(true);
    }

}
