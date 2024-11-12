package pattern;

public interface IObserver<T> {
    void onNext(T t);

    void onError(Throwable t);

    void onComplete();
}
