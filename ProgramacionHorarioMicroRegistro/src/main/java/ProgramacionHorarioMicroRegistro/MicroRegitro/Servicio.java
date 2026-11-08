
package ProgramacionHorarioMicroRegistro.MicroRegitro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicio {
    
    @Autowired
    private Dao d;
    
    public void grabar(ProgramacionHorario p){
        d.save(p);
    }
    
    public ProgramacionHorario buscar(Long id){
        return d.findById(id).orElse(null);
    }
    
    public List<ProgramacionHorario> listar(){
        return d.findAll();
    }
    
    public void eliminar(Long id){
        d.deleteById(id);
    }
    
    public ProgramacionHorario actualizar(Long id, ProgramacionHorario p){
        return d.findById(id).map(x->{
            x.setFec(p.getFec());
            x.setEstado(p.getEstado());
            return d.save(x);
        }).orElse(null);
    }
}
