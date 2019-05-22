package co.com.ceibaparqueadero.tesunitario;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceibaparqueadero.dominio.dto.TiempoDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.dominio.logica.TiempoLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.builder.TiempoBuilder;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TiempoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.TiempoRepositorio;

public class TiempoLogicaTest {
	
	private static final String MENSAJE_ERROR = "Error: Al Registrar  !";
	
	
	@Mock
	private TiempoRepositorio tiempoRepositorio;
	
	@InjectMocks
	TiempoLogica tiempoLogica;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	

	/**
	 * Test Integracion encargado de listar los tiempos de parqueadero
	 */
	@Test
	public void listarTiempos() {

		// Arrange
		List<String> esperado = Arrays.asList();

		// Act
		List<TiempoEntidad> tiempoEntidad = tiempoLogica.listarTiempo();

		// Assert
		assertEquals(esperado, tiempoEntidad);
	}
	
	
	/**
	 * Test  encargado de enviar excepcion al no guardar informacion
	 * 
	 * @throws ParqueaderoExcepcion
	 */
	@Test
	public void guardarTiempoParqueoNull() throws ParqueaderoExcepcion {

		// Arrange
		TiempoDto detalleTiempo = new TiempoDto();

		try {
			// Act
			tiempoLogica.guardarTiempo(detalleTiempo);

		} catch (ParqueaderoExcepcion e) {
			// Assert
			assertEquals(MENSAJE_ERROR, e.getMessage());

		}
	}
	
	
	/**
	 * Test encargado crear tiempo con dominio
	 */

	@Test
	public void crearTiempoEntidadConDominioNull() {
		// Arrange

		// Act
		TiempoEntidad tiempoEntidad = TiempoBuilder.convertirAEntidad(null);

		// Assert
		assertEquals(null, tiempoEntidad);
	}

	/**
	 * Test encargado crear tiempo con entidad null
	 */
	@Test
	public void crearTiempoConEntidadNull() {
		// Arrange

		// Act
		TiempoDto tiempoDto = TiempoBuilder.convertirADominio(null);

		// Assert
		assertEquals(null, tiempoDto);
	}
	
	
	
	
	
	
	

}
