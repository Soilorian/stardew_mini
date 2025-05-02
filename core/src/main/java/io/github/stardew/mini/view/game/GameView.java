package io.github.stardew.mini.view.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Array;
import io.github.stardew.mini.StardewMini;
import io.github.stardew.mini.model.Pair;
import io.github.stardew.mini.model.game.GameModel;
import io.github.stardew.mini.model.game.Player;
import io.github.stardew.mini.model.item.ItemDescriptionId;
import io.github.stardew.mini.model.item.TileDescriptionId;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameView {
    private final GameModel game;
    private SpriteBatch batch;
    private TextureRegion[][] tileTextures;
    private Map<String, TextureRegion> textures;
    private BitmapFont font;
    private GlyphLayout layout = new GlyphLayout();
    private TextureAtlas playerAtlas;
    private final ArrayList<Animation<TextureRegion>> playerAnimations = new ArrayList<>();
    private float stateTime = 0f;
    private int moveDirection = 0;

    private void loadFont() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/stardew-valley.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 16;
        font = generator.generateFont(parameter);
        generator.dispose();
    }

    public GameView(GameModel game) {
        this.game = game;
        batch = new SpriteBatch();
        loadTextures();
        loadFont();
    }

    private void loadTextures() {
        textures = new HashMap<>();

        for (TileDescriptionId id : TileDescriptionId.values()) {
            String path = id.getIconPath();
            textures.put(id.name(), new TextureRegion(new Texture(Gdx.files.internal(path))));
        }

        playerAtlas = new TextureAtlas(Gdx.files.internal("game/character/sprites_player.atlas"));

        for (int i = 14; i > 9; i--) {
            Array<TextureRegion> walkFrames = new Array<>();
            if (i == 14) {
                for (int j = 0; j < 4; j++) {
                    String region = "player_" + 13 + "_" + 0;
                    walkFrames.add(playerAtlas.findRegion(region));
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    String region = "player_" + i + "_" + j;
                    walkFrames.add(playerAtlas.findRegion(region));
                }
            }
            playerAnimations.add(new Animation<>(0.15f, walkFrames, Animation.PlayMode.LOOP));
        }
    }


    public void render() {
        batch.setProjectionMatrix(game.getCamera().combined);
        batch.begin();
        renderTiles();
        renderPlayer();
        batch.end();
    }

    private void renderTiles() {
        TileDescriptionId[][] tiles = game.getTiles(); // make sure you expose this

        float camX = game.getCamera().position.x;
        float camY = game.getCamera().position.y;
        float viewportWidth = game.getCamera().viewportWidth;
        float viewportHeight = game.getCamera().viewportHeight;

        int tileSize = StardewMini.SCALE;

        int startX = Math.max(0, (int) ((camX - viewportWidth / 2) / tileSize));
        int startY = Math.max(0, (int) ((camY - viewportHeight / 2) / tileSize));
        int endX = Math.min(tiles.length, (int) ((camX + viewportWidth / 2) / tileSize) + 1);
        int endY = Math.min(tiles[0].length, (int) ((camY + viewportHeight / 2) / tileSize) + 1);

        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) {
                TileDescriptionId id = tiles[x][y];
                if (id != null) {
                    TextureRegion texture = textures.get(id.name());
                    if (texture != null) {
                        batch.draw(texture, x * tileSize, y * tileSize, tileSize, tileSize);
                    }
                }
            }
        }
    }


    private void renderPlayer() {
        Pair<Float,Float> pos = game.getPlayer().getPosition();

        moveDirection = game.getPlayer().getMovingDirection();

        stateTime += Gdx.graphics.getDeltaTime();

        Animation<TextureRegion> currentAnimation = playerAnimations.get(moveDirection);
        TextureRegion currentFrame = currentAnimation.getKeyFrame(stateTime, true);

        batch.draw(currentFrame, pos.first * StardewMini.SCALE, pos.second * StardewMini.SCALE, 32, 64);
        renderInventory();
    }


    private void renderInventory() {
        Player player = game.getPlayer();
        Map<ItemDescriptionId, Pair<Integer, Integer>> inventory = player.getInventory();
        int screenWidth = Gdx.graphics.getWidth();
        int slotSize = 32;
        int startX = (screenWidth - player.getMaxInventorySize() * slotSize) / 2;
        int y = 10;

        for (Map.Entry<ItemDescriptionId, Pair<Integer, Integer>> entry : inventory.entrySet()) {
            ItemDescriptionId id = entry.getKey();
            int quantity = entry.getValue().first;
            int index = entry.getValue().second;

            TextureRegion itemTex = textures.get(id.getIconPath());
            if (itemTex != null) {
                int x = startX + index * slotSize;
                batch.draw(itemTex, x, y, slotSize, slotSize);

                // Draw item quantity at bottom-right corner of slot
                String count = String.valueOf(quantity);
                layout.setText(font, count);
                font.draw(batch, count, x + slotSize - layout.width - 2, y + layout.height + 2);
            }
        }
    }

}
