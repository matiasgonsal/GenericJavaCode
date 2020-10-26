import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class ObservableObserverExample3 {
    public static void main(String[] args) {
        Observable<String> source = new ObservableCreate<String>(emitter -> {
            emitter.onNext("data 1");
            emitter.onNext("data 2");
            emitter.onNext("data 3");
            emitter.onNext("data 4");
            emitter.onNext("data 5");
            emitter.onComplete();
        });

        source.subscribe(element -> System.out.println("OnNext: " + element),
                         error -> error.printStackTrace(),
                         () -> System.out.println("OnComplete received"));

    }
}
