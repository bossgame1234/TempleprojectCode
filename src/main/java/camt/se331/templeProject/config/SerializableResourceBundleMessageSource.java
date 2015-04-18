package camt.se331.templeProject.config;


import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;
import java.util.Properties;

/**
 * Created by Dell on 17/3/2558.
 */
public class SerializableResourceBundleMessageSource  extends ReloadableResourceBundleMessageSource{
    public Properties getAllProperties(Locale locale){
        clearCacheIncludingAncestors();
        PropertiesHolder propertiesHolder = getMergedProperties(locale);
        Properties properties = propertiesHolder.getProperties();

        return properties;
    }
}
