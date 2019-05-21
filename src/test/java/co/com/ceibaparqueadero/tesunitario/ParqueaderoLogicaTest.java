package co.com.ceibaparqueadero.tesunitario;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceibaparqueadero.dominio.dto.ParqueaderoDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.dominio.logica.ParqueaderoLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.builder.ParqueaderoBuilder;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ParqueaderoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.ParqueaderoRepositorio;


public class ParqueaderoLogicaTest {
	
	private static final String MENSAJE_ERROR = "Error: Al Registrar  !";
	
	@Mock
	private ParqueaderoRepositorio parqueaderoRepositorio;
	
	@InjectMocks
	ParqueaderoLogica parqueaderoLogica;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	
	/**
	 * Test encargado de listar los automotores registrados
	 */
	@Test
	public void listarRegistroAutomotores() {

		// Arrange
		List<String> esperado = Arrays.asList();

		// Act
		List<ParqueaderoEntidad> parqueaderoEntidad = parqueaderoLogica.listarRegistroAutomotor();

		// Assert
		assertEquals(esperado, parqueaderoEntidad);
	}
	
	/**
	 * Test  encargado de enviar excepcion al no guardar informacion
	 * 
	 * @throws ParqueaderoExcepcion
	 */
	@Test
	public void guardarRegistroParqueoNull(){

		// Arrange
		ParqueaderoDto detalleParqueo = new ParqueaderoDto();

		// Act
		parqueaderoRepositorio.save(ParqueaderoBuilder.convertirAEntidad(detalleParqueo));
		
		// Assert
		assertEquals(MENSAJE_ERROR,MENSAJE_ERROR);
	
	}
	

}
