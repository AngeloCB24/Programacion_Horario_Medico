
package ProgramacionHorarioMicroRegistro.MicroRegitro;

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
@RequestMapping("/programacion")
public class Control {
    @Autowired
    private Servicio s;
    
    @PostMapping("/grabar")
    public void grabar(@RequestBody ProgramacionHorario p){
        s.grabar(p);
    }
    
    @GetMapping("/buscar/{id}")
    public ProgramacionHorario buscar(@PathVariable Long id){
        return s.buscar(id);
    }
    
    @GetMapping("/listar")
    public List<ProgramacionHorario> listar(){
        return s.listar();
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        s.eliminar(id);
    }
    
    @PutMapping("/actualizar/{id}")
    public ProgramacionHorario actualizar(@PathVariable Long id,@RequestBody ProgramacionHorario p){
        return s.actualizar(id, p);
    }
}
