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
 * Home object for domain model class ChDapUserMapping.
 * @see com.dcsoft.capmkt.orm.ChDapUserMapping
 * @author Hibernate Tools
 */
public class ChDapUserMappingHome {

	private static final Log log = LogFactory.getLog(ChDapUserMappingHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ChDapUserMapping transientInstance) {
		log.debug("persisting ChDapUserMapping instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ChDapUserMapping instance) {
		log.debug("attaching dirty ChDapUserMapping instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ChDapUserMapping instance) {
		log.debug("attaching clean ChDapUserMapping instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ChDapUserMapping persistentInstance) {
		log.debug("deleting ChDapUserMapping instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ChDapUserMapping merge(ChDapUserMapping detachedInstance) {
		log.debug("merging ChDapUserMapping instance");
		try {
			ChDapUserMapping result = (ChDapUserMapping) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ChDapUserMapping findById(com.dcsoft.capmkt.orm.ChDapUserMappingId id) {
		log.debug("getting ChDapUserMapping instance with id: " + id);
		try {
			ChDapUserMapping instance = (ChDapUserMapping) sessionFactory.getCurrentSession()
					.get("com.dcsoft.capmkt.orm.ChDapUserMapping", id);
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

	public List<ChDapUserMapping> findByExample(ChDapUserMapping instance) {
		log.debug("finding ChDapUserMapping instance by example");
		try {
			List<ChDapUserMapping> results = (List<ChDapUserMapping>) sessionFactory.getCurrentSession()
					.createCriteria("com.dcsoft.capmkt.orm.ChDapUserMapping").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
