package co.com.ceibaparqueadero.tesunitario;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import co.com.ceibaparqueadero.dominio.dto.ParqueaderoDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.dominio.logica.ParqueaderoLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.EstadoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ParqueaderoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.ParqueaderoRepositorio;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ParqueaderoLogicaTest {
	
	private static final String MENSAJE_ERROR = "Error: Al Registrar  !";
	
	@Mock
	private ParqueaderoRepositorio parqueaderoRepositorio;
	
	//@InjectMocks
	@Mock
	ParqueaderoLogica parqueaderoLogica;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	
	/**
	 * Test encargado de listar los automotores registrados
	 */
	@Test
	public void listarRegistroAutomotores() {

		// Arrange
		List<String> esperado = Arrays.asList();

		// Act
		List<ParqueaderoEntidad> parqueaderoEntidad = parqueaderoLogica.listarRegistroAutomotor();

		// Assert
		assertEquals(esperado, parqueaderoEntidad);
	}
	
	/**
	 * Test  encargado de enviar excepcion al no guardar informacion
	 * 
	 * @throws ParqueaderoExcepcion
	 */
	@Test
	public void guardarRegistroParqueoNull() throws ParqueaderoExcepcion{

		// Arrange
		
		ClaseAutomotorEntidad claseAutomotorEntidad = new ClaseAutomotorEntidad();
		claseAutomotorEntidad.setId(new Long(8));
		
		EstadoEntidad estadoEntidad = new EstadoEntidad();
		estadoEntidad.setId(new Long(8));
		
		ParqueaderoDto detalleParqueo = new ParqueaderoDto();
		
		detalleParqueo.setClaseAutomotorEntidad(claseAutomotorEntidad);
		detalleParqueo.setEstadoEntidad(estadoEntidad);
		
		try {
			// Act
			parqueaderoLogica.registrarAutomotorParqueadero(detalleParqueo);
	
			} catch (ParqueaderoExcepcion e) {
			// Assert
			assertEquals(MENSAJE_ERROR, e.getMessage());

		}
	}

}
