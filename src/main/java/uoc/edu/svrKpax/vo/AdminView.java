package uoc.edu.svrKpax.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "AdminView")
public class AdminView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idGame;
	private String name;
	private int publicAcces;
	private String secretGame;
	private String privateKey;
	private int idCategory;
	private Date creationDate;
	private int idstate;
	private int idplatform;
	private int idowner;
	

	@Id
	@Column(name = "idGame")
	public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	@Column(name = "grantPublicAccess")
	public int getPublicAcces() {
		return publicAcces;
	}

	public void setPublicAcces(int publicAcces) {
		this.publicAcces = publicAcces;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "secretGame")
	public String getSecretGame() {
		return secretGame;
	}

	public void setSecretGame(String secretGame) {
		this.secretGame = secretGame;
	}

	@Column(name = "privateKey")
	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	
	@Column(name = "idCategory", nullable = true) //Set a "nullable=true" property only for installing on production environment. In normal case it should never be null.
	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	@Column(name = "creationDate", nullable = true) //Set a "nullable=true" property only for installing on production environment. In normal case it should never be null.
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Column(name = "idstate")
	public int getIdState() {
		return idstate;
	}

	public void setIdState(int idstate) {
		this.idstate = idstate;
	}

	@Column(name = "idplatform")
	public int getIdPlatform() {
		return idplatform;
	}

	public void setIdPlatform(int idplatform) {
		this.idplatform = idplatform;
	}
	@Column(name = "idowner")
	public int getIdOwner() {
		return idowner;
	}

	public void setIdOwner(int idowner) {
		this.idowner = idowner;
	}
	
}