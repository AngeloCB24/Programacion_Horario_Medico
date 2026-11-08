package ProgramacionHorario.MicroProgramacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
public class Control {

    @Autowired
    private Servicio s;

    @PostMapping("/grabar")
    public void grabar(@RequestBody Medico m) {
        s.grabar(m);
    }

    @GetMapping("/buscar/{id}")
    public Medico buscar(@PathVariable Long id) {
        return s.buscar(id);
    }

    @GetMapping("/especialidad/{especialidad}")
    public List<Medico> buscarPorEspecialidad(@PathVariable String especialidad) {
        return s.buscarPorEspecialidad(especialidad);
    }

    @GetMapping("/listar")
    public List<Medico> listar() {
        return s.listar();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        s.eliminar(id);
    }

    @PutMapping("/actualizar/{id}")
    public Medico actualizar(@PathVariable Long id, @RequestBody Medico m) {
        return s.actualizar(id, m);
    }
}
