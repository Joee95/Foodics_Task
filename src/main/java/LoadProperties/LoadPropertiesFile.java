package LoadProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadPropertiesFile {

    public static Properties userdata = LoadProperties(System.getProperty("user.dir") + "\\src\\main\\java\\Data\\userdata.properties");

    private static Properties LoadProperties(String path) {
        Properties properties = new Properties();
        try {
            FileInputStream stream = new FileInputStream(path);
            properties.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("Error!");
        } catch (IOException e) {
            System.out.println("Error!");
        }

        return properties;
    }
}
