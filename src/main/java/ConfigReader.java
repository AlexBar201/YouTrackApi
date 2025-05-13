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

    public String getEndPointTwo() {
        return properties.getProperty("api.andPointTwo");
    }

    public String getEndPointTwoQueryParamName() {
        return properties.getProperty("api.andPointTwo.queryParamName");
    }

    public String getEndPointTwoQueryParamValue() {
        return properties.getProperty("api.andPointTwo.queryParamValue");
    }

    public String getEndPointThree() {
        return properties.getProperty("api.andPointThree");
    }

    public String getEndPointThreeQueryParamNameOne() {
        return properties.getProperty("api.andPointThree.queryParamNameOne");
    }

    public String getEndPointThreeQueryParamValueOne() {
        return properties.getProperty("api.andPointThree.queryParamValueOne");
    }

    public String getEndPointThreeQueryParamNameTwo() {
        return properties.getProperty("api.andPointThree.queryParamNameTwo");
    }

    public String getEndPointThreeQueryParamValueTwo() {
        return properties.getProperty("api.andPointThree.queryParamValueTwo");
    }
}
