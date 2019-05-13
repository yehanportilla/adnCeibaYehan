package co.com.ceibaparqueadero.aplicacion.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceibaparqueadero.infraestructura.entidades.Estado;

@Repository
public interface EstadoRepositorio extends JpaRepository<Estado, Long> {

}
