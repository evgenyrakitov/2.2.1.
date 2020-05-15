package hiber.dao;


import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao{

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override

    public User getUserByNameBySeries(String name, String series) {
        User user =  sessionFactory.getCurrentSession().createQuery("select car.user from Car car where car.name=:thisName and car.series=:thisSeries", User.class)
                .setParameter("thisName", name)
                .setParameter("thisSeries", series)
                .uniqueResult();


        return user;
    }

    @Override
    public List<Car> listCar() {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }
}
