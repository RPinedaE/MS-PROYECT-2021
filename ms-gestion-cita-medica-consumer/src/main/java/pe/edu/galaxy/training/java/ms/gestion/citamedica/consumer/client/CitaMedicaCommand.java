package pe.edu.galaxy.training.java.ms.gestion.citamedica.consumer.client;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.document.CitaMedica;

public interface CitaMedicaCommand {
	void enviar(CitaMedica citaMedica);
}
