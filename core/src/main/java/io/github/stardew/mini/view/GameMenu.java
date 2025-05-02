package io.github.stardew.mini.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import io.github.stardew.mini.StardewMini;
import io.github.stardew.mini.control.GameController;
import io.github.stardew.mini.model.game.GameModel;
import io.github.stardew.mini.view.game.GameMenuInputAdapter;
import io.github.stardew.mini.view.game.GameView;

public class GameMenu implements Screen {
    private GameView gameView;
    private GameModel gameModel;
    private GameMenuInputAdapter gameMenuInputAdapter;
    private GameController gameController;

    public GameMenu(GameController gameController) {
        this.gameController = gameController;
        initializeGame();
    }

    private void initializeGame() {
        gameModel = new GameModel(Gdx.graphics.getWidth()/StardewMini.SCALE, Gdx.graphics.getHeight()/StardewMini.SCALE);
        gameView = new GameView(gameModel);
        gameMenuInputAdapter = new GameMenuInputAdapter(gameModel, gameController);
        Gdx.input.setInputProcessor(gameMenuInputAdapter);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        gameMenuInputAdapter.update(delta);
        gameModel.update(delta);
        gameView.render();

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    // Other Screen methods
}
