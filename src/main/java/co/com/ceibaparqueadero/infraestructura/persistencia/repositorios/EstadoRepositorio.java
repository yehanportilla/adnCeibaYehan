package co.com.ceibaparqueadero.infraestructura.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.EstadoEntidad;

@Repository
public interface EstadoRepositorio extends JpaRepository<EstadoEntidad, Long> {

	@Query("select e from EstadoEntidad e where e.id=:id")
	EstadoEntidad obtenerEstado(@Param("id") long codEstado);
}
