package co.com.ceibaparqueadero.infraestructura.repositorios;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceibaparqueadero.infraestructura.entidades.ClaseAutomotor;

@Repository
public interface ClaseAutomotorRepositorio extends JpaRepository<ClaseAutomotor, Long> {

	Optional<ClaseAutomotor> findById(Long id);

}
