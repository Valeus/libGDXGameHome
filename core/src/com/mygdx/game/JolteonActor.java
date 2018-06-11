package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;


public class JolteonActor extends Actor {


    Sprite sprite = new Sprite(new Texture(Gdx.files.internal("JolteonImages/Jolteon01.png")));

    public JolteonActor(){

        //setBounds(getWidth(),0f,sprite.getWidth(),sprite.getHeight());

        setTouchable(Touchable.enabled);
        MoveToAction moveaction = new MoveToAction();

        moveaction.setPosition(getWidth(),0f);
        moveaction.setDuration(5f);
        addAction(moveaction);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        //setBounds(x,y,sprite.getWidth(),sprite.getHeight());
        //if (move)
        //    x++;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        //batch.draw(texture,x,y);
        sprite.draw(batch);
    }

    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(),getY());
        super.positionChanged();
    }

    public void setSprite(float x, float y, float w, float h) {
        sprite.setBounds(x,y,w,h);
    }

}