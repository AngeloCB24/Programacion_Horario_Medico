package ProgramacionHorario.VistaGestion;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@Service
public class Servicio {

    @Autowired
    private RestTemplate rt;

    public List<Medico> listarMedicos() {
        Medico[] m = rt.getForObject(
                "http://MICROGESTION/gestion/medicos",
                Medico[].class
        );
        return Arrays.asList(m);
    }

    public List<FranjaHoraria> listarFranjas() {
        FranjaHoraria[] f = rt.getForObject(
                "http://MICROGESTION/gestion/franjas",
                FranjaHoraria[].class
        );
        return Arrays.asList(f);
    }

    public List<ProgramacionHorario> listarProgramaciones() {
        ProgramacionHorario[] p = rt.getForObject(
                "http://MICROGESTION/gestion/programaciones",
                ProgramacionHorario[].class
        );
        return Arrays.asList(p);
    }

    public Usuario validar(Entrada ent) {
        return rt.postForObject(
                "http://MICROGESTION/gestion/validar",
                ent,
                Usuario.class
        );
    }

    public ProgramacionHorario grabarProgramacion(ProgramacionHorario p) {
        return rt.postForObject(
                "http://MICROGESTION/gestion/programacion/grabar",
                p,
                ProgramacionHorario.class
        );
    }
}
