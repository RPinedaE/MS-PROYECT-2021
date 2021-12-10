package pe.edu.galaxy.training.java.ms.gestion.planilla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.galaxy.training.java.ms.gestion.planilla.entity.PersonalEntity;

@Repository
public interface PersonalRepository extends JpaRepository<PersonalEntity, Long>{
	
	@Query("select pe from PersonalEntity pe where pe.estado='1'")
	List<PersonalEntity> getAllActivos();
	
	@Query("select pe from PersonalEntity pe where pe.idMedico= :idMedico")
	PersonalEntity getPersonalMedico(@Param("idMedico") Long idMedico);
}
