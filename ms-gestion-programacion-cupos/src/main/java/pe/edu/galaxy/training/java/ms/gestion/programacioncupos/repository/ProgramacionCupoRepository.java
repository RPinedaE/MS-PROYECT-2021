package pe.edu.galaxy.training.java.ms.gestion.programacioncupos.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.galaxy.training.java.ms.gestion.programacioncupos.entity.ProgramacionCupoEntity;

@Repository
public interface ProgramacionCupoRepository extends JpaRepository<ProgramacionCupoEntity, Long>{
	
	@Query("select p from ProgramacionCupoEntity p where p.estado='1'")
	List<ProgramacionCupoEntity> getAllActivos();
	
	@Query("select p from ProgramacionCupoEntity p WHERE p.fecha =:fecha AND p.idEspecialidad =:idEspecialidad AND p.idMedico =:idMedico")
	List<ProgramacionCupoEntity> buscarProgramacionCupo(@Param("fecha") Date fecha, @Param("idEspecialidad") Long idEspecialidad, @Param("idMedico") Long idMedico);
}
