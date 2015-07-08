package marta.rodriguez.mercadonaapp.mercadona;

import android.app.Application;
import android.content.Context;

/**
 * Created by martarodriguez on 8/7/15.
 */
public class ApplicationConfig extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        final Context context = getApplicationContext();
    }
}
