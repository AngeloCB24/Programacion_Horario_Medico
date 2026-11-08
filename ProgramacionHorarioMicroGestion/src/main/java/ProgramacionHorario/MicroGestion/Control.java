package ProgramacionHorario.MicroGestion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestion")
public class Control {

    @Autowired
    private Servicio s;

    @GetMapping("/medicos")
    public List<Medico> listarMedicos() {
        return s.listarMedicos();
    }

    @GetMapping("/especialidad/{especialidad}")
    public List<Medico> buscarPorEspecialidad(@PathVariable String especialidad) {
        return s.buscarPorEspecialidad(especialidad);
    }

    @GetMapping("/franjas")
    public List<FranjaHoraria> listarFranjas() {
        return s.listarFranjas();
    }

    @GetMapping("/programaciones")
    public List<ProgramacionHorario> listarProgramaciones() {
        return s.listarProgramaciones();
    }

    @PostMapping("/validar")
    public Usuario validar(@RequestBody Entrada ent) {
        return s.validar(ent);
    }

    @PostMapping("/programacion/grabar")
    public ProgramacionHorario grabarProgramacion(@RequestBody ProgramacionHorario p) {
        return s.grabarProgramacion(p);
    }
}
