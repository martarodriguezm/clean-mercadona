package marta.rodriguez.mercadonaapp.mercadona.interactors;

import marta.rodriguez.mercadonaapp.mercadona.interactors.listeners.BaseListener;

/**
 * Created by martarodriguez on 10/7/15.
 */
public abstract class InteractorBase {

    public abstract void executeUseCase(BaseListener listener);
}
