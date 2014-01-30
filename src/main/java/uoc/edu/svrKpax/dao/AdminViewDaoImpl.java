package uoc.edu.svrKpax.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import uoc.edu.svrKpax.vo.AdminView;

public class AdminViewDaoImpl extends HibernateDaoSupport implements AdminViewDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminView> ListAllGames() {
		return getHibernateTemplate().find("from AdminView");
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AdminView> ListOwnGames(int idowner) {
		return getHibernateTemplate().find("from AdminView where idowner=?",idowner);

	}
	

	public AdminView getOneGame(int idgame) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AdminView.class);
		criteria.add(Restrictions.eq("idGame", idgame));
		return (AdminView) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}


	

	
}
