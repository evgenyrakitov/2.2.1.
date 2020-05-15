package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarServise;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarServise carServise = context.getBean(CarServise.class);

      Car car1 = new Car("1", "1");
      Car car2 = new Car("2", "2");
      carServise.addCar(car1);
      carServise.addCar(car2);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      user1.setCar(car1);
      car1.setUser(user1);
      user2.setCar(car2);
      car2.setUser(user2);

      userService.add(user1);
      userService.add(user2);
      //userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      //userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      System.out.println("FirstName = " + carServise.getUserByNameBySeries("1", "1").getFirstName()
                  + "\nLastName = " + carServise.getUserByNameBySeries("1", "1").getLastName());



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar().getName());
         System.out.println();
      }

      List<Car> cars = carServise.listCar();
      for (Car car : cars) {
         System.out.println("Id = " + car.getId());
         System.out.println("Name = " + car.getName());
         System.out.println("Series = " + car.getSeries());
         System.out.println("User = " + car.getUser().getFirstName());
         System.out.println();
      }

      context.close();
   }
}
