package ProgramacionHorario.MicroProgramacion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Dao extends JpaRepository<Medico,Long>{
        List<Medico> findByEspecialidad(String especialidad);
}
