package marta.rodriguez.mercadonaapp.mercadona.ui.presenters;

import marta.rodriguez.mercadonaapp.mercadona.interactors.InteractorBase;
import marta.rodriguez.mercadonaapp.mercadona.interactors.listeners.BaseListener;
import marta.rodriguez.mercadonaapp.mercadona.ui.views.SupermarketsListView;

/**
 * Created by martarodriguez on 9/7/15.
 */
public class SupermarketsListPresenter extends Presenter<SupermarketsListView> implements BaseListener {

    InteractorBase interactor;

    public SupermarketsListPresenter(InteractorBase interactor) {
        this.interactor = interactor;
    }

    @Override
    public void onViewAttached() {
        getView().initUi();
    }

    public void getSupermarkets() {
        interactor.executeUseCase(this);
    }

    @Override
    public void showError() {

    }
}
