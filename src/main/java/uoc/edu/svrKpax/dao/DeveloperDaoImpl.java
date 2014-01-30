package uoc.edu.svrKpax.dao;

//import java.util.List;

//import org.hibernate.criterion.DetachedCriteria;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.dao.support.DataAccessUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import uoc.edu.svrKpax.vo.Developer;


public class DeveloperDaoImpl extends HibernateDaoSupport implements DeveloperDao {

	@Override
	public void setDeveloper(Developer objDeveloper) {
		getHibernateTemplate().saveOrUpdate(objDeveloper);
		
	}

	@Override
	public void delDeveloper(Developer objDeveloper) {
		getHibernateTemplate().delete(objDeveloper);
		
	}

	@Override
	public Developer getDeveloper(int idgame) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Developer.class);
		criteria.add(Restrictions.eq("idGame", idgame));
		return (Developer) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}
	
}


