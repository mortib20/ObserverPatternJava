package pattern;

public interface IObservable<T> {
    public void subscribe(IObserver<T> observer);
    public void unsubscribe(IObserver<T> observer);
}