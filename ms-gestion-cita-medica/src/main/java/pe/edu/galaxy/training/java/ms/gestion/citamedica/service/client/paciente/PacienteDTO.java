package pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.paciente;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonPropertyOrder(value = {"id","nombre","apePaterno","apeMaterno","tipoDoc","numDoc","fecNac","numCelular","email","direccion"})
public class PacienteDTO{
	
    private Long id;    
    private String nombre;	
	private String apePaterno;
	private String apeMaterno;
	private String tipoDoc;
	private String numDoc;
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern= "dd/MM/yyyy")
	private Date   fecNac;
	private String numCelular;
	private String email;
	private String direccion;
}
