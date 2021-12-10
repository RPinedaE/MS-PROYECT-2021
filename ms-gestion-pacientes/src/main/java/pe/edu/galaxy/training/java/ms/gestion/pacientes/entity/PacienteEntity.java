package pe.edu.galaxy.training.java.ms.gestion.pacientes.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@Table (name= "PACIENTE")
@Entity(name= "PacienteEntity")
public class PacienteEntity extends GenericEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPaciente")
    @SequenceGenerator(sequenceName = "SEQ_PACIENTE", allocationSize = 1, name = "seqPaciente")
	@Column(name = "ID_PACIENTE")
	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APE_PATERNO")
	private String apePaterno;
	
	@Column(name = "APE_MATERNO")
	private String apeMaterno;
	
	@Column(name = "TIPO_DOC")
	private String tipoDoc;
	
	@Column(name = "NUM_DOC")
	private String numDoc;
	
	@Column(name = "FEC_NACIMIENTO")
	private Date fecNac;
	
	@Column(name = "NUM_CELULAR")
	private String numCelular;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "DIRECCION")
	private String direccion;
}
