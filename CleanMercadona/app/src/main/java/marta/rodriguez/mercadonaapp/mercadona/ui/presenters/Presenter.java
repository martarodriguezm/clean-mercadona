package marta.rodriguez.mercadonaapp.mercadona.ui.presenters;

/**
 * Created by martarodriguez on 9/7/15.
 */
public abstract class Presenter<V> {

    private V view;

    public Presenter() {}

    public void attachView(V view) {
        this.view = view;
        onViewAttached();
    }

    public void detachView() {
        view = null;
    }

    public V getView() {
        return view;
    }

    public abstract void onViewAttached();
}
