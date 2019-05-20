package co.com.ceibaparqueadero.tesunitario;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceibaparqueadero.dominio.logica.EstadoLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.EstadoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.EstadoRepositorio;

public class EstadoLogicaTest {
	
	@Mock
	private EstadoRepositorio estadoRepositorio;
	
	@InjectMocks
	EstadoLogica estadoLogica;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Test Integracion encargado de listar los estados de vehiculo
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

}