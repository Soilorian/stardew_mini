package io.github.stardew.mini.model.item;

public class GrowingCrop {
    private final GrowableItemDescription growableItemDescription;
    private int growth;

    public GrowingCrop(GrowableItemDescription growableItemDescription) {
        this.growableItemDescription = growableItemDescription;
    }

    public void advance() {
        growth += 1;
    }
}
