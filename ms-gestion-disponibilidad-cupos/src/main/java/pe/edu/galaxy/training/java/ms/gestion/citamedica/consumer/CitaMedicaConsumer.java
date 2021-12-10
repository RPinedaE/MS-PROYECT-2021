package pe.edu.galaxy.training.java.ms.gestion.citamedica.consumer;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;

public interface CitaMedicaConsumer {
  public void consumeMessage(SolicitudCitaDTO solicitudCitaDTO);
}
