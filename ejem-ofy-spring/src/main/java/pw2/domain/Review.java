package pw2.domain;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import java.util.Date;
import java.io.Serializable;

@Entity
public class Review implements Serializable{
  @Id private Long id;
  @Index private String comentario;
  @Index private Date fecha;

	/**
	* Default empty Review constructor
	*/
	public Review() {
		super();
	}

	/**
	* Default Review constructor
	*/
	public Review(Long id, String comentario, Date fecha) {
		super();
		this.id = id;
		this.comentario = comentario;
		this.fecha = fecha;
	}

	/**
	* Returns value of id
	* @return
	*/
	public Long getId() {
		return id;
	}

	/**
	* Sets new value of id
	* @param
	*/
	public void setId(Long id) {
		this.id = id;
	}

	/**
	* Returns value of comentario
	* @return
	*/
	public String getComentario() {
		return comentario;
	}

	/**
	* Sets new value of comentario
	* @param
	*/
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	* Returns value of fecha
	* @return
	*/
	public Date getFecha() {
		return fecha;
	}

	/**
	* Sets new value of fecha
	* @param
	*/
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
