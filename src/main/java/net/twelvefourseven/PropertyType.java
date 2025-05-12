package net.twelvefourseven;

import java.util.HashMap;
import java.util.Map;

public enum PropertyType {
    BROWN ("BR", new int[]{1, 2}),
    DARK_BLUE ("DB", new int[]{3, 8}),
    GREEN ("GR", new int[]{2, 4, 7}),
    LIGHT_BLUE ("LB", new int[]{1, 2, 3}),
    ORANGE ("OR", new int[]{1, 3, 5}),
    PINK ("PI", new int[]{1, 2, 4}),
    RAILROAD ("RR", new int[]{1, 2, 3, 4}),
    RED ("RE", new int[]{2, 3, 6}),
    UTILITY ("UT", new int[]{1, 2}),
    YELLOW ("YE", new int[]{2, 4, 6});

    private final String abbrev;
    private final int[] rentAmounts;
    private static final Map<String, PropertyType> lookup = new HashMap<>();
    
    PropertyType(String abbrev, int[] rentAmounts) {
        this.abbrev = abbrev;
        this.rentAmounts = rentAmounts;
    }

    static {
        for (PropertyType t : PropertyType.values()) {
            lookup.put(t.getAbbreviation(), t);
        }
    }

    public String getAbbreviation() {
        return abbrev;
    }

    public int getRequiredPropertiesCount() {
        return rentAmounts.length;
    }

    public int getRentAmount(int propertiesOwned) {
        if (propertiesOwned <= 0 || propertiesOwned > rentAmounts.length) {
            throw new IllegalArgumentException("Invalid number of properties owned for rent calculation.");
        }
        return rentAmounts[propertiesOwned - 1];
    }

    // https://stackoverflow.com/a/1080912
    public static PropertyType get(String abbrev) {
        return lookup.get(abbrev);
    }
}
