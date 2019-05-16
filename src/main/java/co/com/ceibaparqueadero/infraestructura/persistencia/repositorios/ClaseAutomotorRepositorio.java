package co.com.ceibaparqueadero.infraestructura.persistencia.repositorios;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;

@Repository
public interface ClaseAutomotorRepositorio extends JpaRepository<ClaseAutomotorEntidad, Long> {

	Optional<ClaseAutomotorEntidad> findById(Long id);

}
