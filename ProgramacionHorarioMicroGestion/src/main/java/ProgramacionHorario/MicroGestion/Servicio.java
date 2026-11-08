package ProgramacionHorario.MicroGestion;

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
                "http://MICROPROGRAMACION/medico/listar",
                Medico[].class
        );

        return Arrays.asList(m);
    }

    public List<Medico> buscarPorEspecialidad(String especialidad) {
        Medico[] m = rt.getForObject(
                "http://MICROPROGRAMACION/medico/especialidad/" + especialidad,
                Medico[].class
        );

        return Arrays.asList(m);
    }

    public List<FranjaHoraria> listarFranjas() {
        FranjaHoraria[] f = rt.getForObject(
                "http://MICROFRANJAHORARIA/franja/listar",
                FranjaHoraria[].class
        );

        return Arrays.asList(f);
    }

    public List<ProgramacionHorario> listarProgramaciones() {
        ProgramacionHorario[] p = rt.getForObject(
                "http://MICROREGITRO/programacion/listar",
                ProgramacionHorario[].class
        );
        return Arrays.asList(p);
    }

    public Usuario validar(Entrada ent) {
        return rt.postForObject(
                "http://MICROVALIDAR/validar",
                ent,
                Usuario.class
        );
    }

    public ProgramacionHorario grabarProgramacion(ProgramacionHorario p) {
        return rt.postForObject(
                "http://MICROREGITRO/programacion/grabar",
                p,
                ProgramacionHorario.class
        );
    }
}
