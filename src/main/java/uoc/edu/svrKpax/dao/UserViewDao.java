package uoc.edu.svrKpax.dao;

import java.util.List;

import uoc.edu.svrKpax.vo.UserView;


public interface UserViewDao {
	

	public List<UserView> ListOwnGames(int idowner);
	public UserView GetTheGame(int idgame);
	public List<UserView> ListAllGames();

}
