package co.com.ceibaparqueadero.tesintegracion;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceibaparqueadero.aplicacion.repositorio.ClaseAutomotorRepositorio;
import co.com.ceibaparqueadero.aplicacion.repositorio.EstadoRepositorio;
import co.com.ceibaparqueadero.aplicacion.repositorio.TiempoRepositorio;
import co.com.ceibaparqueadero.dominio.logica.ClaseAutomotorLogica;
import co.com.ceibaparqueadero.dominio.logica.EstadoLogica;
import co.com.ceibaparqueadero.dominio.logica.TiempoLogica;
import co.com.ceibaparqueadero.infraestructura.entidades.ClaseAutomotor;
import co.com.ceibaparqueadero.infraestructura.entidades.Estado;
import co.com.ceibaparqueadero.infraestructura.entidades.Tiempo;

public class PruebasIntegracion {

	@Mock
	private EstadoRepositorio estadoRepositorio;

	@Mock
	private TiempoRepositorio tiempoRepositorio;

	@Mock
	private ClaseAutomotorRepositorio claseAutomotorRepositorio;

	@InjectMocks
	ClaseAutomotorLogica claseAutomotorLogica;

	@InjectMocks
	EstadoLogica estadoLogica;
	
	@InjectMocks
	TiempoLogica tiempoLogica;

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
		List<Estado> estado = estadoRepositorio.findAll();

		// Assert
		assertEquals(esperado, estado);
	}

	/**
	 * Test Integracion encargado de listar los tiempos de parqueadero
	 */
	@Test
	public void listarTiempos() {

		// Arrange
		//List<String> esperado = Arrays.asList();

		// Act
		List<Tiempo> esperado = tiempoLogica.listarTiempo();
		List<Tiempo> tiempo = tiempoRepositorio.findAll();

		// Assert
		assertEquals(esperado, tiempo);
	}

	/**
	 * Test Integracion encargado de listar la clase de vehiculo
	 */
	@Test
	public void listarClaseVehiculo() {

		// Arrange
		List<String> esperado = Arrays.asList();

		// Act
		List<ClaseAutomotor> claseAuto = claseAutomotorRepositorio.findAll();

		// Assert
		assertEquals(esperado, claseAuto);
	}

	/**
	 * Test Integracion encargado de guardar la clase de vehiculo
	 */
	@Test
	public void guardarClaseVehiculo() {

		// Arrange
		ClaseAutomotor detalleClase = clase();

		// Act
		int codigoMensaje = claseAutomotorLogica.guardarClaseAutomor(detalleClase).getCodigo();

		// Assert
		assertEquals(0, codigoMensaje);
	}

	private ClaseAutomotor clase() {
		return null;
	}

	/**
	 * Test Integracion encargado de guarda el estado
	 */
	@Test
	public void guardarEstadoVehiculo() {

		// Arrange
		Estado detalleEstado = estado();

		// Act
		int codigoMensaje = estadoLogica.guardarEstado(detalleEstado).getCodigo();

		// Assert
		assertEquals(0, codigoMensaje);
	}

	private Estado estado() {
		return null;
	}
	
}
