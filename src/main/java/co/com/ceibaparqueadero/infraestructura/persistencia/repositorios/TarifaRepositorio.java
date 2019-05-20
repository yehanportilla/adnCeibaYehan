package co.com.ceibaparqueadero.infraestructura.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TarifaEntidad;

@Repository
public interface TarifaRepositorio extends JpaRepository<TarifaEntidad, Long> {
	
	@Query("select t.valor from TarifaEntidad t where t.claseAutomotorEntidad.id=:claseAutomotorEntidad and t.tiempoEntidad.id=:tiempoEntidad")
	Double tarifaPorClase(@Param("claseAutomotorEntidad") Long claseId,@Param("tiempoEntidad") Long tiempoId);

}
