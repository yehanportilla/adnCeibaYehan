package co.com.ceibaparqueadero.aplicacion.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceibaparqueadero.infraestructura.entidades.Tiempo;

@Repository
public interface TiempoRepositorio extends JpaRepository<Tiempo, Long> {

}
