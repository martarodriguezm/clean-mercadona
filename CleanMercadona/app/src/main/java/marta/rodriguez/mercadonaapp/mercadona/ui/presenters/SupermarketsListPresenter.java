package marta.rodriguez.mercadonaapp.mercadona.ui.presenters;

import marta.rodriguez.mercadonaapp.mercadona.ui.views.SupermarketsListView;

/**
 * Created by martarodriguez on 9/7/15.
 */
public class SupermarketsListPresenter extends Presenter<SupermarketsListView> {

    public SupermarketsListPresenter() {

    }

    @Override
    public void onViewAttached() {
        getView().initUi();
    }

    public void getSupermarkets() {

    }
}
