package ProgramacionHorario.MicroProgramacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicio {

    @Autowired
    private Dao d;

    public void grabar(Medico m) {
        d.save(m);
    }

    public Medico buscar(Long id) {
        return d.findById(id).orElse(null);
    }

    public List<Medico> listar() {
        return d.findAll();
    }

    public List<Medico> buscarPorEspecialidad(String especialidad) {
        return d.findByEspecialidad(especialidad);
    }

    public void eliminar(Long id) {
        d.deleteById(id);
    }

    public Medico actualizar(Long id, Medico m) {
        return d.findById(id).map(x -> {
            x.setNom(m.getNom());
            x.setEspecialidad(m.getEspecialidad());
            return d.save(x);
        }).orElse(null);
    }

}
