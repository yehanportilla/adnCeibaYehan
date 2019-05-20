package co.com.ceibaparqueadero.dominio.logica;

import java.text.ParseException;
import java.util.Date;

import org.springframework.web.bind.annotation.RestController;

import co.com.ceibaparqueadero.dominio.dto.TiempoParqueaderoDto;

@RestController
public final class CalculaTiempoParqueaderoLogica {
	
	private CalculaTiempoParqueaderoLogica() {}

	/**
	 * Metodo encargado de calcular el tiempo
	 * 
	 * @param fechaRegistro
	 * @param fechaSalida
	 * @return
	 * @throws ParseException
	 */
	public static TiempoParqueaderoDto calcularTiempoParqueadero(Date fechaInicial, Date fechaFinal){

		int diferencia = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 1000);

		int dias = 0;
		int horas = 0;
		int minutos = 0;
		int segundosPorDia = 86400;
		int segundosPorHora = 3600;
		int minutosPorHora = 60;

		if (diferencia > segundosPorDia) {

			double dia = (diferencia / segundosPorDia);
			dias = (int) Math.floor(dia);
			diferencia = diferencia - (dias * segundosPorDia);
		}
		if (diferencia > segundosPorHora) {

			double hora = (diferencia / segundosPorHora);
			horas = (int) Math.floor(hora);

			diferencia = diferencia - (horas * segundosPorHora);
		}
		if (diferencia > minutosPorHora) {

			double minuto = (diferencia / minutosPorHora);
			minutos = (int) Math.floor(minuto);
			diferencia = diferencia - (minutos * minutosPorHora);
		}

		return new TiempoParqueaderoDto(dias, horas, minutos, diferencia);

	}

}
