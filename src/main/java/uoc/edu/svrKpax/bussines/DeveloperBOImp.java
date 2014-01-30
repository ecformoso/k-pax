package uoc.edu.svrKpax.bussines;

//import java.util.List;


import uoc.edu.svrKpax.dao.DeveloperDao;
//import uoc.edu.svrKpax.util.Security;

import uoc.edu.svrKpax.vo.Developer;

;

public class DeveloperBOImp implements DeveloperBO {

	private SessionBO sBo;
	private DeveloperDao devDao;
	
	
	@Override
	public boolean setDeveloper(String campusSession, int idgame,
			int idplatform, int idowner, int idstate) {
		
		try {
			if (sBo.validateSession(campusSession) != null) {
				Developer objDeveloper = new Developer();
				objDeveloper.setIdGame(idgame);
				if (idstate == 0){idstate = 1;}
				objDeveloper.setIdState(idstate);
				objDeveloper.setIdPlatform(idplatform);
				objDeveloper.setIdowner(idowner);
				
				devDao.setDeveloper(objDeveloper);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
				
		return false;
	}
	
	@Override
	public Boolean delGameDeveloped(String campusSession, int idGame) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				Developer objDeveloper = devDao.getDeveloper(idGame);
				if (objDeveloper!=null){
					
					devDao.delDeveloper(objDeveloper);
					return true;
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;	
		}
		return false;	
	}
	
	
	
	public DeveloperDao getdevDao() {
		return devDao;
	}

	public void setdevDao(DeveloperDao devDao) {
		this.devDao = devDao;
	}

	public void setsBo(SessionBO sBo) {
		this.sBo = sBo;
	}

	public SessionBO getsBo() {
		return sBo;
	}

	
	
}