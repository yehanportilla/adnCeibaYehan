package co.com.ceibaparqueadero.infraestructura.servicios;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.com.ceibaparqueadero.dominio.exepciones.ParqueaderoExcepcion;

@ControllerAdvice
public class ExcepcionHandler {

	private static final String MSJ_ERROR_INTERNO_DEL_SERVIDOR = "Error en el servidor   !";
	private static final Logger LOGGER = LogManager.getLogger(ExcepcionHandler.class);

	@ExceptionHandler(ParqueaderoExcepcion.class)
	public ResponseEntity<String> manejo(ParqueaderoExcepcion e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> manejarErroresTecnicos(Exception e) {
		LOGGER.error(e.getMessage(), e);
		return new ResponseEntity<>(MSJ_ERROR_INTERNO_DEL_SERVIDOR, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
