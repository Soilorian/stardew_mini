package io.github.stardew.mini.model.item;

import java.util.ArrayList;
import java.util.List;

// PlaceableItemDescription.java
public enum PlaceableItemDescription {
    CARROT_SEED(ItemDescriptionId.CARROT_SEED, List.of(TileDescriptionId.SOIL))
    ;
    private ItemDescriptionId id;
    private List<TileDescriptionId> placeableOn;

    private PlaceableItemDescription(ItemDescriptionId id, List<TileDescriptionId> placeableOn) {
        this.id = id;
        this.placeableOn = placeableOn;
    }
}
