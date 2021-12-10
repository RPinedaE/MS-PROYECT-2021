package pe.edu.galaxy.training.java.ms.gestion.citamedica.producer;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.document.CitaMedica;

public interface CitaMedicaProducer {
  public void sendMessage(CitaMedica citaMedica);
}
