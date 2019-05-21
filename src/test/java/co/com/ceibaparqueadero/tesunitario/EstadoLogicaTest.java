package co.com.ceibaparqueadero.tesunitario;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import co.com.ceibaparqueadero.dominio.dto.EstadoDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.dominio.logica.EstadoLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.builder.EstadoBuilder;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.EstadoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.EstadoRepositorio;

public class EstadoLogicaTest {

	private static final String MENSAJE_ERROR = "Error: Al Registrar  !";

	@Mock
	private EstadoRepositorio estadoRepositorio;

	@InjectMocks
	EstadoLogica estadoLogica;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test encargado de listar los estados de vehiculo
	 */
	@Test
	public void listarEstados() {

		// Arrange
		List<String> esperado = Arrays.asList();

		// Act
		List<EstadoEntidad> estadoEntidad = estadoLogica.listarEstado();

		// Assert
		assertEquals(esperado, estadoEntidad);
	}

	/**
	 * Test  encargado de enviar excepcion al no guardar informacion
	 * 
	 * @throws ParqueaderoExcepcion
	 */
	@Test
	public void guardarEstadoParqueoNull() throws ParqueaderoExcepcion {

		// Arrange
		EstadoDto detalleEstado = new EstadoDto();

		try {
			// Act
			estadoLogica.guardarEstado(detalleEstado);

		} catch (ParqueaderoExcepcion e) {
			// Assert
			assertEquals(MENSAJE_ERROR, e.getMessage());

		}
	}
	
	/**
	 * Test encargado crear estado automotor entidad con dominio
	 */

	@Test
	public void crearEstadoAutomotorEntidadConDominioNull() {
		// Arrange

		// Act
		EstadoEntidad estadoEntidad = EstadoBuilder.convertirAEntidad(null);

		// Assert
		assertEquals(null, estadoEntidad);
	}

	/**
	 * Test encargado crear estado automotor con entidad null
	 */
	@Test
	public void crearEstadoConEntidadNull() {
		// Arrange

		// Act
		EstadoDto estadoDto = EstadoBuilder.convertirADominio(null);

		// Assert
		assertEquals(null, estadoDto);
	}
}
