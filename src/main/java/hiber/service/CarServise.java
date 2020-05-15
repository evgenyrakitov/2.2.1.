package hiber.service;

import hiber.model.Car;
import hiber.model.User;


import java.util.List;

public interface CarServise {
    void addCar(Car car);
    User getUserByNameBySeries(String name, String series);
    List<Car> listCar();
}
