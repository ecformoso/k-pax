package uoc.edu.svrKpax.bussines;

import java.util.List;

import uoc.edu.svrKpax.vo.AdminView;

public interface AdminViewBO {

	public List<AdminView> ListOwnGames(String campusSession, int idowner);
	public AdminView getOneGame(String campusSession, int idgame);
	public List<AdminView> ListAllGames(String campusSession);

}
