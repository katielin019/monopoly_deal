package net.twelvefourseven;

public class PropertyCard extends Card {
    private final String name;
    private final PropertyType type;

    public PropertyCard(String name, PropertyType type, int value) {
        super(value);
        this.name = name;
        this.type = type;
    }

    public PropertyType getType() {
        // return PropertyType.BROWN;
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + " (" + this.type.getAbbreviation() + ")";
    }
}
