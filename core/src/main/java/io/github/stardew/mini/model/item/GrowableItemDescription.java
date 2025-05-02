package io.github.stardew.mini.model.item;

import java.util.List;

public enum GrowableItemDescription {
    CARROT_SEED(PlaceableItemDescription.CARROT_SEED, List.of(2L, 2L, 2L))
    ;
    private PlaceableItemDescription placeableItemDescription;
    private List<Long> stages;

    private GrowableItemDescription(PlaceableItemDescription placeableItemDescription, List<Long> stages) {
        this.placeableItemDescription = placeableItemDescription;
        this.stages = stages;
    }
}
