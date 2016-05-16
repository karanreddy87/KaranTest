package com.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.model.Countrylist;
import com.model.Logintable;
@Component
public class LoginDaoImpl  implements LoginDao {
	Logger LOG=Logger.getLogger(LoginDaoImpl.class);
	
	/*SessionFactory sessionFactory;
	
	

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/


	HibernateTemplate hibernateTemplate;
	
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}




	@Override
	public void insertLoginForm(Logintable loginForm) {
		LOG.info("in LoginDaoImpl insertLoginForm"+loginForm.getLoignname());
		hibernateTemplate.save(loginForm);
		/*Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(loginForm);
		transaction.commit();*/
		System.out.println("success");
		
	}




	@Override
	public List<Countrylist> loadCountryList() {
		List<Countrylist> list=hibernateTemplate.loadAll(Countrylist.class);
		
		LOG.info("countrylist size::"+list.size());
		return list;
	}

}
