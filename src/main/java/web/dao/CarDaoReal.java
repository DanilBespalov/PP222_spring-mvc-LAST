package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDaoReal implements CarDao {
    private int count = 0;
    private final List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car(++count, "Kia Shortage", "Black"));
        cars.add(new Car(++count, "Kia RioX", "Black"));
        cars.add(new Car(++count, "Kia K5", "Red"));
        cars.add(new Car(++count, "Kia Rio", "Green"));
        cars.add(new Car(++count, "Porsche", "Metal"));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count == 0) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
