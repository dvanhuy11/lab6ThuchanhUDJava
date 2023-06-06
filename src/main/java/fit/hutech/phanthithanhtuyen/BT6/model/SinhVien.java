package fit.hutech.phanthithanhtuyen.BT6.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "sinh_vien")
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MSSV")
    private Long id;
    @Column(name = "ho_ten")
    private String ten;

    @Column(name = "ngay_sinh")
    private LocalDate ngaySing;

    @Column(name = "gioi_tinh")
    private String gioiTinh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public LocalDate getNgaySing() {
        return ngaySing;
    }

    public void setNgaySing(LocalDate ngaySing) {
        this.ngaySing = ngaySing;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    public SinhVien(Long id, String ten, LocalDate ngaySing, String gioiTinh, Khoa khoa) {
        this.id = id;
        this.ten = ten;
        this.ngaySing = ngaySing;
        this.gioiTinh = gioiTinh;
        this.khoa = khoa;
    }

    public SinhVien() {
    }

    @ManyToOne
    @JoinColumn(name = "khoa_id")
    private Khoa khoa;

}
