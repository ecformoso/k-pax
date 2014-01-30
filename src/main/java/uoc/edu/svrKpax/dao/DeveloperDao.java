package uoc.edu.svrKpax.dao;

//import java.util.List;

import uoc.edu.svrKpax.vo.Developer;


public interface DeveloperDao {
	

	public void setDeveloper(Developer objDeveloper);

	public void delDeveloper(Developer objDeveloper);

	public Developer getDeveloper(int idgame);
}
