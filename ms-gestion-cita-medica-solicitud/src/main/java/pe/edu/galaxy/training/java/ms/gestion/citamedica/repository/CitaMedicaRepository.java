package pe.edu.galaxy.training.java.ms.gestion.citamedica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.entity.CitaMedicaEntity;

@Repository
public interface CitaMedicaRepository extends JpaRepository<CitaMedicaEntity, Long> {

	@Transactional
	@Modifying
	@Query(value="UPDATE CITA_MEDICA cm SET cm.SITUACION =:estSolicitud, cm.HORA =:hraCita WHERE cm.ID_CITA =:idCita", nativeQuery = true)
	void actualizaEstadoSolicitud(@Param("idCita") Long idCita, @Param("estSolicitud") String estSolicitud, @Param("hraCita") String hraCita);
}
