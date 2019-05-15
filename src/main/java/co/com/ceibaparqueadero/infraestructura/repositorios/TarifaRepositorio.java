package co.com.ceibaparqueadero.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceibaparqueadero.infraestructura.entidades.Tarifa;

@Repository
public interface TarifaRepositorio extends JpaRepository<Tarifa, Long> {

}
