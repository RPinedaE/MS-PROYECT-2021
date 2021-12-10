package pe.edu.galaxy.training.java.ms.gestion.especialidades.entity;

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
@Table (name= "ESPECIALIDAD")
@Entity(name= "EspecialidadEntity")
public class EspecialidadEntity extends GenericEntity{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ESPECIALIDAD")
	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
}
