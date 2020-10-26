import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class ObservableObserverExample1 {

    public static void main(String[] args) {

        //Producer of data... Observable...
        Observable<Integer> source = new ObservableCreate<Integer>(new ObservableOnSubscribe<Integer>() {
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                System.out.println("On Subscribe inside Observable producer...");
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
                emitter.onNext(5);
                emitter.onComplete();
            }
        });

        //Consumer of data.. observer
        Observer<Integer> observer1 = new Observer<Integer>() {

            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe method from observer 1");
            }

            public void onNext(@NonNull Integer integer) {
                System.out.println("OnNext from observer: " + integer);
            }

            public void onError(@NonNull Throwable e) {
                System.out.println("OnError from observer1");
            }

            public void onComplete() {
                System.out.println("OnComplete method from observer");
            }
        };

        //subscribe to the producer.. we connect an observer to the producer..
        source.subscribe(observer1);
    }
}
