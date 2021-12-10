package pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.medico;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonPropertyOrder(value = {"id","nombres","apellidos"/*,"cmp"*/})
public class MedicoDTO{
	
    private Long id;    
    private String nombres;	
	private String apellidos;
	/*private String cmp;*/
}
