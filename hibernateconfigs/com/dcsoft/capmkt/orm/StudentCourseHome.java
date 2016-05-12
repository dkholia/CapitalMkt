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
 * Home object for domain model class StudentCourse.
 * @see com.dcsoft.capmkt.orm.StudentCourse
 * @author Hibernate Tools
 */
public class StudentCourseHome {

	private static final Log log = LogFactory.getLog(StudentCourseHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(StudentCourse transientInstance) {
		log.debug("persisting StudentCourse instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(StudentCourse instance) {
		log.debug("attaching dirty StudentCourse instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StudentCourse instance) {
		log.debug("attaching clean StudentCourse instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(StudentCourse persistentInstance) {
		log.debug("deleting StudentCourse instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StudentCourse merge(StudentCourse detachedInstance) {
		log.debug("merging StudentCourse instance");
		try {
			StudentCourse result = (StudentCourse) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StudentCourse findById(com.dcsoft.capmkt.orm.StudentCourseId id) {
		log.debug("getting StudentCourse instance with id: " + id);
		try {
			StudentCourse instance = (StudentCourse) sessionFactory.getCurrentSession()
					.get("com.dcsoft.capmkt.orm.StudentCourse", id);
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

	public List<StudentCourse> findByExample(StudentCourse instance) {
		log.debug("finding StudentCourse instance by example");
		try {
			List<StudentCourse> results = (List<StudentCourse>) sessionFactory.getCurrentSession()
					.createCriteria("com.dcsoft.capmkt.orm.StudentCourse").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
