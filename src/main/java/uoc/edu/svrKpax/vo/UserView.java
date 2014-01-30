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
@Table(name = "UserView")
public class UserView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idGame;
	private String name;
	private int publicAcces;
	private String Category;
	private Date creationDate;
	private String State;
	private String Platform;
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

		
	@Column(name = "Category", nullable = true) //Set a "nullable=true" property only for installing on production environment. In normal case it should never be null.
	public String getCategory() {
		return Category;
	}

	public void setCategory(String Category) {
		this.Category = Category;
	}

	@Column(name = "creationDate", nullable = true) //Set a "nullable=true" property only for installing on production environment. In normal case it should never be null.
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Column(name = "State")
	public String getState() {
		return State;
	}

	public void setState(String State) {
		this.State = State;
	}

	@Column(name = "Platform", nullable = true) //Set a "nullable=true" property only for installing on production environment. In normal case it should never be null.
	public String getPlatform() {
		return Platform;
	}

	public void setPlatform(String Platform) {
		this.Platform = Platform;
	}
	@Column(name = "idowner")
	public int getIdOwner() {
		return idowner;
	}

	public void setIdOwner(int idowner) {
		this.idowner = idowner;
	}
	
}