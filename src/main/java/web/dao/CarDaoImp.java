package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class CarDaoImp implements CarDao {
    private int count = 0;
    private final List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car(++count, "Car1", "Color1"));
        cars.add(new Car(++count, "Car2", "Color2"));
        cars.add(new Car(++count, "eCar3", "Color3"));
        cars.add(new Car(++count, "eCar4", "Color4"));
        cars.add(new Car(++count, "Car5", "Color5"));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count == 0) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
