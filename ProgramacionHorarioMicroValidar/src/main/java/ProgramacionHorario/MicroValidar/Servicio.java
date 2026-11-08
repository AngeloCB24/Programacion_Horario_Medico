
package ProgramacionHorario.MicroValidar;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicio {
    @Autowired
    private Dao d;
    
    public Usuario validar(Entrada ent){
        if(ent == null || ent.getIdPersonal() == null || ent.getPas()==null){
            return null;
        }
        Optional<Usuario> userOpt = d.findByidUsuAndPas(ent.getIdPersonal(), ent.getPas());
        return userOpt.orElse(null);
    };
    
    public void grabar (Usuario u){
        d.save(u);
    }
    
    public Usuario buscar(Long id){
        return d.findById(id).orElse(null);
    }
    
    public List<Usuario> listar(){
        return d.findAll();
    }
    
    public void eliminar(Long id){
        d.deleteById(id);
    }
    
    public Usuario actualizar(Long id, Usuario u){
        return d.findById(id).map(x->{
            x.setNom(u.getNom());
            x.setPas(u.getPas());
            return d.save(x);
        }).orElse(null);
    }
    
}
