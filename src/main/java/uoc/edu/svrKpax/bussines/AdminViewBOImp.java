package uoc.edu.svrKpax.bussines;

import java.util.List;

import uoc.edu.svrKpax.dao.AdminViewDao;
import uoc.edu.svrKpax.vo.AdminView;


public class AdminViewBOImp implements AdminViewBO {

	private SessionBO sBo;
	private AdminViewDao advDao;

	
	@Override
	public List<AdminView> ListOwnGames(String campusSession, int idowner) {
		if (sBo.validateSession(campusSession) != null) {
			return advDao.ListOwnGames(idowner);
		}
		return null;
	}
	
	@Override
	public AdminView getOneGame(String campusSession, int idgame) {
		if (sBo.validateSession(campusSession) != null) {
			return advDao.getOneGame(idgame);
		}
		return null;
		}
		
	@Override
	public List<AdminView> ListAllGames(String campusSession) {
		if (sBo.validateSession(campusSession) != null) {
			return advDao.ListAllGames();
		}
		return null;
		
	}
	
	
	
	public AdminViewDao getadvDao() {
		return advDao;
	}

	public void setadvDao(AdminViewDao advDao) {
		this.advDao = advDao;
	}

	public void setsBo(SessionBO sBo) {
		this.sBo = sBo;
	}

	public SessionBO getsBo() {
		return sBo;
	}


	

	

}