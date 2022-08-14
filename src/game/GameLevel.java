/**
 * @author Yuval Dahari
 * 209125939
 */

package game;

import animation.AnimationRunner;
import animation.CountdownAnimation;
import animation.KeyPressStoppableAnimation;
import animation.PauseScreen;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import common.Counter;
import common.SpriteCollection;
import elements.Ball;
import elements.Block;
import elements.Paddle;
import elements.ScoreIndicator;
import geometric.Point;
import geometric.Rectangle;
import interfaces.Animation;
import interfaces.Collidable;
import interfaces.LevelInformation;
import interfaces.Sprite;
import levels.NameLevel;
import listeners.BallRemover;
import listeners.BlockRemover;
import listeners.ScoreTrackingListener;

import java.awt.Color;
import java.util.List;

/**
 * Class which managers the game.Game.
 */

public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter blocksCounter;
    private Counter ballsCounter;
    private Counter scoresCounter;
    private AnimationRunner runner;
    private Paddle paddle;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;
    private ScoreTrackingListener scoreTrackingListener;
    private List<Ball> ballList;
    private List<Block> blocksList;
    private String levelName;

    //Const numbers for set the borderlines proportions.
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final double LIMIT_SCREEN_SIZE = 15;

    /**
     * The function create new GameLevel.
     */
    public GameLevel() {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
    }

    /**
     * The function create new GameLevel.
     * @param level (LevelInformation)
     * @param gui (GUI)
     * @param scoresCounter (Counter)
     * @param runner (AnimationRunner)
     */
    public GameLevel(LevelInformation level, GUI gui, Counter scoresCounter, AnimationRunner runner) {
        this.gui = gui;
        this.keyboard = gui.getKeyboardSensor();
        this.scoresCounter = scoresCounter;
        this.runner = runner;
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.paddle = new Paddle(new Block(level.getPaddleRectangle(), level.getPaddleColor()), this.keyboard,
                level.getPaddleWidth());
        this.ballsCounter = new Counter(level.numberOfBalls());
        this.blocksCounter = new Counter(level.blocks().size());
        this.ballList = level.getBallsList();
        this.blocksList = level.blocks();
        this.levelName = level.levelName();
        this.sprites.addSprite(level.getBackground());
        this.scoreTrackingListener = new ScoreTrackingListener(this.scoresCounter);
    }

    /**
     * The function adds new collidable to collidables' list.
     *
     * @param c (interfaces.Collidable)
     */
    public void addCollidable(Collidable c) {
        this.getEnvironment().addCollidable(c);
    }

    /**
     * The function adds new sprite to sprites' list.
     *
     * @param s (interfaces.Sprite)
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * The function initialize a new game.
     */
    public void initialize() {
        this.blockRemover = new BlockRemover(this, this.blocksCounter);
        this.ballRemover = new BallRemover(this, this.ballsCounter);
        wallsCreator();
        paddleCreator();
        scoreBoardCreator();
        nameLevelCreator();
        blockPatternsCreator();
        ballsCreator();
    }

    /**
     * The function creates the name level.
     */
    private void nameLevelCreator() {
        NameLevel nameLevel = new NameLevel(this.levelName);
        this.sprites.addSprite(nameLevel);
    }

    /**
     * The function creates the paddle.
     */
    private void paddleCreator() {
        this.paddle.setKeyboard(this.keyboard);
        this.paddle.addToGame(this);
    }

    /**
     * The function creates the score boards pattern.
     */
    private void scoreBoardCreator() {
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.scoresCounter);
        this.sprites.addSprite(scoreIndicator);
    }

    /**
     * The function creates the walls pattern.
     */
    private void wallsCreator() {
        Rectangle up = new Rectangle(new Point(0, 0), WIDTH, LIMIT_SCREEN_SIZE * 2);
        Block blockUp = new Block(up, Color.DARK_GRAY);
        blockUp.addToGame(this);
        Rectangle down = new Rectangle(new Point(0, HEIGHT), WIDTH * 2, LIMIT_SCREEN_SIZE * 2);
        Block blockDown = new Block(down, Color.GRAY);
        blockDown.addToGame(this);
        BallRemover ballRemover = new BallRemover(this, ballsCounter);
        blockDown.addHitListener(ballRemover);
        Rectangle left = new Rectangle(new Point(0 - LIMIT_SCREEN_SIZE, 0), LIMIT_SCREEN_SIZE, HEIGHT);
        Block blockLeft = new Block(left, Color.GRAY);
        blockLeft.addToGame(this);
        Rectangle right = new Rectangle(new Point(WIDTH, 0), WIDTH, HEIGHT);
        Block blockRight = new Block(right, Color.GRAY);
        blockRight.addToGame(this);
    }

    /**
     * The function creates the blocks pattern.
     */
    private void blockPatternsCreator() {
        for (Block block : this.blocksList) {
            block.addHitListener(this.blockRemover);
            block.addHitListener(this.scoreTrackingListener);
            block.addToGame(this);
        }
    }

    /**
     * The function creates the balls pattern.
     */
    private void ballsCreator() {
        for (Ball b : this.ballList) {
            b.addToGame(this);
            b.setGameEnvironment(this.environment);
        }
        this.ballRemover = new BallRemover(this, this.ballsCounter);
    }

    /**
     * The function return the valve of the gameEnvironment.
     *
     * @return game.GameEnvironment - the valve of the gameEnvironment.
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     * The function return the valve of the keyboardSensor.
     *
     * @return game.KeyboardSensor - the valve of the keyboardSensor.
     */
    public KeyboardSensor getKeyboard() {
        return keyboard;
    }

    /**
     * The function return the number of the remaining balls in the game.
     *
     * @return int - the number of the remaining balls in the game.
     */
    public int getNumOfRemainingBalls() {
        return this.ballsCounter.getValue();
    }

    /**
     * The function sets new gameEnvironment.
     *
     * @param environment - (game.GameEnvironment)
     */
    public void setEnvironment(GameEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public boolean shouldStop() {
        return !(this.blocksCounter.getValue() > 0 && this.ballsCounter.getValue() > 0);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                    new PauseScreen(this.keyboard)));
        }
        if (this.blocksCounter.getValue() == 0) {
            this.scoresCounter.increase(100);
        }
    }

    /**
     * The function runs the game by starting the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(this.sprites));
        this.running = true;
        this.runner.run(this);
    }

    /**
     * The function remove collidable object from the collidable list in the game environment.
     *
     * @param c (interfaces.Collidable)
     */
    public void removeCollidable(Collidable c) {
        this.environment.getCollidableList().remove(c);
    }

    /**
     * The function remove sprite object from the sprite list.
     *
     * @param s (interfaces.Sprite)
     */
    public void removeSprite(Sprite s) {
        this.sprites.getSpriteList().remove(s);
    }

}