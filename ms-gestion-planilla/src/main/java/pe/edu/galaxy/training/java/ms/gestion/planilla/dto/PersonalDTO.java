package pe.edu.galaxy.training.java.ms.gestion.planilla.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
@JsonPropertyOrder(value = {"id","idMedico","nombres","apellidos","fecIngreso"})
public class PersonalDTO extends GenericDTO{
	
    private Long id;    
    private Long idMedico;
    private String nombres;	
	private String apellidos;
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern= "dd/MM/yyyy")
    private Date fecIngreso;
}
