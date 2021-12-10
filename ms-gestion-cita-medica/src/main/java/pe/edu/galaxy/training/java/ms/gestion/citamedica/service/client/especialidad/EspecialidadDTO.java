package pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.especialidad;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonPropertyOrder(value = {"id","nombre"})
public class EspecialidadDTO{
	
    private Long id;    
    private String nombre;
}
