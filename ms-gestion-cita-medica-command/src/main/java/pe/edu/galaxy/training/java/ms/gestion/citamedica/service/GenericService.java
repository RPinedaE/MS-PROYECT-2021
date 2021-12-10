package pe.edu.galaxy.training.java.ms.gestion.citamedica.service;

import pe.edu.galaxy.training.java.ms.gestion.citamedica.service.exception.ServiceException;
import reactor.core.publisher.Mono;

public interface GenericService<T> {

	Mono<T> save(T t) throws ServiceException;
}
