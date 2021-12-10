package pe.edu.galaxy.training.java.ms.gestion.citamedica.repository;

import java.util.List;

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
	public List<SolicitudCitaDTO> findAll() { 
		log.info("findAll en REDIS...");
		return hashOperations.values(CITAMEDICA_KEY);
	}

	@Override
	public SolicitudCitaDTO findById(String id) {
		log.info("findById en REDIS...");
		return (SolicitudCitaDTO) hashOperations.get(CITAMEDICA_KEY, id);
	}
}
