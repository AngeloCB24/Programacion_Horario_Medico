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

    public Medico buscarMedico(Long id) {
        return rt.getForObject(
                "http://MICROPROGRAMACION/medico/buscar/" + id,
                Medico.class
        );
    }

    public void grabarMedico(Medico m) {
        rt.postForObject(
                "http://MICROPROGRAMACION/medico/grabar",
                m,
                Void.class
        );
    }

    public void eliminarMedico(Long id) {
        rt.delete(
                "http://MICROPROGRAMACION/medico/eliminar/" + id
        );
    }

    public Medico actualizarMedico(Long id, Medico m) {
        rt.put(
                "http://MICROPROGRAMACION/medico/actualizar/" + id,
                m
        );
        return buscarMedico(id);
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

    public FranjaHoraria grabarFranja(FranjaHoraria f) {
        return rt.postForObject(
                "http://MICROFRANJAHORARIA/franja/grabar",
                f,
                FranjaHoraria.class
        );
    }

    public FranjaHoraria buscarFranja(Long id) {
        return rt.getForObject(
                "http://MICROFRANJAHORARIA/franja/buscar/" + id,
                FranjaHoraria.class
        );
    }

    public void eliminarFranja(Long id) {
        rt.delete(
                "http://MICROFRANJAHORARIA/franja/eliminar/" + id
        );
    }

    public FranjaHoraria actualizarFranja(Long id, FranjaHoraria f) {
        rt.put(
                "http://MICROFRANJAHORARIA/franja/actualizar/" + id,
                f
        );

        return buscarFranja(id);
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

    public ProgramacionHorario buscarProgramacion(Long id) {
        return rt.getForObject(
                "http://MICROREGITRO/programacion/buscar/" + id,
                ProgramacionHorario.class
        );
    }

    public void eliminarProgramacion(Long id) {
        rt.delete(
                "http://MICROREGITRO/programacion/eliminar/" + id
        );
    }

    public ProgramacionHorario actualizarProgramacion(Long id, ProgramacionHorario p) {
        rt.put(
                "http://MICROREGITRO/programacion/actualizar/" + id,
                p
        );
        return buscarProgramacion(id);
    }
}
