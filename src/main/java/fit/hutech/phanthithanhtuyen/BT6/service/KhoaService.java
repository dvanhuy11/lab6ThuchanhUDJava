package fit.hutech.phanthithanhtuyen.BT6.service;

import fit.hutech.phanthithanhtuyen.BT6.model.Khoa;
import fit.hutech.phanthithanhtuyen.BT6.model.SinhVien;

import java.util.List;

public interface KhoaService {
    List<Khoa> get();

    void save(Khoa khoa);

    Khoa getById(Long id);

    void del(Long id);
}
