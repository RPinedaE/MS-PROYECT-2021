package pe.edu.galaxy.training.java.ms.gestion.citamedica.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SolicitudCitaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer citaId;
	private Integer pacienteId;
	private Integer especialidadId;
	private Integer medicoId;
	private String  fechaCita;
	private String  horaCita;
	private EstadoCitaEnum estado;
}

