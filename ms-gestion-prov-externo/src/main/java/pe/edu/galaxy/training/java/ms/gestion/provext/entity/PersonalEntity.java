package pe.edu.galaxy.training.java.ms.gestion.provext.entity;

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
@Table (name= "PERSONAL")
@Entity(name= "PersonalEntity")
public class PersonalEntity extends GenericEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPersonal")
    @SequenceGenerator(sequenceName = "SEQ_PERSONAL", allocationSize = 1, name = "seqPersonal")
	@Column(name = "ID_PERSONAL")
	private Long id;
	
	@Column(name = "ID_MEDICO")
	private Long idMedico;
	
	@Column(name = "NOMBRES")
	private String nombres;
	
	@Column(name = "APELLIDOS")
	private String apellidos;
	
	@Column(name = "TIPO_DOC")
	private String tipoDoc;
	
	@Column(name = "NUM_DOC")
	private String numDoc;
	
	@Column(name = "NUM_CELULAR")
	private String numCelular;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "DIRECCION")
	private String direccion;
}
