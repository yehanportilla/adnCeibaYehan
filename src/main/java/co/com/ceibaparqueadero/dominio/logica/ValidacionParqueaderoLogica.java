package co.com.ceibaparqueadero.dominio.logica;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceibaparqueadero.dominio.dto.TiempoParqueaderoDto;
import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.ParqueaderoRepositorio;
import co.com.ceibaparqueadero.infraestructura.persistencia.repositorios.TarifaRepositorio;

@Service
public class ValidacionParqueaderoLogica {

	private static final Character LETRA = 'A';
	private static final String MENSAJE_PLACA = "Lo sentimos. No esta autorizado a ingresar  !";
	private static final String MENSAJE_CUPO_MOTO = "Lo sentimos no hay cupo para moto   !";
	private static final String MENSAJE_CUPO_CARRO = "Lo sentimos no hay cupo para carro   !";
	private static final String MENSAJE_AUTOMOTOR_NO_AUTORIZADO = "Lo sentimos. Automotor no autorizado para registro   !";
	private static final Long CLASE_MOTO = 2l;
	private static final Long CLASE_CARRO = 1l;
	private static final Long ESTADO_REGISTRADO = 1l;
	private static final int CUPO_MOTO = 10;
	private static final int CUPO_CARRO = 30;
	private static final int CILINDRADA_MINIMA = 1;
	private static final int CILINDRADA_MAXIMA = 10000;
	private static final String MENSAJE_CILINDRADA = "Cilindraje no permitido   !";
	private static final Long ID_DIA = 1l;
	private static final Long ID_HORA = 2l;
	private static final int REGLA_HORA = 9;
	private static final Double COBRO_ADICIONAL_MOTO = 2000d;
	private static final int REGLA_CILINDRADA = 500;

	@Autowired
	ParqueaderoRepositorio parqueaderoRepositorio;

	@Autowired
	TarifaRepositorio tarifaRepositorio;

	@Autowired
	CalculaTiempoParqueaderoLogica calculaTiempoParqueaderoLogica;

	/**
	 * Metodo encargado de validar el tipo de automotor
	 * 
	 * @return
	 */
	public void validarTipoAutomotor(Long tipoAutomotor) throws ParqueaderoExcepcion {

		if (!tipoAutomotor.equals(CLASE_MOTO) && !tipoAutomotor.equals(CLASE_CARRO)) {

			throw new ParqueaderoExcepcion(MENSAJE_AUTOMOTOR_NO_AUTORIZADO);
		}
	}

	/**
	 * Metodo encargado de validar el cupo del parqueadero
	 * 
	 * @return
	 */
	public void validarCupoParqueadero(Long tipoAutomotor, Long estadoAutomotor) throws ParqueaderoExcepcion {

		Integer cantidadAutomotorRegistrados = parqueaderoRepositorio.cantidadAutomotorRegistrado(tipoAutomotor,estadoAutomotor);

		if (tipoAutomotor.equals(CLASE_MOTO) && estadoAutomotor.equals(ESTADO_REGISTRADO) && cantidadAutomotorRegistrados >= CUPO_MOTO) {

			throw new ParqueaderoExcepcion(MENSAJE_CUPO_MOTO);
		}
		if (tipoAutomotor.equals(CLASE_CARRO) && estadoAutomotor.equals(ESTADO_REGISTRADO) && cantidadAutomotorRegistrados >= CUPO_CARRO) {

			throw new ParqueaderoExcepcion(MENSAJE_CUPO_CARRO);
		}
	}

	/**
	 * Metodo encargado de validar el ingreso de la placa que inicie por A
	 * 
	 * @return
	 */
	public void validarIngresoPlacaDia(String numPlaca) throws ParqueaderoExcepcion {

		int diaSemanaActual = obtenerDia();
		if (LETRA == numPlaca.charAt(0) && (diaSemanaActual != Calendar.SUNDAY || diaSemanaActual != Calendar.MONDAY)) {

			throw new ParqueaderoExcepcion(MENSAJE_PLACA);
		}
	}

	/**
	 * Metodo encargado de obtener el dia de la semana
	 * 
	 * @return
	 */
	public Integer obtenerDia() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * Metodo encagado de validar la cilindrada
	 * 
	 * @param numCilindrada
	 */
	public void validarCilindrada(Long numCilindrada) throws ParqueaderoExcepcion {

		if (numCilindrada < CILINDRADA_MINIMA || numCilindrada > CILINDRADA_MAXIMA) {
			throw new ParqueaderoExcepcion(MENSAJE_CILINDRADA);
		}
	}

	/**
	 * Metodo encargado de calcular el valor segun el tiempo
	 * 
	 * @param claseId
	 * @param tiempoParqueaderoDto
	 * @param cilindrada
	 * @return
	 */
	public Double calcularValorTiempo(Long claseId, TiempoParqueaderoDto tiempoParqueaderoDto, Long cilindrada) {

		Double tarifaDia = tarifaRepositorio.tarifaPorClase(claseId, ID_DIA);
		Double tarifaHora = tarifaRepositorio.tarifaPorClase(claseId, ID_HORA);

		Double precioGenerado = tiempoParqueaderoDto.getDia() * tarifaDia;

		if (tiempoParqueaderoDto.getHora() >= REGLA_HORA) {// si pasa de 9 horas se cobra el dia
			precioGenerado += tarifaDia;
		} else {// si no se cobra por horas

			precioGenerado += tiempoParqueaderoDto.getHora() * tarifaHora;

			if (tiempoParqueaderoDto.getMinuto() > 0) {
				precioGenerado += tarifaHora;
			}
		}
		if (REGLA_CILINDRADA < cilindrada && claseId.equals(CLASE_MOTO)) {// si cilindraje es mayor a 500 se cobra 2000
																			// mas
			precioGenerado += COBRO_ADICIONAL_MOTO;
		}

		return precioGenerado;
	}

	/**
	 * Metodo encargado de calcular el precio a pagar
	 */
	public Double calcularPrecioAPagar(Date fechaRegistro, Date fechaSalida, Long tipoAutomotor, Long cilindrada) {

		TiempoParqueaderoDto tiempoParqueaderoDto = CalculaTiempoParqueaderoLogica
				.calcularTiempoParqueadero(fechaRegistro, fechaSalida);

		return calcularValorTiempo(tipoAutomotor, tiempoParqueaderoDto, cilindrada);
	}

}
