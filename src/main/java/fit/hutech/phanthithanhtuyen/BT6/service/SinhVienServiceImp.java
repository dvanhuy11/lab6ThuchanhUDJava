package fit.hutech.phanthithanhtuyen.BT6.service;

import fit.hutech.phanthithanhtuyen.BT6.Repository.SinhVienRepository;
import fit.hutech.phanthithanhtuyen.BT6.model.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SinhVienServiceImp implements SinhVienService {
    @Autowired
    private SinhVienRepository sinhVienRepository;
    @Override
    public List<SinhVien> getAllSV(){
        return sinhVienRepository.findAll();
    }
    @Override
    public void saveSV (SinhVien sinhVien){
        this.sinhVienRepository.save(sinhVien);
    }
    @Override
    public SinhVien getSVById(Long id){
        Optional<SinhVien> optional = sinhVienRepository.findById(id);
        SinhVien sinhVien = null;
        if ((optional.isPresent())){
            sinhVien=optional.get();
        }else {
            throw  new RuntimeException("Khong co nhan vien nay");
        }
        return sinhVien;
    }
    @Override
    public void delSV(Long id){
        this.sinhVienRepository.deleteById(id);
    }
}
