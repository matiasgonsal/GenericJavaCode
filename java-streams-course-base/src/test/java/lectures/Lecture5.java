package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    //Filter the red cars:
    List<Car> filteredCars = cars.stream()
            .filter(car -> car.getColor().equals("Red"))
            .collect(Collectors.toList());
    System.out.println(filteredCars);

    //Filter the red cars with return on predicate:
    List<Car> filteredCarsReturn = cars.stream()
            .filter(car -> {
              String filterColor = "Red";
              return car.getColor().equals(filterColor);
            })
            .collect(Collectors.toList());
    System.out.println(filteredCarsReturn);

    //Filter the red cars with a predicate defined as variable
    String filter = "Red";
    Predicate<Car> redCarsPredicate = (car -> {
      return car.getColor().equals(filter);
    });
    List<Car> filteredCarsPredicate = cars.stream().filter(redCarsPredicate).collect(Collectors.toList());
    System.out.println(filteredCarsPredicate);
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    List<String> peopleString = people.stream()
            .map(person -> person.toString()) //Transform each Person object to a String
            .collect(Collectors.toList());
    System.out.println(peopleString);

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    ImmutableList<Car> cars = MockData.getCars();
    Double priceAverage = cars.stream()
            .mapToDouble(car -> car.getPrice())
            .average()
            .orElse(0);
    System.out.println(priceAverage);
  }

  @Test
  public void test() throws Exception {

  }
}



