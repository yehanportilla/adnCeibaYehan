package co.com.ceibaparqueadero.infraestructura.persistencia.repositorios;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ParqueaderoEntidad;

@Repository
public interface ParqueaderoRepositorio extends JpaRepository<ParqueaderoEntidad, Long> {

	@Query("select count(p) from ParqueaderoEntidad p where p.claseAutomotorEntidad.id=:claseAutomotorEntidad and p.estadoEntidad.id=:estadoEntidad")
	Integer cantidadAutomotorRegistrado(@Param("claseAutomotorEntidad") Long claseId, @Param("estadoEntidad") Long estadoId);

	@Query("select p from ParqueaderoEntidad p where p.placa=:placa and p.estadoEntidad.id=:estadoEntidad")
	ParqueaderoEntidad obtenerPlacaRegistrada(@Param("placa") String numPlaca, @Param("estadoEntidad") Long estadoId);
}
