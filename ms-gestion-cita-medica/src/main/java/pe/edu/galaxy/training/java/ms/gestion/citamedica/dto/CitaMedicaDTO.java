package pe.edu.galaxy.training.java.ms.gestion.citamedica.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.especialidad.EspecialidadDTO;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.medico.MedicoDTO;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.paciente.PacienteDTO;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
@JsonPropertyOrder(value = {"id","idPaciente","idEspecialidad","idMedico","fecha","hora","motivo","situacion"})
public class CitaMedicaDTO extends GenericDTO{
	
    private Long id;
    private Long idPaciente;
    private Long idEspecialidad;
    private Long idMedico;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern= "dd/MM/yyyy")
    private Date fecha;
    private String hora;
    private String motivo;
    private String situacion;
    
    private PacienteDTO pacienteDTO;
    private EspecialidadDTO especialidadDTO;   
    private MedicoDTO medicoDTO;
}