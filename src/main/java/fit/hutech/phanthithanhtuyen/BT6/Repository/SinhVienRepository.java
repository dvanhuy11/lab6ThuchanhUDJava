package fit.hutech.phanthithanhtuyen.BT6.Repository;

import fit.hutech.phanthithanhtuyen.BT6.model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {
}
