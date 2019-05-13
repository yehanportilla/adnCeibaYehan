package co.com.ceibaparqueadero.tesunitario;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.text.ParseException;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import co.com.ceibaparqueadero.dominio.logica.CalculaTiempoParqueaderoLogica;
import co.com.ceibaparqueadero.dominio.logica.RegistroParqueaderoLogica;

public class RegistroIngresoVehiculoTest {

	private static final String PLACA_NO_HABILITADA = "Lo sentimos, no puede ingresar...!";

	@Spy
	private RegistroParqueaderoLogica registroParqueaderoMockito;

	@Spy
	private CalculaTiempoParqueaderoLogica calculaTiempoParqueaderoMockito;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test encargado de validar clase automotor
	 */
	@Test
	public void validarClaseAutomotor() {

		// Arrange
		int tipoAutomotor = 3;
		RegistroParqueaderoLogica registroParqueaderoLogica = new RegistroParqueaderoLogica();

		// Act
		int codigoMensaje = registroParqueaderoLogica.validarTipoAutomotor(tipoAutomotor).getCodigo();

		// Assert
		assertEquals(0, codigoMensaje);
	}

	/**
	 * Test encargado de validar el cupo para el parqueadero
	 */
	@Test
	public void validarCupoParqueadero() {

		// Arrange
		int cantidadAutomotor = 25;
		int tipoAutomotor = 1;
		RegistroParqueaderoLogica registroParqueaderoLogica = new RegistroParqueaderoLogica();

		// Act
		int codigoMensaje = registroParqueaderoLogica.validarCupoParqueadero(tipoAutomotor, cantidadAutomotor)
				.getCodigo();

		// Assert
		assertEquals(0, codigoMensaje);
	}

	/**
	 * Test encargado de validar placa que enpieze por A, no ingresa lunes
	 * 
	 */
	@Test
	public void validarPlacaDialunes() {

		// Arrange
		String numPlaca = "ABC123";

		when(registroParqueaderoMockito.obtenerDia()).thenReturn(Calendar.MONDAY);

		// Act
		registroParqueaderoMockito.validarIngresoPlacaDia(numPlaca);

		// Assert
		assertEquals(PLACA_NO_HABILITADA, registroParqueaderoMockito.validarIngresoPlacaDia(numPlaca).getMensaje());

	}

	/**
	 * Test encargado de validar placa que enpieze por A, no ingresa domingo
	 * 
	 */
	@Test
	public void validarPlacaDiaDomingo() {

		// Arrange
		String numPlaca = "ABC456";

		when(registroParqueaderoMockito.obtenerDia()).thenReturn(Calendar.SUNDAY);

		// Act
		registroParqueaderoMockito.validarIngresoPlacaDia(numPlaca);

		// Assert
		assertEquals(PLACA_NO_HABILITADA, registroParqueaderoMockito.validarIngresoPlacaDia(numPlaca).getMensaje());

	}

	/**
	 * Test en cargdo de validar tiempo de parqueadero
	 * 
	 * @throws ParseException
	 */
	@Test
	public void calcularTiempoParqueadero() throws ParseException {

		// Arrange
		String fechaRegistro = "2019-05-10 08:00:00";
		String fechaSalida = "2019-05-12 12:53:00";

		// Act
		int codigoMensaje = calculaTiempoParqueaderoMockito.calcularTiempoParqueadero(fechaRegistro, fechaSalida)
				.getCodigo();

		// Assert
		assertEquals(0, codigoMensaje);

	}

}
