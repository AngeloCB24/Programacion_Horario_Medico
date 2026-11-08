package ProgramacionHorarioMicroRegistro.MicroRegitro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ProgramacionHorario {

    @Id
    @GeneratedValue
    private Long idProgramacion;
    private Long idMed;
    private String fec;
    private String estado;

    public ProgramacionHorario() {
    }

    public ProgramacionHorario(Long idProgramacion, String fec, String estado, Long idMed) {
        this.idProgramacion = idProgramacion;
        this.fec = fec;
        this.estado = estado;
        this.idMed = idMed;
    }

    public Long getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(Long idProgramacion) {
        this.idProgramacion = idProgramacion;
    }

    public String getFec() {
        return fec;
    }

    public void setFec(String fec) {
        this.fec = fec;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdMed() {
        return idMed;
    }

    public void setIdMed(Long idMed) {
        this.idMed = idMed;
    }
}
