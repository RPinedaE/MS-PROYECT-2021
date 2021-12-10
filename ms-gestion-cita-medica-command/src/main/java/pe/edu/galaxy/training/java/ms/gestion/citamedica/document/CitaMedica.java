package pe.edu.galaxy.training.java.ms.gestion.citamedica.document;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "CitaMedica")
public class CitaMedica{
	
	@Field("_id")
    private String _id;/* = UUID.randomUUID().toString()*/
	
	@Field(name="idCita")
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
	
	@Field(name = "fechaCita")
	private String fechaCita;
	
	@Field(name = "horaCita")
	private String horaCita;
	
	@Field(name = "motivoCita")
	private String motivoCita;
}

