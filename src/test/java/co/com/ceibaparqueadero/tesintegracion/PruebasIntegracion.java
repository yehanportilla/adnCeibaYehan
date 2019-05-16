package co.com.ceibaparqueadero.tesintegracion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;


import co.com.ceibaparqueadero.dominio.logica.ClaseAutomotorLogica;
import co.com.ceibaparqueadero.dominio.logica.EstadoLogica;
import co.com.ceibaparqueadero.dominio.logica.TarifaLogica;
import co.com.ceibaparqueadero.dominio.logica.TiempoLogica;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.ClaseAutomotorEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.EstadoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.entidades.TiempoEntidad;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.ClaseAutomotorRepositorio;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.EstadoRepositorio;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.TarifaRepositorio;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.TiempoRepositorio;

public class PruebasIntegracion {

	@Mock
	private EstadoRepositorio estadoRepositorio;

	@Mock
	private TiempoRepositorio tiempoRepositorio;

	@Mock
	private ClaseAutomotorRepositorio claseAutomotorRepositorio;

	@Mock
	private TarifaRepositorio tarifaRepositorio;

	@Spy
	private TarifaLogica tarifaLogicaMockito;

	@InjectMocks
	ClaseAutomotorLogica claseAutomotorLogica;

	@InjectMocks
	EstadoLogica estadoLogica;

	@InjectMocks
	TiempoLogica tiempoLogica;

	@InjectMocks
	TarifaLogica tarifaLogica;

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

	/**
	 * Test Integracion encargado de listar los tiempos de parqueadero
	 */
	@Test
	public void listarTiempos() {

		// Arrange
		List<String> esperado = Arrays.asList();

		// Act
		List<TiempoEntidad> tiempoEntidad = tiempoLogica.listarTiempo();

		// Assert
		assertEquals(esperado, tiempoEntidad);
	}

	/**
	 * Test Integracion encargado de listar la clase de vehiculo
	 */
	@Test
	public void listarClaseVehiculo() {

		// Arrange
		List<String> esperado = Arrays.asList();

		// Act
		List<ClaseAutomotorEntidad> claseAuto = claseAutomotorLogica.listarClases();

		// Assert
		assertEquals(esperado, claseAuto);
	}

	/**
	 * Test Integracion encargado de guardar la clase de vehiculo con datos Null
	 */
	@Test
	public void guardarClaseVehiculoNull() {

		// Arrange
		ClaseAutomotorBuilder claseAutomotorBuilder = new ClaseAutomotorBuilder();
		ClaseAutomotorEntidad detalleClase = claseAutomotorBuilder.conId(null).conNombre(null).build();

		when(claseAutomotorRepositorio.save(detalleClase)).thenReturn(null);

		// Act
		claseAutomotorLogica.guardarClaseAutomor(detalleClase);

		// Assert
		assertEquals("Error: Al Registrar!", claseAutomotorLogica.guardarClaseAutomor(detalleClase).getMensaje());
	}

	/**
	 * Test Integracion encargado de guardar la clase de vehiculo con datos
	 */

	@Test
	public void guardarClaseVehiculoConDatos() {

		// Arrange
		ClaseAutomotorBuilder claseAutomotorBuilder = new ClaseAutomotorBuilder();
		ClaseAutomotorEntidad detalleClase = claseAutomotorBuilder.conId(4l).conNombre("Tractor").build();

		when(claseAutomotorRepositorio.save(detalleClase)).thenReturn(detalleClase);

		// Act
		claseAutomotorLogica.guardarClaseAutomor(detalleClase);

		// Assert
		assertEquals("Clase: Registrada Exitosamente !",
				claseAutomotorLogica.guardarClaseAutomor(detalleClase).getMensaje());
	}

	/**
	 * Test Integracion encargado de guarda el estado con datos
	 */
	@Test
	public void guardarEstadoVehiculoConDatos() {

		// Arrange
		EstadoEntidad detalleEstado = new EstadoEntidad();

		// Act
		when(estadoRepositorio.save(detalleEstado)).thenReturn(detalleEstado);

		// Assert
		assertEquals("Estado: Registrado Exitosamente !", estadoLogica.guardarEstado(detalleEstado).getMensaje());
	}

	/**
	 * Test Integracion encargado de guarda el estado null
	 */
	@Test
	public void guardarEstadoVehiculoNull() {

		// Arrange
		EstadoEntidad detalleEstado = EstadoNull();

		// Act
		when(estadoRepositorio.save(detalleEstado)).thenReturn(null);

		// Assert
		assertEquals("Error: Al Registrar!", estadoLogica.guardarEstado(detalleEstado).getMensaje());
	}

	/**
	 * Test Integracion encargado de guarda el tiempo con datos
	 * 
	 */

	@Test
	public void guardarTiempoParqueoConDatos() {

		// Arrange
		TiempoEntidad detalleTiempo = new TiempoEntidad();

		// Act
		when(tiempoRepositorio.save(detalleTiempo)).thenReturn(detalleTiempo);

		// Assert
		assertEquals(detalleTiempo, detalleTiempo);
	}

	/**
	 * Test Integracion encargado de guarda el tiempo con datos null
	 * 
	 */

	/*
	 * @Test public void guardarTiempoParqueoNull() {
	 * 
	 * // Arrange TiempoEntidad detalleTiempo = TiempoNull();
	 * 
	 * // Act when(tiempoRepositorio.save(detalleTiempo)).thenReturn(null);
	 * 
	 * // Assert assertEquals("Error: Al Registrar!",
	 * tiempoLogica.guardarTiempo(detalleTiempo).getMensaje()); }
	 */

	/**
	 * Test Integracion encargado de listar las tarifas
	 */
	/*
	 * @Test public void listarTarifas() {
	 * 
	 * // Arrange List<String> esperado = Arrays.asList();
	 * 
	 * // Act List<TarifaEntidad> tarifaEntidad = tarifaLogica.listarTarifa();
	 * 
	 * // Assert assertEquals(esperado, tarifaEntidad); }
	 */

	private EstadoEntidad EstadoNull() {

		return null;
	}

}
