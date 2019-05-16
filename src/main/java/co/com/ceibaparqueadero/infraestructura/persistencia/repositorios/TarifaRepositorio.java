package co.com.ceibaparqueadero.infraestructura.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TarifaEntidad;

@Repository
public interface TarifaRepositorio extends JpaRepository<TarifaEntidad, Long> {

}
