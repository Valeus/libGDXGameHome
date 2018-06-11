package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;


public class JolteonActor extends Actor {


    Sprite sprite = new Sprite(new Texture(Gdx.files.internal("JolteonImages/Jolteon01.png")));
    int x = 0;
    int y = 250;
    TextureAtlas textureAtlas;
    Rectangle rect = new Rectangle(getX(), getY(), getWidth(), getHeight());
    Animation<TextureRegion> stillAnimation;
    MoveToAction moveToAction = new MoveToAction();
    float timeForStill = 0.0f;
    float timeforMove = 0.0f;

    public JolteonActor(){

        sprite = new Sprite(new Texture(Gdx.files.internal("JolteonImages/Jolteon01.png")));
        textureAtlas = new TextureAtlas(Gdx.files.internal("JolteonSpriteSheet/JolteonAtlas.atlas"));

        stillAnimation = new Animation(1 / 10f, textureAtlas.getRegions());

        setX(x);
        setY(y);
        setBounds(getX(), getY(), sprite.getWidth(), sprite.getHeight());
        moveToAction.setPosition(1441f, getY());
        moveToAction.setDuration((float) (Math.random() * 8) + 4);
        addAction(moveToAction);


    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        timeForStill += Gdx.graphics.getDeltaTime();
        batch.draw(stillAnimation.getKeyFrame(timeForStill, true), getX(), getY());
    }

    @Override
    protected void positionChanged() {
        super.positionChanged();
    }

    public Rectangle getRectangle() {
        return rect;
    }

    public MoveToAction getAction() {
        return moveToAction;
    }

}