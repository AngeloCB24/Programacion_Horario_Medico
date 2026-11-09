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

    @GetMapping("/medico/buscar/{id}")
    public Medico buscarMedico(@PathVariable Long id) {
        return s.buscarMedico(id);
    }

    @PostMapping("/medico/grabar")
    public void grabarMedico(@RequestBody Medico m) {
        s.grabarMedico(m);
    }

    @DeleteMapping("/medico/eliminar/{id}")
    public void eliminarMedico(@PathVariable Long id) {
        s.eliminarMedico(id);
    }

    @PutMapping("/medico/actualizar/{id}")
    public Medico actualizarMedico(@PathVariable Long id, @RequestBody Medico m) {
        return s.actualizarMedico(id, m);
    }

    @GetMapping("/especialidad/{especialidad}")
    public List<Medico> buscarPorEspecialidad(@PathVariable String especialidad) {
        return s.buscarPorEspecialidad(especialidad);
    }

    @GetMapping("/franjas")
    public List<FranjaHoraria> listarFranjas() {
        return s.listarFranjas();
    }

    @PostMapping("/franja/grabar")
    public FranjaHoraria grabarFranja(@RequestBody FranjaHoraria f) {
        return s.grabarFranja(f);
    }

    @GetMapping("/franja/buscar/{id}")
    public FranjaHoraria buscarFranja(@PathVariable Long id) {
        return s.buscarFranja(id);
    }

    @DeleteMapping("/franja/eliminar/{id}")
    public void eliminarFranja(@PathVariable Long id) {
        s.eliminarFranja(id);
    }

    @PutMapping("/franja/actualizar/{id}")
    public FranjaHoraria actualizarFranja(
            @PathVariable Long id,
            @RequestBody FranjaHoraria f) {
        return s.actualizarFranja(id, f);
    }

    @GetMapping("/programaciones")
    public List<ProgramacionHorario> listarProgramaciones() {
        return s.listarProgramaciones();
    }

    @PostMapping("/validar")
    public Usuario validar(@RequestBody Entrada ent) {
        return s.validar(ent);
    }

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return s.listarUsuarios();
    }

    @GetMapping("/usuario/buscar/{id}")
    public Usuario buscarUsuario(@PathVariable Long id) {
        return s.buscarUsuario(id);
    }

    @PostMapping("/usuario/grabar")
    public void grabarUsuario(@RequestBody Usuario u) {
        s.grabarUsuario(u);
    }

    @DeleteMapping("/usuario/eliminar/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        s.eliminarUsuario(id);
    }

    @PutMapping("/usuario/actualizar/{id}")
    public Usuario actualizarUsuario(
            @PathVariable Long id,
            @RequestBody Usuario u) {
        return s.actualizarUsuario(id, u);
    }

    @PostMapping("/programacion/grabar")
    public ProgramacionHorario grabarProgramacion(@RequestBody ProgramacionHorario p) {
        return s.grabarProgramacion(p);
    }

    @GetMapping("/programacion/buscar/{id}")
    public ProgramacionHorario buscarProgramacion(@PathVariable Long id) {
        return s.buscarProgramacion(id);
    }

    @DeleteMapping("/programacion/eliminar/{id}")
    public void eliminarProgramacion(@PathVariable Long id) {
        s.eliminarProgramacion(id);
    }

    @PutMapping("/programacion/actualizar/{id}")
    public ProgramacionHorario actualizarProgramacion(
            @PathVariable Long id,
            @RequestBody ProgramacionHorario p) {
        return s.actualizarProgramacion(id, p);
    }

}
