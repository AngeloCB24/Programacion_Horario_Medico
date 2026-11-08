package ProgramacionHorarioMicroFranjaHoraria.MicroFranjaHoraria;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

@Service
public class Servicio {

    @Autowired
    private Dao d;

    public FranjaHoraria grabar(FranjaHoraria f) {
        return d.save(f);
    }

    public List<FranjaHoraria> listar() {
        return d.findAll();
    }

    public FranjaHoraria buscar(Long id) {
        return d.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        d.deleteById(id);
    }

    public FranjaHoraria actualizar(Long id, FranjaHoraria f) {
        return d.findById(id).map(x -> {
            x.setHoraInicio(f.getHoraInicio());
            x.setHoraFin(f.getHoraFin());
            return d.save(x);
        }).orElse(null);
    }

}
