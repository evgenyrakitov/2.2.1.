package hiber.service;


import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiseImp implements CarServise{

    @Autowired
    CarDao carDao;

    @Transactional
    @Override
    public void addCar(Car car) {
        carDao.addCar(car);
    }

    @Transactional
    @Override
    public User getUserByNameBySeries(String name, String series) {
        return carDao.getUserByNameBySeries(name, series);

    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCar() {
        return carDao.listCar();
    }
}
