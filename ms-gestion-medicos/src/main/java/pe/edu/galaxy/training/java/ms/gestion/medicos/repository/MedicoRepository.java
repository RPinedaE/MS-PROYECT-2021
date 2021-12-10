package pe.edu.galaxy.training.java.ms.gestion.medicos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.galaxy.training.java.ms.gestion.medicos.entity.MedicoEntity;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity, Long>{
	
	@Query("select me from MedicoEntity me where me.estado='1'")
	List<MedicoEntity> getAllActivos();
}
