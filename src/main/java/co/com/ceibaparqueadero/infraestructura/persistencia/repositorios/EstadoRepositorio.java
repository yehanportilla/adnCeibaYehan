package co.com.ceibaparqueadero.infraestructura.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.EstadoEntidad;

@Repository
public interface EstadoRepositorio extends JpaRepository<EstadoEntidad, Long> {

}
