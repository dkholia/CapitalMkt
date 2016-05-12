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
 * Home object for domain model class DsCustodyTiStaging.
 * @see com.dcsoft.capmkt.orm.DsCustodyTiStaging
 * @author Hibernate Tools
 */
public class DsCustodyTiStagingHome {

	private static final Log log = LogFactory.getLog(DsCustodyTiStagingHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(DsCustodyTiStaging transientInstance) {
		log.debug("persisting DsCustodyTiStaging instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DsCustodyTiStaging instance) {
		log.debug("attaching dirty DsCustodyTiStaging instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DsCustodyTiStaging instance) {
		log.debug("attaching clean DsCustodyTiStaging instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DsCustodyTiStaging persistentInstance) {
		log.debug("deleting DsCustodyTiStaging instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DsCustodyTiStaging merge(DsCustodyTiStaging detachedInstance) {
		log.debug("merging DsCustodyTiStaging instance");
		try {
			DsCustodyTiStaging result = (DsCustodyTiStaging) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DsCustodyTiStaging findById(com.dcsoft.capmkt.orm.DsCustodyTiStagingId id) {
		log.debug("getting DsCustodyTiStaging instance with id: " + id);
		try {
			DsCustodyTiStaging instance = (DsCustodyTiStaging) sessionFactory.getCurrentSession()
					.get("com.dcsoft.capmkt.orm.DsCustodyTiStaging", id);
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

	public List<DsCustodyTiStaging> findByExample(DsCustodyTiStaging instance) {
		log.debug("finding DsCustodyTiStaging instance by example");
		try {
			List<DsCustodyTiStaging> results = (List<DsCustodyTiStaging>) sessionFactory.getCurrentSession()
					.createCriteria("com.dcsoft.capmkt.orm.DsCustodyTiStaging").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
