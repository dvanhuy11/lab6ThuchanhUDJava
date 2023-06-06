package fit.hutech.phanthithanhtuyen.BT6.service;

import fit.hutech.phanthithanhtuyen.BT6.model.SinhVien;

import java.util.List;

public interface SinhVienService {
    List<SinhVien> getAllSV();
    void  saveSV(SinhVien sinhVien);

    SinhVien getSVById(Long id);

    void delSV(Long id);
}
