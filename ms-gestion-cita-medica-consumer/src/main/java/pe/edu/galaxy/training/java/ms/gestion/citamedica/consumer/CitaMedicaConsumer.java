package pe.edu.galaxy.training.java.ms.gestion.citamedica.consumer;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.document.CitaMedica;

public interface CitaMedicaConsumer {
  public void consumeMessage(CitaMedica citaMedica);
}
