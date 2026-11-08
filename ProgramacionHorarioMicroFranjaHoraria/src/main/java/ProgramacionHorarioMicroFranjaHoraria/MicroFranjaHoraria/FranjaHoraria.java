package ProgramacionHorarioMicroFranjaHoraria.MicroFranjaHoraria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalTime;

@Entity
public class FranjaHoraria {

    @Id
    @GeneratedValue
    private Long idFranja;

    private Long idProgramacion;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public FranjaHoraria() {
    }

    public FranjaHoraria(Long idFranja, Long idProgramacion,
                         LocalTime horaInicio, LocalTime horaFin) {
        this.idFranja = idFranja;
        this.idProgramacion = idProgramacion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Long getIdFranja() {
        return idFranja;
    }

    public void setIdFranja(Long idFranja) {
        this.idFranja = idFranja;
    }

    public Long getIdProgramacion() {
        return idProgramacion;
    }

    public void setIdProgramacion(Long idProgramacion) {
        this.idProgramacion = idProgramacion;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
}