package pe.edu.galaxy.training.java.ms.gestion.citamedica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.entity.CitaMedicaEntity;

@Repository
public interface CitaMedicaRepository extends JpaRepository<CitaMedicaEntity, Long>{
	
	@Query("select cm from CitaMedicaEntity cm where cm.estado='1'")
	List<CitaMedicaEntity> getAllActivos();
}
