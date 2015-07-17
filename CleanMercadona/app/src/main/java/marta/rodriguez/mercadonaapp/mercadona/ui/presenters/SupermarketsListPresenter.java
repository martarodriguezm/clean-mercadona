package marta.rodriguez.mercadonaapp.mercadona.ui.presenters;

import java.util.List;

import marta.rodriguez.mercadonaapp.mercadona.interactors.SupermarketsInteractor;
import marta.rodriguez.mercadonaapp.mercadona.ui.views.SupermarketsListView;

/**
 * Created by martarodriguez on 9/7/15.
 */
public class SupermarketsListPresenter extends Presenter<SupermarketsListView> {

    SupermarketsInteractor interactor;

    public SupermarketsListPresenter(SupermarketsInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void onViewAttached() {
        getView().initUi();
    }

    public void getSupermarkets() {
        new Thread() {
            @Override
            public void run() {
                List supermarkets = interactor.getSupermarkets();
                if(supermarkets != null) {
                    getView().showSupermarkets(supermarkets);
                } else {
                    getView().showError();
                }
            }
        }.start();
    }
}
