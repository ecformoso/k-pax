package uoc.edu.svrKpax.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import uoc.edu.svrKpax.vo.UserView;

public class UserViewDaoImpl extends HibernateDaoSupport implements UserViewDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserView> ListAllGames() {
		return getHibernateTemplate().find("from UserView");
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserView> ListOwnGames(int idowner) {
		return getHibernateTemplate().find("from UserView where idowner=?",idowner);

	}
	

	public UserView GetTheGame(int idgame) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserView.class);
		criteria.add(Restrictions.eq("idgame", idgame));
		return (UserView) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}


	

	
}
