package pe.edu.galaxy.training.java.ms.gestion.pacientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.galaxy.training.java.ms.gestion.pacientes.entity.PacienteEntity;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long>{
	
	@Query("select pa from PacienteEntity pa where pa.estado='1'")
	List<PacienteEntity> getAllActivos();
}
