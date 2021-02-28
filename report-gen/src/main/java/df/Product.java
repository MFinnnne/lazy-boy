package df;

/**
 * @author MFine
 * @version 1.0
 * @date 2021/2/28 1:21
 **/
public class Product {
    private String url;
    private String name;

    // As per the JavaBeans spec., this defines the "url" bean property
    // It must be public!
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // As per the JavaBean spec., this defines the "name" bean property
    // It must be public!
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
