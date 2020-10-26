import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class ObservableObserverExample2 {
    public static void main(String[] args) {
        //Same producer as the previous example with Lambda.
        Observable<String> source = new ObservableCreate<String>(emitter -> {
            emitter.onNext("data 1");
            emitter.onNext("data 2");
            emitter.onNext("data 3");
            emitter.onNext("data 4");
            emitter.onNext("data 5");
            emitter.onComplete();
        });

        Observer<String> observer1 = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("OnSubscribe from observer 1");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("OnNext from observer1: " + s);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("OnError from observer 1");
            }

            @Override
            public void onComplete() {
                System.out.println("OnComplete from observer 1");
            }
        };

        source.subscribe(observer1);
    }
}
