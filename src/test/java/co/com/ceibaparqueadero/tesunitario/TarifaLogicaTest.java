package co.com.ceibaparqueadero.tesunitario;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import co.com.ceibaparqueadero.dominio.logica.TarifaLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TarifaEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.TarifaRepositorio;


public class TarifaLogicaTest {
	
	
	@Mock
	private TarifaRepositorio tarifaRepositorio;
	
	@InjectMocks
	TarifaLogica tarifaLogica;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}


	/**
	 * Test Integracion encargado de listar los tiempos de parqueadero
	 */
	@Test
	public void listarTarifa() {

		// Arrange
		List<String> esperado = Arrays.asList();

		// Act
		List<TarifaEntidad> tarifaEntidad = tarifaLogica.listarTarifa();

		// Assert
		assertEquals(esperado, tarifaEntidad);
	}

}
