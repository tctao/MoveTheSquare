package edu.ycp.cs320.movethesquare.controllers;

import edu.ycp.cs320.movethesquare.model.Game;
import edu.ycp.cs320.movethesquare.model.Square;

public class GameController {
	public void computeSquareMoveDirection(Game game, Square square, double mouseX, double mouseY) {
		if (mouseX >= 0 && mouseX < game.getWidth() && mouseY >= 0 && mouseY < game.getHeight()) {
			double dx = mouseX - (square.getX() + square.getWidth()/2);
			double dy = mouseY - (square.getY() + square.getHeight()/2);
			
			// sqaure should no stop along the edges, given that the cursor is still in bounds.
			double moveX = 0, moveY = 0;
			if (dx > 0) {
				if (square.getX() + square.getWidth() > game.getWidth()) {
					moveX = 0;
				} else {
					moveX = Game.MOVE_DIST;
				}
			} else {
				if (square.getX() < 0) {
					moveX = 0;
				} else {
					moveX = -Game.MOVE_DIST;
				}
			}
			if (dy > 0) {
				if (square.getY() + square.getHeight() > game.getHeight()) {
					moveY = 0;
				} else {
					moveY = Game.MOVE_DIST;
				}
			} else {
				if (square.getY() < 0) {
					moveY = 0;
				} else {
					moveY = -Game.MOVE_DIST;
				}
			}
			
			game.setSquareDx(moveX);
			game.setSquareDy(moveY);
		}
	}

	public void moveSquare(Game model, Square square) {
		square.setX(square.getX() + model.getSquareDx());
		square.setY(square.getY() + model.getSquareDy());
	}
}
