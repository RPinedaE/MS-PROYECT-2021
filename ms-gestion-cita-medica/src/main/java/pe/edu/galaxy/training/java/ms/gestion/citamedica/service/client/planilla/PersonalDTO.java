package pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.planilla;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonPropertyOrder(value = {"id","nombres","apellidos"})
public class PersonalDTO{
	
    private Long id;    
    private Long idMedico;
    private String nombres;	
	private String apellidos;
    /*private Date fecIngreso;*/
}
