package marta.rodriguez.mercadonaapp.mercadona.ui.views;

import java.util.List;

import marta.rodriguez.mercadonaapp.mercadona.model.Supermarket;

/**
 * Created by martarodriguez on 9/7/15.
 */
public interface SupermarketsListView {
    void initUi();
    void showSupermarkets(List<Supermarket> supermarkets);
    void showError();
}
