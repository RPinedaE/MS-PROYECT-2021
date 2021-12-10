package pe.edu.galaxy.training.java.ms.gestion.citamedica.service.client.cupos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonPropertyOrder(value = {"idEspecialidad","idMedico","fecha","hora","codResultado","desResultado"})
public class SolicitudCupoDTO{
	
    private Long idEspecialidad;
    private Long idMedico;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern= "dd/MM/yyyy")
    private Date   fecha;
    private String hora;
    private String codResultado;
    private String desResultado;
}