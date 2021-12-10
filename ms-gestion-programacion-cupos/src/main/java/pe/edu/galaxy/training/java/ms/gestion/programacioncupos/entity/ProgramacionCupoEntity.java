package pe.edu.galaxy.training.java.ms.gestion.programacioncupos.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table (name= "PROGRAMACION")
@Entity(name= "ProgramacionCupoEntity")
public class ProgramacionCupoEntity extends GenericEntity{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PROGRAMACION")
	private Long id;
	
	@Column(name = "ID_ESPECIALIDAD")
	private Long idEspecialidad;
	
	@Column(name = "ID_MEDICO")
	private Long idMedico;
	
	@Column(name = "FECHA")
	private Date fecha;
	
	@Column(name = "CUPOS_PROG")
	private Long cupProg;
	
	@Column(name = "CUPOS_DISP")
	private Long cupDisp;
}

