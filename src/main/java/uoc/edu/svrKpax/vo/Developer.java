package uoc.edu.svrKpax.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
//import javax.persistence.OneToOne;
//import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "Developer",
			uniqueConstraints = 
			{
				@UniqueConstraint(columnNames= {"idGame"})
			}
		)
public class Developer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idgame;
	private int idState;
	private int idPlatform;
	private int idowner; 


	@Id
	@Column(name = "idGame")
	public int getIdGame() {
		return idgame;
	}

	/*
	 * 
	 *   @OneToOne(fetch=FetchType.LAZY, mappedBy="address")
  private Game idgame;
	 * 
	 */
	
	public void setIdGame(int idgame) {
		this.idgame = idgame;
	}
		
	@Column(name = "idState")
	public int getIdState() {
		return idState;
	}

	public void setIdState(int idState) {
		this.idState = idState;
	}
	
	@Column(name = "idPlatform")
	public int getIdPlatform() {
		return idPlatform;
	}

	public void setIdPlatform(int idPlatform) {
		this.idPlatform = idPlatform;
	}
	
	@Column(name = "idowner")
	public int getIdowner() {
		return idowner;
	}

	public void setIdowner(int idowner) {
		this.idowner = idowner;
	}
	
	
}