package co.com.ceibaparqueadero.dominio.dto;



import co.com.ceibaparqueadero.infraestructura.entidades.ClaseAutomotor;
import co.com.ceibaparqueadero.infraestructura.entidades.Estado;

public class ParqueaderoDto {
	
	private Long id;
	private String placa;
	private Long cilindraje;
	private String fechaRegistro;
	private String fechaSalida;
	private Double valor;
	private ClaseAutomotor claseAutomotor;
	private Estado estado;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Long getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(Long cilindraje) {
		this.cilindraje = cilindraje;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public ClaseAutomotor getClaseAutomotor() {
		return claseAutomotor;
	}
	public void setClaseAutomotor(ClaseAutomotor claseAutomotor) {
		this.claseAutomotor = claseAutomotor;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
