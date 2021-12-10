package pe.edu.galaxy.training.java.ms.gestion.especialidades.service;

import java.util.List;
import java.util.Optional;

import pe.edu.galaxy.training.java.ms.gestion.especialidades.service.exception.ServiceException;

public interface GenericService<T> {
	
	List<T> findLike(T t) throws ServiceException;

	Optional<T> findById(T t) throws ServiceException;
	
	T save(T t) throws ServiceException;
}
