package ProgramacionHorarioMicroFranjaHoraria.MicroFranjaHoraria;

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
@RequestMapping("/franja")
public class Control {

    @Autowired
    private Servicio s;

    @PostMapping("/grabar")
    public void grabar(@RequestBody FranjaHoraria f) {
        s.grabar(f);
    }

    @GetMapping("/buscar/{id}")
    public FranjaHoraria buscar(@PathVariable Long id) {
        return s.buscar(id);
    }

    @GetMapping("/listar")
    public List<FranjaHoraria> listar() {
        return s.listar();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        s.eliminar(id);
    }

    @PutMapping("/actualizar/{id}")
    public FranjaHoraria actualizar(@PathVariable Long id, @RequestBody FranjaHoraria f) {
        return s.actualizar(id, f);
    }
}
