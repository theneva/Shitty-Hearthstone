package fu.bar;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Configurator
{
    private static Configurator instance;

    public static Configurator getInstance() {
        if (instance == null) {
            instance = new Configurator("src/main/resources/cards.properties");
        }

        return instance;
    }

    public Map<String, String> properties = new HashMap<>();

    private Configurator(final String pathToPropertiesFile)
    {
        final File file = new File(pathToPropertiesFile);

        try
        {
            final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                final String[] lineAsArray = line.replaceAll(" ", "").split("=");

                final String key = lineAsArray[0];
                final String value = lineAsArray[1];

                properties.put(key, value);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public String getProperty(final String key) {
        return properties.get(key);
    }

    public int getIntProperty(final String key) {
        return Integer.valueOf(properties.get(key));
    }
}
