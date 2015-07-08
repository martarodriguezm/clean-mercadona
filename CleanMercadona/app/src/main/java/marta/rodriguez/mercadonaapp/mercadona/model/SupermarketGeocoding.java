package marta.rodriguez.mercadonaapp.mercadona.model;

/**
 * Created by marta.rodriguez on 27/06/14.
 */
public class SupermarketGeocoding {

    private long id;
    private String address;
    private double latitude;
    private double longitude;

    public SupermarketGeocoding() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
