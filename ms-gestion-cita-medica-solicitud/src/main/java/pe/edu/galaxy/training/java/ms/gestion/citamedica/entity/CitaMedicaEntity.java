package pe.edu.galaxy.training.java.ms.gestion.citamedica.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table (name= "CITA_MEDICA")
@Entity(name= "CitaMedicaEntity")
public class CitaMedicaEntity{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CITA")
	private Long id;
	
	@Column(name = "ID_PACIENTE")
	private Long idPaciente;
	
	@Column(name = "ID_ESPECIALIDAD")
	private Long idEspecialidad;
	
	@Column(name = "ID_MEDICO")
	private Long idMedico;
		
	@Column(name = "FECHA")
	private Date fecha;
	
	@Column(name = "HORA")
	private String hora;
	
	@Column(name = "MOTIVO")
	private String motivo;
	
	@Column(name = "SITUACION")
	private String situacion;	
}

