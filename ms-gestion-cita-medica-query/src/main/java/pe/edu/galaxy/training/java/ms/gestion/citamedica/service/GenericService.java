package pe.edu.galaxy.training.java.ms.gestion.citamedica.service;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.exception.ServiceException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GenericService<T> {
	
	Flux<T> findLike(T t) throws ServiceException;

	Mono<T> findById(T t) throws ServiceException;
}
