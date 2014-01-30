package uoc.edu.svrKpax.dao;

import java.util.List;

import uoc.edu.svrKpax.vo.AdminView;


public interface AdminViewDao {
	

	public List<AdminView> ListOwnGames(int idowner);
	public AdminView getOneGame(int idgame);
	public List<AdminView> ListAllGames();

}
