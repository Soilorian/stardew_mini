package io.github.stardew.mini.model.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import io.github.stardew.mini.StardewMini;
import io.github.stardew.mini.model.item.GrowingCrop;
import io.github.stardew.mini.model.item.TileDescriptionId;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GameModel {
    private TileDescriptionId[][] tiles;
    private Map<Point, GrowingCrop> growingCrops;
    private Player player;
    private TimeSystem timeSystem;
    private final int width;
    private final int height;
    private OrthographicCamera camera; // Add camera field

    public GameModel(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new TileDescriptionId[width][height];
        initializeTiles();
        growingCrops = new HashMap<>();
        player = new Player();
        timeSystem = new TimeSystem();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, width*10, height*10);
    }

    private void initializeTiles() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (j < 5) {
                    tiles[i][j] = TileDescriptionId.WATER;
                } else {
                    tiles[i][j] = TileDescriptionId.GRASS;
                }
            }
        }
    }

    public void update(float deltaTime) {
        timeSystem.update(deltaTime);
        // Update crops and machines
    }

    public void advanceToNextDay() {
        growingCrops.forEach((point, growingCrop) -> {
            growingCrop.advance();
        });
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public Player getPlayer() {
        return player;
    }

    public TileDescriptionId[][] getTiles() {
        return tiles;
    }
}
