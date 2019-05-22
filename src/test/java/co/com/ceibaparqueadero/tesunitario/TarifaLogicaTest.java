package co.com.ceibaparqueadero.tesunitario;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceibaparqueadero.dominio.dto.TarifaDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.dominio.logica.TarifaLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.builder.TarifaBuilder;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TarifaEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TiempoEntidad;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional 
public class TarifaLogicaTest {

	private static final String MENSAJE_ERROR = "Error: Al Registrar  !";

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
	 * Test encargado de validar el set y get de la tabla tarifa
	 */
	@Test
	public void validarEntidadTarifa() {

		// Arrange
		Long id = 5l;
		Double valor = 5000d;
		ClaseAutomotorEntidad claseAutomotorEntidad = new ClaseAutomotorEntidad();
		TiempoEntidad tiempoEntidad = new TiempoEntidad();

		// Act
		TarifaEntidad tarifaEntidad = new TarifaEntidad();
		tarifaEntidad.setId(id);
		tarifaEntidad.setValor(valor);
		tarifaEntidad.setClaseAutomotorEntidad(claseAutomotorEntidad);
		tarifaEntidad.setTiempoEntidad(tiempoEntidad);

		// Assert
		assertEquals(id, tarifaEntidad.getId());
		assertEquals(valor, tarifaEntidad.getValor());
		assertEquals(claseAutomotorEntidad, tarifaEntidad.getClaseAutomotorEntidad());
		assertEquals(tiempoEntidad, tarifaEntidad.getTiempoEntidad());

	}

}
