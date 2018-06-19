package org.hecarap.acbstats.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Jugador")
public class Jugador implements Serializable {

	@Id
	@Column(name="Id",unique=true)
	private String codigo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="nacionalidad")
	private String nacionalidad;
	
	@Column(name="lugarNacimiento")
	private String lugarNacimiento;
	 
	@Column(name="altura")
	private double altura;
	 
	@Enumerated(EnumType.ORDINAL)
	private Posicion posicion;
	
	@Enumerated(EnumType.ORDINAL)
	private Pasaporte pasaporte;
	
	@Column(name="fechaNacimiento")
	private Date fechaNacimiento;
	
	@OneToMany(mappedBy="jugador",cascade= CascadeType.ALL)
	private Set<PartidoJugador> partidos;
	
	@OneToMany(mappedBy="jugador",cascade= CascadeType.ALL)
	private Set<TemporadaJugador> temporadas;
	
	public Jugador() {		
	}
	
	public Jugador(String codigo,String nombre, String nacionalidad, String lugarNacimiento, double altura, Posicion posicion,
			Pasaporte pasaporte, Date fechaNacimiento) {
		super();
		this.codigo=codigo;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.lugarNacimiento = lugarNacimiento;
		this.altura = altura;
		this.posicion = posicion;
		this.pasaporte = pasaporte;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}		
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Pasaporte getPasaporte() {
		return pasaporte;
	}
	public void setPasaporte(Pasaporte pasaporte) {
		this.pasaporte = pasaporte;
	}	
	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public boolean isCupo() {
		return pasaporte==Pasaporte.CUPO;
	}	
	public boolean isExtra() {
		return pasaporte==Pasaporte.EXTRACOMUNITARIO;
	}
	
	public String toString() {
		String aux="";
		aux+="********************************************************\n";
		aux+="*  "+codigo+"\n";
		aux+="*  "+nombre+"\n";
		aux+="*  "+fechaNacimiento+"\n";
		aux+="*  "+lugarNacimiento+"\n";
		aux+="*  "+nacionalidad+"\n";
		aux+="*  "+pasaporte+"\n";
		aux+="*  "+posicion+"\n";
		aux+="*  "+altura+"\n";
		return aux;
	}
}
