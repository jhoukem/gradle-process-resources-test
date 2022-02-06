import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class AppProperties extends Properties {

    private static final AppProperties APP_PROPERTIES = new AppProperties();
    private static final String APP_PROPERTIES_PATH = "/app.properties";
    private static final String PRODUCTION_KEY = "production";

    private AppProperties() {
        try {
            InputStream propertiesStream = AppProperties.class.getResourceAsStream(APP_PROPERTIES_PATH);
            if (propertiesStream == null) {
                System.err.println("Application properties file not found. Using default value instead.");
            } else {
                load(propertiesStream);
            }
        } catch (IOException e) {
            System.err.println("Could not load the app property file" + e);
        }
    }

    public static boolean isProduction() {
        return Boolean.parseBoolean(APP_PROPERTIES.getProperty(PRODUCTION_KEY, "false"));
    }

}
