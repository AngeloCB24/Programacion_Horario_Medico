package ProgramacionHorario.MicroValidar;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Dao extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByidUsuAndPas(Long idUsu, String pas);
}
