package com.badlogic.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;	

public class inputBehaviour {
	//create an instance of inputBehaviour inside a class which requires input and call listenForInputs in render()
	public inputBehaviour() {
	}
	
	public void movement(Sprite sprite, int speed, int Up, int Down, int Left, int Right) {
		//arrow keys will be 19, 20, 21, 22 for Up Down Left Right respectively (for movements)
		//WASD keys will be 51, 46, 29, 32 for Up Down Left Right respectively (for movements)
		if (Gdx.input.isKeyPressed(Left)) {
			sprite.translateX(-speed);
		}
		if (Gdx.input.isKeyPressed(Right)) {
			sprite.translateX(speed);
		}
		if (Gdx.input.isKeyPressed(Up)) {
			sprite.translateY(speed);
		}
		if (Gdx.input.isKeyPressed(Down)) {
			sprite.translateY(-speed);
		}
	}
	
	
	public void listenForInputs(Sprite sprite, int speed, int Up, int Down, int Left, int Right) {
		if (Gdx.input.isKeyJustPressed(66)) {
			// Enter Button
			// insert code to be executed here
		}
		if (Gdx.input.isKeyJustPressed(111)) {
			// Escape Button
			// insert code to be executed here
		}
		if (Gdx.input.isKeyJustPressed(33)) {
			// E button
			//insert code to be executed here
		}
		//can insert as many as wanted 
	}
	
	
}
