package co.com.ceibaparqueadero.tesunitario;

import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.ceibaparqueadero.dominio.dto.ParqueaderoDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.dominio.logica.ParqueaderoLogica;
import co.com.ceibaparqueadero.dominio.logica.ValidacionParqueaderoLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.builder.ParqueaderoBuilder;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.EstadoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ParqueaderoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.ParqueaderoRepositorio;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ParqueaderoLogicaTest {
	
	private static final String MENSAJE_ERROR = "Error: Al Registrar  !";
	
	@Mock
	private ParqueaderoRepositorio parqueaderoRepositorio;
	
	@InjectMocks
	ParqueaderoLogica parqueaderoLogica;
	
	@Mock
	ParqueaderoLogica parqueaderoLogicaMock;
	
	
	@Mock
	private ValidacionParqueaderoLogica validacionParqueaderoLogicaMock;
	
	
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
	public void guardarRegistroParqueoNull() throws ParqueaderoExcepcion{

		// Arrange
		Long id = 8l;
		
		ClaseAutomotorEntidad claseAutomotorEntidad = new ClaseAutomotorEntidad();
		claseAutomotorEntidad.setId(id);
		EstadoEntidad estadoEntidad = new EstadoEntidad();
		estadoEntidad.setId(id);
		ParqueaderoDto detalleParqueo = new ParqueaderoDto();
		detalleParqueo.setClaseAutomotorEntidad(claseAutomotorEntidad);
		detalleParqueo.setEstadoEntidad(estadoEntidad);
		
		try {
			// Act
			parqueaderoLogicaMock.registrarAutomotorParqueadero(detalleParqueo);
			
	
			} catch (ParqueaderoExcepcion e) {
			// Assert
			assertEquals(MENSAJE_ERROR, e.getMessage());

		}
	}
	
	/**
	 * Test encargado crear registro automotor entidad con dominio
	 */

	@Test
	public void crearRegistroEntidadConDominioNull() {
		// Arrange

		// Act
		ParqueaderoEntidad parqueaderoEntidad = ParqueaderoBuilder.convertirAEntidad(null);

		// Assert
		assertEquals(null, parqueaderoEntidad);
	}
	
	/**
	 * Test encargado de validar el set y get de la tabla entidad
	 */
	@Test
	public void validarParqueaderoEntidad() {
		
		// Arrange
		Long id =5l;
		String placa="SSS123";
		Long cilindraje =200l;
		Date fechaRegistro = new Date();
		ClaseAutomotorEntidad claseAutomotorEntidad = new ClaseAutomotorEntidad();
		
		// Act
		ParqueaderoEntidad parqueaderoEntidad = new ParqueaderoEntidad();
		
		parqueaderoEntidad.setId(id);
		parqueaderoEntidad.setPlaca(placa);
		parqueaderoEntidad.setCilindraje(cilindraje);
		parqueaderoEntidad.setFechaRegistro(fechaRegistro);
		parqueaderoEntidad.setClaseAutomotorEntidad(claseAutomotorEntidad);
		
		// Assert
		assertEquals(id, parqueaderoEntidad.getId());
		assertEquals(placa, parqueaderoEntidad.getPlaca());
		assertEquals(cilindraje,parqueaderoEntidad.getCilindraje());
		assertEquals(fechaRegistro,parqueaderoEntidad.getFechaRegistro());
		assertEquals(claseAutomotorEntidad,parqueaderoEntidad.getClaseAutomotorEntidad());
	}

	/**
	 * Test encargado crear registro automotor con entidad null
	 */
	@Test
	public void crearRegistroConEntidadNull() {
		// Arrange

		// Act
		ParqueaderoDto parqueaderoDto = ParqueaderoBuilder.convertirADominio(null);

		// Assert
		assertEquals(null, parqueaderoDto);
	}
	
	/**
	 * Test encargado de validar el set y get de la tabla ParqueaderoDto
	 */
	@Test
	public void validarParqueaderoDto() {
		
		// Arrange
		Long id =5l;
		Date fechaSalida = new Date();
		Double valor = 1000d;
		
		// Act
		ParqueaderoDto parqueaderoDto = new ParqueaderoDto();
		parqueaderoDto.setId(id);
		parqueaderoDto.setFechaSalida(fechaSalida);
		parqueaderoDto.setValor(valor);
		
		// Assert
		assertEquals(id,parqueaderoDto.getId());
		assertEquals(fechaSalida,parqueaderoDto.getFechaSalida());
		assertEquals(valor,parqueaderoDto.getValor());
	}

}
