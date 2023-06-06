package fit.hutech.phanthithanhtuyen.BT6.Repository;

import fit.hutech.phanthithanhtuyen.BT6.model.Khoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KhoaRepository extends JpaRepository<Khoa, Long> {

}
