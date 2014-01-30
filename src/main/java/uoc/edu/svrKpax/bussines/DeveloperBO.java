package uoc.edu.svrKpax.bussines;

//import java.util.List;

//import uoc.edu.svrKpax.vo.Developer;

public interface DeveloperBO {

	
	public boolean setDeveloper(String campusSession, int idgame, int idplatform, int idowner, int idstate);
	public Boolean delGameDeveloped(String campusSession, int idGame);
	
	
}
