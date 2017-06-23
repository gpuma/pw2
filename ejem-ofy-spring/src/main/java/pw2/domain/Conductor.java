package pw2.domain;

import java.util.Date;
import java.io.Serializable;

//el POJO tiene que ser Serializable para el DataBinding de SPRING!!!!!
public class Conductor implements Serializable{
  private String usuario;
  private String telefono;
  private Date fecNac;

	/**
	* Default empty Conductor constructor
	*/
	public Conductor() {
		super();
	}

	/**
	* Default Conductor constructor
	*/
	public Conductor(String usuario, String telefono, Date fecNac) {
		super();
		this.usuario = usuario;
		this.telefono = telefono;
		this.fecNac = fecNac;
	}

	/**
	* Returns value of usuario
	* @return
	*/
	public String getUsuario() {
		return usuario;
	}

	/**
	* Sets new value of usuario
	* @param
	*/
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	* Returns value of telefono
	* @return
	*/
	public String getTelefono() {
		return telefono;
	}

	/**
	* Sets new value of telefono
	* @param
	*/
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	* Returns value of fecNac
	* @return
	*/
	public Date getFecNac() {
		return fecNac;
	}

	/**
	* Sets new value of fecNac
	* @param
	*/
	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}
}
