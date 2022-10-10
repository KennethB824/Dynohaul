package dyno.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

        //1 - Create properties object
        //we make this private to be inaccessible from outside
        //we make it static because static runs first and we will use this object under static method
        private static Properties properties = new Properties();

        //making it static block because static block runs first
        static {
            try {
                FileInputStream file = new FileInputStream("configuration.properties");
                properties.load(file);
            } catch (IOException e) {
                System.out.println("File not found in ConfigurationReader class");
                e.printStackTrace();
            }
        }

        public static String getProperty(String keyword){

            return properties.getProperty(keyword);
        }

}
