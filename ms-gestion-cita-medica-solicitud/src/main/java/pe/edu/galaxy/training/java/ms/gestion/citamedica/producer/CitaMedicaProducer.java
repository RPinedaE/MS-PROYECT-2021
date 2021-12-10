package pe.edu.galaxy.training.java.ms.gestion.citamedica.producer;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;

public interface CitaMedicaProducer {
  public void sendMessage(SolicitudCitaDTO solicitudCitaDTO);
}
