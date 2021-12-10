package pe.edu.galaxy.training.java.ms.gestion.citamedica.repository;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.citamedica.dto.SolicitudCitaDTO;

@Slf4j
@Repository
@SuppressWarnings({"rawtypes","unchecked"})
public class CitaMedicaRepositoryRedisImpl implements CitaMedicaRepositoryRedis{

	private RedisTemplate  redisTemplate;  // Connection
	private HashOperations hashOperations; // PreparedStatemnt
	
	public static final String CITAMEDICA_KEY = "CITAMEDICA";
	

	public CitaMedicaRepositoryRedisImpl(RedisTemplate redisTemplate) {
		
		this.redisTemplate = redisTemplate;
		this.hashOperations = this.redisTemplate.opsForHash(); //K,V
	}

	@Override
	public void save(SolicitudCitaDTO solicitudCitaDTO) {
		log.info("-> Save in REDIS: "+ solicitudCitaDTO);
		hashOperations.put(CITAMEDICA_KEY, solicitudCitaDTO.getCitaId(), solicitudCitaDTO);
	}
}
