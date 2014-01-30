package uoc.edu.svrKpax.bussines;

import java.util.List;

import uoc.edu.svrKpax.dao.UserViewDao;
import uoc.edu.svrKpax.vo.UserView;


public class UserViewBOImp implements UserViewBO {

	private SessionBO sBo;
	private UserViewDao usvDao;

	
	@Override
	public List<UserView> ListOwnGames(String campusSession, int idowner) {
		if (sBo.validateSession(campusSession) != null) {
			return usvDao.ListOwnGames(idowner);
		}
		return null;
	}
	
	@Override
	public UserView GetTheGame(String campusSession, int idgame) {
		if (sBo.validateSession(campusSession) != null) {
			return usvDao.GetTheGame(idgame);
		}
		return null;
		}
		
	@Override
	public List<UserView> ListAllGames(String campusSession) {
		if (sBo.validateSession(campusSession) != null) {
			return usvDao.ListAllGames();
		}
		return null;
		
	}
	
	
	
	public UserViewDao getusvDao() {
		return usvDao;
	}

	public void setusvDao(UserViewDao usvDao) {
		this.usvDao = usvDao;
	}

	public void setsBo(SessionBO sBo) {
		this.sBo = sBo;
	}

	public SessionBO getsBo() {
		return sBo;
	}


	

	

}