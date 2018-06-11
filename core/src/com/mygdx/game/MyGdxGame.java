package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {

    SpriteBatch batch;
    Texture img;
    TextureAtlas textureAtlas;
    TextureRegion textureRegion;
    Sprite sprite;
    Animation<TextureRegion> stillAnimation;
    Animation movingAnimation;
    float timeForStill = 0.0f;
    Rectangle rectangle;
    ArrayList<JolteonActor> jolteonActors = new ArrayList<JolteonActor>();
    Stage stage;
    boolean isChosen = false;
    boolean isVisible = true;
    boolean isMade = false;
    boolean caught = false;
    BitmapFont bitmapFont;
    int y = 0;
    int score = 0;
    int frame = 1;


    @Override
    public void create() {

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        JolteonActor jolteonActor = new JolteonActor();
        stage.addActor(jolteonActor);

        Gdx.input.setInputProcessor(stage);

        textureAtlas = new TextureAtlas(Gdx.files.internal(" JolteonSpriteSheet/JolteonAtlas.atlas"));
        textureRegion = textureAtlas.findRegion("Jolteon1");
        sprite = new Sprite(textureRegion);
        sprite.setPosition(-100,0);
        sprite.setSize(1600, 2500);
        bitmapFont = new BitmapFont();
        bitmapFont.getData().setScale(8f);


    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.49411764705f, 0.80784313725f, 0.02352941176f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        timeForStill += Gdx.graphics.getDeltaTime();
        batch.draw(stillAnimation.getKeyFrame(timeForStill, true), 0, 0);

        sprite.setRegion(textureAtlas.findRegion("Jolteon" + Integer.toString(frame)));

        frame++;
        if (frame == 4)
            frame = 0;
        if (!isVisible) {
            for (int i = 0; i < jolteonActors.size(); i++) {
                if (jolteonActors.get(i).getX() > 1440) {
                    jolteonActors.remove(i);
                    jolteonActors.add(new JolteonActor());
                    stage.addActor(jolteonActors.get(jolteonActors.size() - 1));
                }
            }
            for (int i = 0; i < jolteonActors.size(); i++) {
                if (jolteonActors.get(i).getX() >= 1200 && jolteonActors.get(i).getX() <= 1205 && jolteonActors.get(i).getY() >= y && jolteonActors.get(i).getY() <= (y + 150)) {
                    caught = true;
                }
            }
        }

        if(isChosen){
            if(caught){
                score++;
                caught=false;
            }else {
                batch.draw(stillAnimation.getKeyFrame(timeForStill, true), 1200, y);
            }
        }

        bitmapFont.draw(batch, score + "", 720, 2000);

        batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }

}