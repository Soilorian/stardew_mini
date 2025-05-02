package io.github.stardew.mini.model.game;

import io.github.stardew.mini.model.Pair;
import io.github.stardew.mini.model.item.ItemDescriptionId;

import java.awt.*;
import java.util.*;

public class Player {
    private Map<ItemDescriptionId, Pair<Integer, Integer>> inventory;
    private ItemDescriptionId activeItem;
    private Pair<Float, Float> playerPosition;
    private Stack<Integer> freeIndexes;
    private final Integer maxInventorySize = 9;
    private int selectedInventoryIndex = -1;
    private int movingDirection = 0;

    public Player() {
        inventory = new HashMap<>();
        freeIndexes = new Stack<>();
        for (int i = maxInventorySize-1; i >= 0; i--) {
            freeIndexes.push(i);
        }
        playerPosition = new Pair<>(0f, 0f);
    }

    public void addItem(ItemDescriptionId itemId, int count) {
        Pair<Integer, Integer> pair = inventory.getOrDefault(itemId, new Pair<>(0, freeIndexes.pop()));
        pair.first = pair.first + count;
        inventory.put(itemId, pair);
    }

    public void useActiveItem(float worldX, float worldY) {
        // Implement item usage logic
    }

    public void move(float dx, float dy) {
        // Implement movement logic
    }

    public float getMovementSpeed() {
        return 200f; // pixels per second
    }

    public Pair<Float, Float> getPosition() {
        return playerPosition;
    }

    private float speed = 2f;
    private float vx = 0, vy = 0;

    public void setVelocity(float vx, float vy) {
        this.vx = vx;
        this.vy = vy;
    }

    public void update(float delta) {
        playerPosition.first += vx * delta;
        playerPosition.second += vy * delta;
    }


    public Map<ItemDescriptionId, Pair<Integer, Integer>> getInventory() {
        return inventory;
    }

    public void setSelectedInventoryIndex(int selectedSlot) {
        selectedInventoryIndex = selectedSlot;
    }

    public int getSelectedInventoryIndex() {
        return selectedInventoryIndex;
    }

    public ItemDescriptionId getSelectedItem() {
        return activeItem;
    }

    public int getMovingDirection() {
        return movingDirection;
    }

    public void setMovingDirection(int direction) {
        this.movingDirection = direction;
    }

    public int getMaxInventorySize() {
        return maxInventorySize;
    }

    public float getSpeed() {
        return speed;
    }
}

