package fit.hutech.phanthithanhtuyen.BT6.service;

import fit.hutech.phanthithanhtuyen.BT6.Repository.KhoaRepository;
import fit.hutech.phanthithanhtuyen.BT6.model.Khoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhoaServiceImp implements KhoaService {
    @Autowired
    private KhoaRepository khoaRepository;
    @Override
    public List<Khoa> get(){
        return khoaRepository.findAll();
    }
    @Override
    public void save(Khoa khoa){
        this.khoaRepository.save(khoa);
    }
    @Override
    public Khoa getById(Long id){
        Optional<Khoa> optional = khoaRepository.findById(id);
        Khoa khoa = null;
        if ((optional.isPresent())){
            khoa=optional.get();
        }else {
            throw  new RuntimeException("Khong co khoa nay");
        }
        return khoa;
    }
    @Override
    public void del(Long id){
        this.khoaRepository.deleteById(id);
    }
}
