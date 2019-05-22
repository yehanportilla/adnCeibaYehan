package co.com.ceibaparqueadero.tesunitario;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.dominio.logica.CalculaTiempoParqueaderoLogica;
import co.com.ceibaparqueadero.dominio.logica.ValidacionParqueaderoLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.ParqueaderoRepositorio;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional 
public class ValidacionParqueaderoTest {

	private static final String MENSAJE_AUTOMOTOR_NO_AUTORIZADO = "Lo sentimos. Automotor no autorizado para registro   !";
	private static final String MENSAJE_CUPO_MOTO = "Lo sentimos no hay cupo para moto   !";
	private static final String MENSAJE_CUPO_CARRO = "Lo sentimos no hay cupo para carro   !";
	private static final String MENSAJE_PLACA = "Lo sentimos. No esta autorizado a ingresar  !";
	private static final String MENSAJE_CILINDRADA = "Cilindraje no permitido   !";

	@Mock
	private ParqueaderoRepositorio parqueaderoRepositorio;

	@Spy
	private ValidacionParqueaderoLogica validacionParqueaderoLogica;
	
	@InjectMocks
	private CalculaTiempoParqueaderoLogica calculaTiempoParqueaderoLogicaSpy;
	
	
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
			validacionParqueaderoLogica.validarTipoAutomotor(tipoAutomotor);

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
			validacionParqueaderoLogica.validarTipoAutomotor(tipoAutomotor);

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
			validacionParqueaderoLogica.validarTipoAutomotor(tipoAutomotor);

		} catch (ParqueaderoExcepcion ex) {
			// Assert
			assertEquals(MENSAJE_AUTOMOTOR_NO_AUTORIZADO, ex.getMessage());
		}

	}

	/**
	 * Test encargado de validar el ciliendraje minimo
	 */
	@Test
	public void validarCilindradaMinimo() throws ParqueaderoExcepcion {

		// Arrange
		Long numCilindrada = 0l;

		try {
			// Act
			validacionParqueaderoLogica.validarCilindrada(numCilindrada);
			fail();
		} catch (ParqueaderoExcepcion e) {
			// Assert
			assertEquals(MENSAJE_CILINDRADA, e.getMessage());
		}

	}

	/**
	 * Test encargado de validar el ciliendraje maximo
	 */
	@Test
	public void validarCilindradaMaximo() throws ParqueaderoExcepcion {

		// Arrange
		Long numCilindrada = 11000l;

		try {
			// Act
			validacionParqueaderoLogica.validarCilindrada(numCilindrada);
			fail();

		} catch (ParqueaderoExcepcion e) {
			// Assert
			assertEquals(MENSAJE_CILINDRADA, e.getMessage());
		}

	}
	
	/**
	 * Test encargado de validar el cupo para el parqueadero Moto
	 */

	@Test
	public void validarCupoParqueaderoMoto() throws ParqueaderoExcepcion {

		// Arrange
		Long tipoAutomotor = 2l;
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
	 * Test encargado de validar el cupo para el parqueadero Carro
	 */

	@Test
	public void validarCupoParqueaderoCarro() throws ParqueaderoExcepcion {

		// Arrange
		Long tipoAutomotor = 1l;
		Long estadoAutomotor = 1l;
		try {
			// Act
			validacionParqueaderoLogicaMock.validarCupoParqueadero(tipoAutomotor, estadoAutomotor);
			

		} catch (ParqueaderoExcepcion ex) {
			// Assert
			assertEquals(MENSAJE_CUPO_CARRO, ex.getMessage());
		}
	}
	
	/**
	 * Test encargado de validar placa que enpieze por A, no ingresa lunes
	 * 
	 */
	@Test
	public void validarPlacaLunes() {

		// Arrange
		String numPlaca = "ABC123";

		when(validacionParqueaderoLogica.obtenerDia()).thenReturn(Calendar.MONDAY);
		try {
			// Act
			validacionParqueaderoLogica.validarIngresoPlacaDia(numPlaca);
			fail();

		} catch (Exception e) {
			// Assert
			assertEquals(MENSAJE_PLACA, e.getMessage());
		}
	}
	
	/**
	 * Test encargado de validar placa que enpieze por A, no ingresa Domingo
	 * 
	 */
	@Test
	public void validarPlacaDomingo() {

		// Arrange
		String numPlaca = "ABC124";

		when(validacionParqueaderoLogica.obtenerDia()).thenReturn(Calendar.SUNDAY);
		try {
			// Act
			validacionParqueaderoLogica.validarIngresoPlacaDia(numPlaca);
			fail();

		} catch (Exception e) {
			// Assert
			assertEquals(MENSAJE_PLACA, e.getMessage());
		}
	}
	
	
	//----
	@Test
	public void validarTiempoParqueadero() throws ParseException {
		
		// Arrange
		   SimpleDateFormat fechaInicio = new SimpleDateFormat("yyy-mm-dd H:m:s");
		   String fecha= "2019-05-23 17:00:00";
		   Date fechaRegistro = fechaInicio.parse(fecha);
		   
		   Date fechaFinal = new Date();
		   
		   int diferencia = (int) ((fechaFinal.getTime() - fechaRegistro.getTime()) / 1000);
		   int segundosPorDia = 86400;
	       
		   double dia = (diferencia/segundosPorDia);
		   //dias = (int) Math.floor(dia);
		
		// Act
	       CalculaTiempoParqueaderoLogica.calcularTiempoParqueadero(fechaRegistro,fechaFinal);
		 
		// Assert
		   assertEquals(dia, 118.0d, 3);
	}
	

}
