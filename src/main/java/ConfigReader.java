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

    public String getToken() {
        return properties.getProperty("api.token");
    }

    public String getBaseUri() {
        return properties.getProperty("api.baseUri");
    }

    public String getEndPointOne() {
        return properties.getProperty("api.andPointOne");
    }

    public String getEndPointOneQueryParamName() {
        return properties.getProperty("api.andPointOne.queryParamName");
    }

    public String getEndPointOneQueryParamValue() {
        return properties.getProperty("api.andPointOne.queryParamValue");
    }
}
