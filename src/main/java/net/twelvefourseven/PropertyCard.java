package net.twelvefourseven;

public class PropertyCard extends Card {
    private final String name;
    private final PropertyType type;

    public PropertyCard(int value, String name, PropertyType type) {
        super(value);
        this.name = name;
        this.type = type;
    }

    public PropertyType getType() {
        // // PLACEHOLDER
        // return PropertyType.BROWN;
        return this.type;
    }

    public String getName() {
        return this.name;
    }
}
