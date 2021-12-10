package pe.edu.galaxy.training.java.ms.gestion.programacioncupos.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.service.client.especialidad.EspecialidadDTO;
import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.service.client.medico.MedicoDTO;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
@JsonPropertyOrder(value = {"id","idEspecialidad","idEspecialidad","idMedico","fecha","cupProg","cupDisp"})
public class ProgramacionCupoDTO extends GenericDTO{
	
    private Long id;
    private Long idEspecialidad;
    private Long idMedico;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern= "dd/MM/yyyy")
    private Date fecha;
    private Long cupProg;
    private Long cupDisp;
    
    private EspecialidadDTO especialidadDTO;
    private MedicoDTO medicoDTO;
}