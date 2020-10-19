package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
  public void parallelStreams() throws Exception {
    //Calculate the same execution time with regular an parallel streams.
    System.out.println("Current Machine Processors: " + Runtime.getRuntime().availableProcessors());
    long initTime = System.currentTimeMillis();
    int result = 0;
    int result2 = 0;

    for (int i = 0; i < 20; i++) {
      result = IntStream.rangeClosed(0, 100001)
              .sum();
    }

    long endTime = System.currentTimeMillis();

    System.out.println("Sum operation on a Stream: " + result);
    System.out.println("Execution time: " + (endTime - initTime));

    initTime = System.currentTimeMillis();
    for (int i = 0; i < 20; i++) {
      result2 = IntStream.rangeClosed(0, 100000)
              .parallel()
              .sum();
    }
    endTime = System.currentTimeMillis();

    System.out.println("Sum operation on a Stream: " + result2);
    System.out.println("Execution time: " + (endTime - initTime));

  }

  @Test
  public void test() throws Exception {

  }
}



