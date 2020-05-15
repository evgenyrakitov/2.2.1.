package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarDao {

    void addCar(Car car);

    User getUserByNameBySeries(String name, String series);
    List <Car> listCar();

}
