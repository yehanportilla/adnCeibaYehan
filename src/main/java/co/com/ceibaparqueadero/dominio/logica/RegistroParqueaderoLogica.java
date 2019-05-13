package co.com.ceibaparqueadero.dominio.logica;

import java.util.Calendar;

import co.com.ceibaparqueadero.dominio.utilidades.Respuesta;

public class RegistroParqueaderoLogica {

	private static final Character LETRA = 'A';

	/**
	 * Metodo encargado de validar el tipo de automotor
	 * 
	 * @return
	 */
	public Respuesta validarTipoAutomotor(int tipoAutomotor) {

		Respuesta respuesta = new Respuesta();

		if (tipoAutomotor != 1 || tipoAutomotor != 2) {
			respuesta.setCodigo(0);
			respuesta.setMensaje("Tipo de vehiculo No permitido...!");
		}
		return respuesta;
	}

	/**
	 * Metodo encargado de validar el cupo del parqueadero
	 * 
	 * @return
	 */
	public Respuesta validarCupoParqueadero(int tipoAutomotor, int cantidadAutomotor) {

		Respuesta respuesta = new Respuesta();

		if (tipoAutomotor == 1 && cantidadAutomotor >= 20) {
			respuesta.setCodigo(0);
			respuesta.setMensaje("Lo sentimos, no existen cupos para Vehiculos...!");
		}

		if (tipoAutomotor == 2 && cantidadAutomotor >= 10) {
			respuesta.setCodigo(0);
			respuesta.setMensaje("Lo sentimos, no existen cupos para Motos...!");
		}

		return respuesta;

	}

	/**
	 * Metodo encargado de validar el ingreso de la placa que inicie por A
	 * 
	 * @return
	 */
	public Respuesta validarIngresoPlacaDia(String numPlaca) {
		int diaSemanaActual = obtenerDia();

		Respuesta respuesta = new Respuesta();
		
	    if (LETRA == numPlaca.charAt(0) && Calendar.SUNDAY == diaSemanaActual || Calendar.MONDAY == diaSemanaActual) {
			respuesta.setCodigo(0);
			respuesta.setMensaje("Lo sentimos, no puede ingresar...!");
		}

		return respuesta;
	}

	/**
	 * Metodo encargado de obtener el dia de la semana
	 * 
	 * @return
	 */
	public Integer obtenerDia() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
	}

}
