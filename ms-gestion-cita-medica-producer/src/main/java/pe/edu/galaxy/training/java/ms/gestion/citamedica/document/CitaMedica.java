package pe.edu.galaxy.training.java.ms.gestion.citamedica.document;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CitaMedica implements Serializable{
	
	private static final long serialVersionUID = -2974164606916594416L;

	private Long idCita;

	private Long   pacienteId;	
	private String pacienteNombre;
	private String pacienteApePaterno;
	private String pacienteApeMaterno;
	private String pacienteNumDoc;
	
    private Long   medicoId;    
    private String medicoNombre;	
	private String medicoApellidos;
	
    private Long   especialidadId;    
    private String especialidadNombre;
	
	private String fechaCita;
	private String horaCita;
	private String motivoCita;
}

