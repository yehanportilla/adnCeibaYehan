package co.com.ceibaparqueadero.tesunitario;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceibaparqueadero.dominio.dto.ClaseAutomotorDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.dominio.logica.ClaseAutomotorLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.builder.ClaseAutomotorBuilder;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.ClaseAutomotorRepositorio;

public class ClaseAutomotorTest {

	private static final String MENSAJE_ERROR = "Error: Al Registrar  !";

	@Mock
	private ClaseAutomotorRepositorio claseAutomotorRepositorio;

	@InjectMocks
	ClaseAutomotorLogica claseAutomotorLogica;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test encargado de listar el tipo de automotor
	 */
	@Test
	public void listarClaseAutomotor() {

		// Arrange
		List<String> esperado = Arrays.asList();

		// Act
		List<ClaseAutomotorEntidad> claseAuto = claseAutomotorLogica.listarClases();

		// Assert
		assertEquals(esperado, claseAuto);
	}

	/**
	 * Test encargado de enviar excepcion al no guardar informacion
	 * 
	 * @throws ParqueaderoExcepcion
	 */
	@Test
	public void guardarClaseNull() throws ParqueaderoExcepcion {

		// Arrange
		ClaseAutomotorDto detalleClase = new ClaseAutomotorDto();

		try {
			// Act
			claseAutomotorLogica.guardarClaseAutomor(detalleClase);

		} catch (ParqueaderoExcepcion e) {
			// Assert
			assertEquals(MENSAJE_ERROR, e.getMessage());

		}
	}

	/**
	 * Test encargado crear clase automotor entidad con dominio
	 */

	@Test
	public void crearClaseAutomotorEntidadConDominioNull() {
		// Arrange

		// Act
		ClaseAutomotorEntidad claseAutomotorEntidad = ClaseAutomotorBuilder.convertirAEntidad(null);

		// Assert
		assertEquals(null, claseAutomotorEntidad);
	}

	/**
	 * Test encargado crear clase automotor con entidad null
	 */
	@Test
	public void crearClaseConEntidadNull() {
		// Arrange

		// Act
		ClaseAutomotorDto claseAutomotorDto = ClaseAutomotorBuilder.convertirADominio(null);

		// Assert
		assertEquals(null, claseAutomotorDto);
	}

}
