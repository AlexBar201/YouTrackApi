import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getToken() {
        return properties.getProperty("api.token");
    }

    public static String getBaseUri() {
        return properties.getProperty("api.baseUri");
    }
}
