package pe.edu.galaxy.training.java.ms.gestion.citamedica.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.document.CitaMedica;

@Repository
public interface CitaMedicaRepository extends ReactiveMongoRepository<CitaMedica, Long>{

}
