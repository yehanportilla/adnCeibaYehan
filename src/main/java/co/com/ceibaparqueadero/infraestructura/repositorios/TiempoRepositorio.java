package co.com.ceibaparqueadero.infraestructura.repositorios;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceibaparqueadero.infraestructura.entidades.Tiempo;

@Repository
public interface TiempoRepositorio extends JpaRepository<Tiempo, Long> {

	Optional<Tiempo> findById(Long id);

}
