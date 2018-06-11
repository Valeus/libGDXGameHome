package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    /*TextureAtlas textureAtlas;
    TextureRegion textureRegion;
    Sprite sprite;
    Animation<TextureRegion> stillAnimation;
    Animation movingAnimation;
    float timeForStill = 0.0f;*/
    Stage stage;



    @Override
    public void create () {
        /*batch = new SpriteBatch();
        textureAtlas = new TextureAtlas(Gdx.files.internal("JolteonSpriteSheet/JolteonAtlas.atlas"));
        textureRegion = textureAtlas.findRegion("Jolteon1");
        sprite = new Sprite(textureRegion);
        sprite.setPosition(Gdx.graphics.getWidth()/2-sprite.getWidth(),Gdx.graphics.getHeight()/2-sprite.getHeight());
        stillAnimation = new Animation(1/10f,textureAtlas.getRegions());*/

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        JolteonActor jolteonActor = new JolteonActor();
        stage.addActor(jolteonActor);

        Gdx.input.setInputProcessor(stage);
        JolteonActor jolt1 = new JolteonActor();
        jolt1.setName("1");
        JolteonActor jolt2 = new JolteonActor();
        jolt2.setName("2");
        JolteonActor jolt3 = new JolteonActor();
        jolt3.setName("3");

        jolt1.setSprite((float)(Math.random()*getScreenWidth()),(float)(Math.random()*getScreenHeight()), jolt1.getWidth(), jolt1.getHeight());
        jolt2.setSprite((float)(Math.random()*getScreenWidth()),(float)(Math.random()*getScreenHeight()), jolt2.getWidth(), jolt2.getHeight());
        jolt3.setSprite((float)(Math.random()*getScreenWidth()),(float)(Math.random()*getScreenHeight()), jolt3.getWidth(), jolt3.getHeight());


        stage.addActor(jolt1);
        stage.addActor(jolt2);
        stage.addActor(jolt3);



    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0.49411764705f, 0.80784313725f, 0.02352941176f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        /*batch.begin();

        timeForStill += Gdx.graphics.getDeltaTime();
        batch.draw(stillAnimation.getKeyFrame(timeForStill,true),0,0);


        batch.end();*/
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose () {
        //batch.dispose();
        stage.dispose();
        img.dispose();
    }

    public float getScreenWidth(){
        return stage.getWidth();
    }

    public float getScreenHeight(){
        return stage.getHeight();
    }
}