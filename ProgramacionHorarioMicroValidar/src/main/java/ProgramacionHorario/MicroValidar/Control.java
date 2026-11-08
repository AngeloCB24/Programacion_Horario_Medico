
package ProgramacionHorario.MicroValidar;

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
@RequestMapping("/validar")
public class Control {
    @Autowired
    private Servicio s;
    
    @PostMapping
    public Usuario validar(@RequestBody Entrada ent){
        return s.validar(ent);
    }
    
    @PostMapping("/grabar")
    public void grabar (@RequestBody Usuario u){
        s.grabar(u);
    }
    
    @GetMapping("/buscar/{id}")
    public Usuario buscar(@PathVariable Long id){
        return s.buscar(id);
    }
    
    @GetMapping("/listar")
    public List<Usuario> listar(){
        return s.listar();
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        s.eliminar(id);
    }
    
    @PutMapping("/actualizar/{id}")
    public Usuario actualizar(@PathVariable Long id,@RequestBody Usuario u){
        return s.actualizar(id, u);
    }
    
}
