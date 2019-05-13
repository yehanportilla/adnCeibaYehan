package co.com.ceibaparqueadero.dominio.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.ceibaparqueadero.dominio.utilidades.Respuesta;

public class CalculaTiempoParqueaderoLogica {

	/**
	 * Metodo encargado de calcular el tiempo
	 * 
	 * @param fechaRegistro
	 * @param fechaSalida
	 * @return
	 * @throws ParseException
	 */
	public Respuesta calcularTiempoParqueadero(String fechaRegistro, String fechaSalida) throws ParseException {

		Respuesta respuesta = new Respuesta();

		Date fechaInicial = new SimpleDateFormat("yyyy-MM-dd H:m:s").parse(fechaRegistro);
		Date fechaFinal = new SimpleDateFormat("yyyy-MM-dd H:m:s").parse(fechaSalida);

		int diferencia = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 1000);

		int dias = 0;
		int horas = 0;
		int minutos = 0;
		int sec = 86400;
		int seg = 3600;
		int min = 60;

		if (diferencia > sec) {

			double dia = (diferencia / 86400);
			dias = (int) Math.floor(dia);
			diferencia = diferencia - (dias * 86400);
		}
		if (diferencia > seg) {

			double hora = (diferencia / 3600);
			horas = (int) Math.floor(hora);

			diferencia = diferencia - (horas * 3600);
		}
		if (diferencia > min) {

			double minuto = (diferencia / 60);
			minutos = (int) Math.floor(minuto);
			diferencia = diferencia - (minutos * 60);
		}
		respuesta.setCodigo(0);
		respuesta.setMensaje("Hay " + dias + " dias, " + horas + " horas, " + minutos + " minutos y " + diferencia
				+ " segundos de diferencia");

		return respuesta;

	}

}
