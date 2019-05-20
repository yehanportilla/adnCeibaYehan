package co.com.ceibaparqueadero.tesunitario;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceibaparqueadero.dominio.logica.ClaseAutomotorLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.ClaseAutomotorRepositorio;

public class ClaseAutomotorTest {

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
	/*@Test
	public void listarClaseAutomotor() {

		// Arrange
		List<String> esperado = Arrays.asList();

		// Act
		List<ClaseAutomotorEntidad> claseAuto = claseAutomotorLogica.listarClases();

		// Assert
		assertEquals(esperado, claseAuto);
	}*/
}
