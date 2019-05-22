package co.com.ceibaparqueadero.tesunitario;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import co.com.ceibaparqueadero.dominio.dto.TarifaDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.dominio.logica.TarifaLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.builder.TarifaBuilder;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TarifaEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.TarifaRepositorio;

public class TarifaLogicaTest {

	private static final String MENSAJE_ERROR = "Error: Al Registrar  !";

	@Mock
	private TarifaRepositorio tarifaRepositorio;

	
	@Mock
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

	/**
	 * Test encargado de enviar excepcion al no guardar informacion
	 * 
	 * @throws ParqueaderoExcepcion
	 */
	@Test
	public void guardarTiempoParqueoNull() throws ParqueaderoExcepcion {

		// Arrange
		TarifaDto detalleTarifa = new TarifaDto();

		try {
			// Act
			tarifaLogica.guardarTarifa(detalleTarifa);

		} catch (ParqueaderoExcepcion e) {
			// Assert
			assertEquals(MENSAJE_ERROR, e.getMessage());

		}
	}
	
	/**
	 * Test encargado crear la tarifa entidad con dominio
	 */

	@Test
	public void crearTarifaEntidadConDominioNull() {
		// Arrange

		// Act
		TarifaEntidad tarifaEntidad = TarifaBuilder.convertirAEntidad(null);

		// Assert
		assertEquals(null, tarifaEntidad);
	}

	/**
	 * Test encargado crear la tarifa  con entidad null
	 */
	@Test
	public void crearTarifaConEntidadNull() {
		// Arrange

		// Act
		TarifaDto tarifaDto = TarifaBuilder.convertirADominio(null);

		// Assert
		assertEquals(null, tarifaDto);
	}
	
	
	

}
