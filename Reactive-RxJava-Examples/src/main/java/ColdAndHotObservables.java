import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class ColdAndHotObservables {
    public static void main(String[] args) {

        //Cold Observable example
        executeColdObservable();
    }


    public static void executeColdObservable (){
        //Cold observable example:
        //List of integer as the data...
        List<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
        elements.add(4);
        elements.add(5);

        //Observable creation from the list
        Observable<Integer> source = Observable.fromIterable(elements);
        //Subscription
        System.out.println("First subscription elements: ");
        source.subscribe(element -> System.out.print(element + " ")); //First subscription

        //New data added to the list
        elements.add(6);
        elements.add(7);
        elements.add(8);
        elements.add(9);
        elements.add(10);

        System.out.println("");
        System.out.println("Second subscription elements: ");
        source.subscribe(element -> System.out.print(element + " ")); //Second subscription
        //Every new subscription will get the old and new data from the list that was modified after
        //the creation of the observable
        //Every new subscription runs the data from the first element to the end..
    }
    public static void executeHotObservable (){

    }
}
