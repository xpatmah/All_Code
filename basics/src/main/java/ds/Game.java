package com.java.basic.ds;

public abstract class Game {

	public Game(int numberOfPlayer) {
		this.numberofplayer = numberOfPlayer;
	}
	
	public void run() {
		start();
		while(!haveWinner()) {
			turnTurn();
		}
		System.out.println("Player "+ getWinningPlayer() + " wines");
	}
	
	protected abstract void start();
	protected abstract boolean  haveWinner();
	protected abstract void turnTurn();
	protected abstract String getWinningPlayer();
	
	protected int currentPlayer;
	
	protected final int numberofplayer;
	
}
