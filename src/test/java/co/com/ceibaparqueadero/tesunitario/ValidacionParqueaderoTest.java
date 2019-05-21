package co.com.ceibaparqueadero.tesunitario;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.dominio.logica.ValidacionParqueaderoLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.ParqueaderoRepositorio;

public class ValidacionParqueaderoTest {

	private static final String MENSAJE_AUTOMOTOR_NO_AUTORIZADO = "Lo sentimos. Automotor no autorizado para registro   !";
	private static final String MENSAJE_CUPO_MOTO = "Lo sentimos no hay cupo para moto   !";
	private static final String MENSAJE_PLACA = "Lo sentimos. No esta autorizado a ingresar  !";
	private static final String MENSAJE_CILINDRADA = "Cilindraje no permitido   !";

	@Mock
	private ParqueaderoRepositorio parqueaderoRepositorio;

	@InjectMocks
	private ValidacionParqueaderoLogica validacionParqueaderoLogicaMock;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test encargado de validar clase automotor
	 */
	@Test
	public void validarTipoAutomotor() throws ParqueaderoExcepcion {

		// Arrange
		Long tipoAutomotor = 3l;
		try {
			// Act
			validacionParqueaderoLogicaMock.validarTipoAutomotor(tipoAutomotor);

		} catch (ParqueaderoExcepcion ex) {
			// Assert
			assertEquals(MENSAJE_AUTOMOTOR_NO_AUTORIZADO, ex.getMessage());
		}

	}
	
	/**
	 * Test encargado de validar clase automotor Moto
	 */
	@Test
	public void validarTipoAutomotorMoto() throws ParqueaderoExcepcion {

		// Arrange
		Long tipoAutomotor = 2l;
		try {
			// Act
			validacionParqueaderoLogicaMock.validarTipoAutomotor(tipoAutomotor);

		} catch (ParqueaderoExcepcion ex) {
			// Assert
			assertEquals(MENSAJE_AUTOMOTOR_NO_AUTORIZADO, ex.getMessage());
		}

	}
	
	/**
	 * Test encargado de validar clase automotor Carro
	 */
	@Test
	public void validarTipoAutomotorCarro() throws ParqueaderoExcepcion {

		// Arrange
		Long tipoAutomotor = 1l;
		try {
			// Act
			validacionParqueaderoLogicaMock.validarTipoAutomotor(tipoAutomotor);

		} catch (ParqueaderoExcepcion ex) {
			// Assert
			assertEquals(MENSAJE_AUTOMOTOR_NO_AUTORIZADO, ex.getMessage());
		}

	}

	/**
	 * Test encargado de validar el cupo para el parqueadero
	 */

	@Test
	public void validarCupoParqueadero() throws ParqueaderoExcepcion {

		// Arrange
		Long tipoAutomotor = 1l;
		Long estadoAutomotor = 1l;
		try {
			// Act
			validacionParqueaderoLogicaMock.validarCupoParqueadero(tipoAutomotor, estadoAutomotor);

		} catch (ParqueaderoExcepcion ex) {
			// Assert
			assertEquals(MENSAJE_CUPO_MOTO, ex.getMessage());
		}
	}

	/**
	 * Test encargado de validar placa que enpieze por A, no ingresa lunes
	 * 
	 */
	@Test
	public void validarPlacaLunes() {

		// Arrange
		String numPlaca = "BBC123";

		when(validacionParqueaderoLogicaMock.obtenerDia()).thenReturn(Calendar.MONDAY);
		try {
			// Act
			validacionParqueaderoLogicaMock.validarIngresoPlacaDia(numPlaca);

		} catch (Exception e) {
			// Assert
			assertEquals(MENSAJE_PLACA, e.getMessage());
		}

	}

	/**
	 * Test encargado de validar el ciliendraje
	 */
	@Test
	public void validarCilindrada() {

		// Arrange
		Long numCilindrada = 0l;

		try {
			// Act
			validacionParqueaderoLogicaMock.validarCilindrada(numCilindrada);

		} catch (Exception e) {
			// Assert
			assertEquals(MENSAJE_CILINDRADA, e.getMessage());
		}

	}

}
