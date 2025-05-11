package net.twelvefourseven;

import java.util.ArrayList;
import java.util.List;

public class PropertySet {
    private final PropertyType type;
    private final List<PropertyCard> properties;

    public PropertySet(PropertyType type) {
        this.type = type;
        this.properties = new ArrayList<>();
    }

    public void addProperty(PropertyCard property) {
        if (property.getType() == this.type) {
            properties.add(property);
        } else {
            throw new IllegalArgumentException("Property type mismatch.");
        }
    }

    public boolean isComplete() {
        return properties.size() == type.getRequiredPropertiesCount();
    }

    public int getRentAmount() {
        return type.getRentAmount(properties.size());
    }

    public PropertyType getType() {
        return type;
    }

    public List<PropertyCard> getProperties() {
        return properties;
    }
}
