package io.github.stardew.mini.model.item;

// ItemDescription.java
public class ItemDescription {
    private ItemDescriptionId id;
    private String name;
    private double price;
    private String iconPath;

    public ItemDescription(ItemDescriptionId id, String name, double price, String iconPath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.iconPath = iconPath;
    }

    // Getters
}

