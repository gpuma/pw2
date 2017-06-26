package pw2.domain;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

//el POJO tiene que ser Serializable para el DataBinding de SPRING!!!!!
@Entity
public class Conductor implements Serializable{
  @Id private String usuario;
  private String telefono;
  private Date fecNac;
  private List<Key<Review>> reviews = new ArrayList<Key<Review>>();

	/**
	* Default empty Conductor constructor
	*/
	public Conductor() {
		super();
    //this.reviews = new ArrayList<Key<Review>>();
	}

	/**
	* Default Conductor constructor
	*/
	public Conductor(String usuario, String telefono, Date fecNac, List<Key<Review>> reviews) {
		super();
		this.usuario = usuario;
		this.telefono = telefono;
		this.fecNac = fecNac;
		this.reviews = reviews;
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

	/**
	* Returns value of reviews
	* @return
	*/
	public List<Key<Review>> getReviews() {
		return reviews;
	}

	/**
	* Sets new value of reviews
	* @param
	*/
	public void setReviews(List<Key<Review>> reviews) {
		this.reviews = reviews;
	}
}
