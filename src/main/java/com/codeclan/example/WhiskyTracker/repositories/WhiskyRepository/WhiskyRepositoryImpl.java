package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Whisky> findWhiskyByYear(int year) {
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria criteria = session.createCriteria(Whisky.class);
            criteria.add(Restrictions.eq("year", year));
            result = criteria.list();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public List<Whisky> findWhiskyByDistilleryAndAge(String distilleryName, int age) {
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria criteria = session.createCriteria(Whisky.class);
            criteria.add(Restrictions.eq("distillery.getName()", distilleryName));
            result = criteria.list();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
        List<Whisky> whiskies = new ArrayList<Whisky>();
        for (Whisky whisky: result){
            if (whisky.getAge() == age){
                whiskies.add(whisky);
            }
        }
        return whiskies;
    }


}
