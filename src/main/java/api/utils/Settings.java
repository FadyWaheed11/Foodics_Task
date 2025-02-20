package api.utils;

import java.util.Properties;

import static file_handling.FileManager.readFromPropertiesFile;

public class Settings {

    private static final String configFilePath = "src/main/resources/config.properties";
    private static final Properties properties = readFromPropertiesFile(configFilePath);

    public static String baseUri(){
        return properties.getProperty("BASE_URL");
    }

    public static String endpoint(){
        return properties.getProperty("ENDPOINT");
    }

}
