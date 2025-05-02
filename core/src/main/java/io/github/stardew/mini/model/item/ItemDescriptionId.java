package io.github.stardew.mini.model.item;

// ItemDescriptionId.java
public enum ItemDescriptionId {
    CARROT(0, "carrot", 100, "game/crops/Carrot.png"),
    CARROT_SEED(1, "carrot-seed", 10, "game/crops/Carrot_Seeds.png"),
    WATERING_CAN(2, "watering-can", 20, "game/tools/watering_can.png"),
    HOE(3, "hoe", 30, "game/tools/hoe.png"),
    SCYTHE(3, "scythe", 30, "game/tools/scythe.png"),
    ;
    int id;
    String name;
    double value;
    String iconPath;

    private ItemDescriptionId(int id, String name, double value, String iconPath) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.iconPath = iconPath;
    }

    public String getIconPath() {
        return iconPath;
    }
}
