package co.yamid.hibernate.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLEADO")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="COD_EMPLEADO")
	private Long codigo;
	
	@Column(name ="APELLIDOS")
	private String apellidos;
	
	@Column(name ="NOMBRE")
	private String nombre;
	
	@Column(name ="FECHA_NAC")
	private LocalDate fechaNacimiento;

	@OneToOne
	@JoinColumn(name = "ID_DIRECCION")
	private Direccion direccion;

	public Empleado() {

	}

	public Empleado(Long codigo, String apellidos, String nombre, LocalDate fechaNacimiento) {
		super();
		this.codigo = codigo;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Empleado [codigo=").append(codigo).append(", apellidos=").append(apellidos).append(", nombre=")
				.append(nombre).append(", fechaNacimiento=").append(fechaNacimiento).append(", direccion=")
				.append(direccion).append("]");
		return builder.toString();
	}
}
