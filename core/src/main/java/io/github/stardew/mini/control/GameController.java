package io.github.stardew.mini.control;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import io.github.stardew.mini.StardewMini;
import io.github.stardew.mini.model.game.Player;
import io.github.stardew.mini.model.item.ItemDescriptionId;
import io.github.stardew.mini.view.GameMenu;

import java.awt.*;

// 6. Enhanced Game Controller
public class GameController {
    private boolean escapePressed = false;
    private final StardewMini game;
    private final MainController mainController;
    private GameMenu gameMenu;

    public GameController(StardewMini game, MainController mainController) {
        this.game = game;
        this.mainController = mainController;
    }

    public void init() {
        gameMenu = new GameMenu(this);
    }

    public void run() {
        game.setScreen(gameMenu);
    }

    public void goToMain() {
        gameMenu.dispose();
        mainController.run();
    }

    public void useItem(Player player, ItemDescriptionId selectedItem, Point point) {

    }
}
