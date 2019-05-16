package co.com.ceibaparqueadero.infraestructura.persistencia.repositorios;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TiempoEntidad;

@Repository
public interface TiempoRepositorio extends JpaRepository<TiempoEntidad, Long> {

	Optional<TiempoEntidad> findById(Long id);

}
