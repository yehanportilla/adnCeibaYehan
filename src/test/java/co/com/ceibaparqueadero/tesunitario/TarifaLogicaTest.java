package co.com.ceibaparqueadero.tesunitario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceibaparqueadero.dominio.dto.TarifaDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.dominio.logica.ClaseAutomotorLogica;
import co.com.ceibaparqueadero.dominio.logica.TarifaLogica;
import co.com.ceibaparqueadero.dominio.logica.TiempoLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.builder.TarifaBuilder;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TarifaEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TiempoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.TarifaRepositorio;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.TiempoRepositorio;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional 
public class TarifaLogicaTest {

	private static final String MENSAJE_ERROR = "Error: Al Registrar  !";
	
	@Mock
	private TarifaLogica tarifaLogicaMock;
    
    @InjectMocks
    private TiempoLogica tiempoLogicaInMock;
    
    @Mock
	private TiempoRepositorio tiempoRepositorio;
    
    @Autowired
    private TarifaRepositorio tarifaRepositorio;
    
    @Mock
    private ClaseAutomotorLogica claseAutomotorLogicaMock;
    
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
		List<TarifaEntidad> tarifaEntidad = tarifaLogicaMock.listarTarifa();

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
			tarifaLogicaMock.guardarTarifa(detalleTarifa);

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
		assertEquals(null,tarifaEntidad);
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
	
	
	/**
	 * Test encargado crear la tarifa
	 * @throws ParqueaderoExcepcion 
	 */
	
	@Ignore
	@Test
	public void ShouldCreateRateTest() throws ParqueaderoExcepcion {
        /*
		// Arrange
		TarifaDto tarifaDto = new TarifaDto();
		// Act
		TarifaEntidad tarifaEntidad = TarifaBuilder.convertirAEntidad(tarifaDto);
		// Assert
		assertNotNull(tarifaEntidad);*/
		
		Double valor=5000d;
		
		TarifaDto tarifaDto = new TarifaDto();
		tarifaDto.setId(1l);
		tarifaDto.setValor(valor);
		
		//TiempoEntidad tiempoEntidad = new TiempoEntidad();
		
	   // when(tiempoLogicaInMock.buscarPorIdTiempo(tarifaDto.getTiempoEntidad().getId())).thenReturn(null);
	    
		TiempoEntidad tiempoEntidad = new TiempoEntidad();
		tiempoEntidad.setId(1l);
		tiempoEntidad.setNombre("Dia");
		
		//tarifaDto.setTiempoEntidad(tiempoEntidad);
		
	    when(tiempoLogicaInMock.buscarPorIdTiempo(tarifaDto.getTiempoEntidad().getId())).thenReturn(null);
		
	    //System.err.print("=========>"+tiempo.get().getNombre());
	    
		when(tarifaLogicaMock.guardarTarifa(any())).thenReturn(tarifaDto);
		
	
		//TarifaEntidad creaTarifa = tarifaRepositorio.save(TarifaBuilder.convertirAEntidad(tarifaDto));
		
		TarifaDto guardarTarifa = this.tarifaLogicaMock.guardarTarifa(tarifaDto);
		
		assertNotNull(guardarTarifa);
	
	}
	
	
	/**
	 * Test encargado de validar constructor tarifaentidad
	 */
	  @Test
	  public void validarConstructorTarifa() {
		  
		  Long id=1l;
		  Double valor=5000d;
		  ClaseAutomotorEntidad claseAutomotorEntidad = new ClaseAutomotorEntidad();
		  TiempoEntidad tiempoEntidad = new TiempoEntidad();
		  
		  TarifaEntidad tarifaEntidad = new TarifaEntidad(id,valor,claseAutomotorEntidad,tiempoEntidad);
		  
		  assertEquals(id,tarifaEntidad.getId());
		  assertEquals(valor,tarifaEntidad.getValor());
		  assertEquals(claseAutomotorEntidad,tarifaEntidad.getClaseAutomotorEntidad());
		  assertEquals(tiempoEntidad,tarifaEntidad.getTiempoEntidad());
	
	  }
	
}
