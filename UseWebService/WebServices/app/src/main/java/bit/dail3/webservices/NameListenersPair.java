package bit.dail3.webservices;

/**
 * Created by dailifeng on 16/4/14.
 */
public class NameListenersPair {
    private String name;
    private String listeners;

    public NameListenersPair(String name, String listeners)
    {
        this.name = name;
        this.listeners = listeners;
    }

    public String getListeners() {
        return listeners;
    }

    public String getName() {
        return name;
    }
}
