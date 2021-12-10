package pe.edu.galaxy.training.java.ms.gestion.citamedica.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class JedisConfiguration {
	
	@Value("${redis.server}")
	private String redisSever;
	
	@Value("${redis.port}")
	private Integer redisPort;
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		log.info("--> jedisConnectionFactory():::");
		log.info("*redisSever: "+redisSever);
		log.info("*redisPort: "+redisPort);
		
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(this.redisSever, this.redisPort);
		return new JedisConnectionFactory(redisStandaloneConfiguration);
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {

		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}
}
