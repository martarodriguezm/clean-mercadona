package marta.rodriguez.mercadonaapp.mercadona.interactors.listeners;

/**
 * Created by martarodriguez on 10/7/15.
 */
public interface BaseListener <T> {

    void onSuccess(T result);
    void showError();
}
