package marta.rodriguez.mercadonaapp.mercadona.repository;

import java.util.ArrayList;
import java.util.List;

import marta.rodriguez.mercadonaapp.mercadona.model.Supermarket;

/**
 * Created by martarodriguez on 9/7/15.
 */
public class SupermarketDataRepository implements SupermarketRepository {


    @Override
    public List<Supermarket> getSupermarkets() {
        return new ArrayList<>();
    }
}
