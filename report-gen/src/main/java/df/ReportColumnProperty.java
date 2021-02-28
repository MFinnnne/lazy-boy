package df;

/**
 * @author MFine
 * @version 1.0
 * @date 2021/2/28 16:28
 **/
public class ReportColumnProperty {

    private String prop;
    private String label;

    public ReportColumnProperty() {
    }

    public ReportColumnProperty(String prop, String label) {
        this.prop = prop;
        this.label = label;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
