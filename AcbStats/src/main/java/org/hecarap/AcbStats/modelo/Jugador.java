package org.hecarap.AcbStats.modelo;

import java.util.Date;

public class Jugador {

	String codigo,nombre, nacionalidad, lugarNacimiento;
	double altura;
	Posicion posicion;
	Pasaporte pasaporte;
	Date fechaNacimiento;
	
	
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
