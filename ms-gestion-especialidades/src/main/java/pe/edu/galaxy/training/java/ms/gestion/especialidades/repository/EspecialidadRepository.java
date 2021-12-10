package pe.edu.galaxy.training.java.ms.gestion.especialidades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.galaxy.training.java.ms.gestion.especialidades.entity.EspecialidadEntity;

@Repository
public interface EspecialidadRepository extends JpaRepository<EspecialidadEntity, Long>{
	
	@Query("select es from EspecialidadEntity es where es.estado='1'")
	List<EspecialidadEntity> getAllActivos();
}
