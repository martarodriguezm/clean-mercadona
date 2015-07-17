package marta.rodriguez.mercadonaapp.mercadona.interactors;

import java.util.List;

import marta.rodriguez.mercadonaapp.mercadona.api.ApiaryClient;
import marta.rodriguez.mercadonaapp.mercadona.model.Supermarket;

/**
 * Created by martarodriguez on 9/7/15.
 */
public class SupermarketsInteractor {

    public SupermarketsInteractor() {

    }

    public List<Supermarket> getSupermarkets() {
        return ApiaryClient.getSupermarketsApiClient().getSupermarkets("madrid");
    }
}
