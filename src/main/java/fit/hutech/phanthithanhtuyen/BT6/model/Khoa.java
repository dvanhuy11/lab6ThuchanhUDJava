package fit.hutech.phanthithanhtuyen.BT6.model;

import jakarta.persistence.*;


@Entity
@Table(name = "khoa")
public class Khoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long khoa_id;

    @Column(name = "ten_khoa")
    private String ten;

    public Long getKhoa_id() {
        return khoa_id;
    }

    public void setKhoa_id(Long khoa_id) {
        this.khoa_id = khoa_id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Khoa(Long khoa_id, String ten) {
        this.khoa_id = khoa_id;
        this.ten = ten;
    }

    public Khoa() {
    }
}
