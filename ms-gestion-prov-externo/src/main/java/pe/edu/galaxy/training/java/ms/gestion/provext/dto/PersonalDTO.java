package pe.edu.galaxy.training.java.ms.gestion.provext.dto;

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
@JsonPropertyOrder(value = {"id","idMedico","nombres","apellidos","tipoDoc","numDoc","numCelular","email","direccion"})
public class PersonalDTO extends GenericDTO{
	
    private Long id;    
    private Long idMedico;
    private String nombres;	
	private String apellidos;
	private String tipoDoc;
	private String numDoc;
	private String numCelular;
	private String email;
	private String direccion;
}
