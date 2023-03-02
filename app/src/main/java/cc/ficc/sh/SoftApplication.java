package cc.ficc.sh;

import android.app.Application;

public class SoftApplication extends Application {
    private static SoftApplication INSTANCE;

    public static SoftApplication getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
