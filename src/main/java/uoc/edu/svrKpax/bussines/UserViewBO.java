package uoc.edu.svrKpax.bussines;

import java.util.List;

import uoc.edu.svrKpax.vo.UserView;

public interface UserViewBO {

	public List<UserView> ListOwnGames(String campusSession, int idowner);
	public UserView GetTheGame(String campusSession, int idgame);
	public List<UserView> ListAllGames(String campusSession);

}
