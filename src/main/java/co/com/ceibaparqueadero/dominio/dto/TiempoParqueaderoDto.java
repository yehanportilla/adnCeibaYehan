package co.com.ceibaparqueadero.dominio.dto;

public class TiempoParqueaderoDto {
	
	private int dia;
	private int hora;
	private int minuto;
	private int segundo;
	
	public TiempoParqueaderoDto(int dia, int hora, int minuto, int segundo) {
		this.dia = dia;
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}
			
}
