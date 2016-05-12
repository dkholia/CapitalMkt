package com.dcsoft.capmkt.orm;
// Generated Apr 18, 2016 3:24:50 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class CrwCaResoln.
 * @see com.dcsoft.capmkt.orm.CrwCaResoln
 * @author Hibernate Tools
 */
public class CrwCaResolnHome {

	private static final Log log = LogFactory.getLog(CrwCaResolnHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(CrwCaResoln transientInstance) {
		log.debug("persisting CrwCaResoln instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CrwCaResoln instance) {
		log.debug("attaching dirty CrwCaResoln instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CrwCaResoln instance) {
		log.debug("attaching clean CrwCaResoln instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CrwCaResoln persistentInstance) {
		log.debug("deleting CrwCaResoln instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CrwCaResoln merge(CrwCaResoln detachedInstance) {
		log.debug("merging CrwCaResoln instance");
		try {
			CrwCaResoln result = (CrwCaResoln) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CrwCaResoln findById(com.dcsoft.capmkt.orm.CrwCaResolnId id) {
		log.debug("getting CrwCaResoln instance with id: " + id);
		try {
			CrwCaResoln instance = (CrwCaResoln) sessionFactory.getCurrentSession()
					.get("com.dcsoft.capmkt.orm.CrwCaResoln", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<CrwCaResoln> findByExample(CrwCaResoln instance) {
		log.debug("finding CrwCaResoln instance by example");
		try {
			List<CrwCaResoln> results = (List<CrwCaResoln>) sessionFactory.getCurrentSession()
					.createCriteria("com.dcsoft.capmkt.orm.CrwCaResoln").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
