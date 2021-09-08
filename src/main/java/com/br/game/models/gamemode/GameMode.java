package com.br.game.models.gamemode;

public abstract class GameMode {
	protected int timeToResponse;
	protected boolean hasTip;
	
	public int getTimeToResponse() {
		return timeToResponse;
	}
	public void setTimeToResponse(int timeToResponse) {
		this.timeToResponse = timeToResponse;
	}
	public boolean itHasTip() {
		return hasTip;
	}
	public void setHasTip(boolean hasTip) {
		this.hasTip = hasTip;
	}
}
