package net.twelvefourseven;

public enum PropertyType {
    BROWN ("Brown", new int[]{1, 2}),
    DARK_BLUE ("Dark Blue", new int[]{3, 8}),
    GREEN ("Green", new int[]{2, 4, 7}),
    LIGHT_BLUE ("Light Blue", new int[]{1, 2, 3}),
    ORANGE ("Orange", new int[]{1, 3, 5}),
    PINK ("Pink", new int[]{1, 2, 4}),
    RAILROAD ("Railroad", new int[]{1, 2, 3, 4}),
    RED ("Red", new int[]{2, 3, 6}),
    UTILITY ("Utility", new int[]{1, 2}),
    YELLOW ("Yellow", new int[]{2, 4, 6});

    private final String name;
    private final int[] rentAmounts;
    
    PropertyType(String name, int[] rentAmounts) {
        this.name = name;
        this.rentAmounts = rentAmounts;
    }

    public String getName() {
        return name;
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
}
