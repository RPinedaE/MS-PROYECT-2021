package pe.edu.galaxy.training.java.ms.gestion.pacientes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenericDTO {
	
	@Builder.Default
	private String estado="1";

}
