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
 * Home object for domain model class BccStateRef.
 * @see com.dcsoft.capmkt.orm.BccStateRef
 * @author Hibernate Tools
 */
public class BccStateRefHome {

	private static final Log log = LogFactory.getLog(BccStateRefHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(BccStateRef transientInstance) {
		log.debug("persisting BccStateRef instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(BccStateRef instance) {
		log.debug("attaching dirty BccStateRef instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BccStateRef instance) {
		log.debug("attaching clean BccStateRef instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(BccStateRef persistentInstance) {
		log.debug("deleting BccStateRef instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BccStateRef merge(BccStateRef detachedInstance) {
		log.debug("merging BccStateRef instance");
		try {
			BccStateRef result = (BccStateRef) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BccStateRef findById(com.dcsoft.capmkt.orm.BccStateRefId id) {
		log.debug("getting BccStateRef instance with id: " + id);
		try {
			BccStateRef instance = (BccStateRef) sessionFactory.getCurrentSession()
					.get("com.dcsoft.capmkt.orm.BccStateRef", id);
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

	public List<BccStateRef> findByExample(BccStateRef instance) {
		log.debug("finding BccStateRef instance by example");
		try {
			List<BccStateRef> results = (List<BccStateRef>) sessionFactory.getCurrentSession()
					.createCriteria("com.dcsoft.capmkt.orm.BccStateRef").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
