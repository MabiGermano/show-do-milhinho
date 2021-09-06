package com.br.game.models.gamemode;

public abstract class GameMode {
	protected Long timeToResponse;
	protected boolean hasTip;
	
	public Long getTimeToResponse() {
		return timeToResponse;
	}
	public void setTimeToResponse(Long timeToResponse) {
		this.timeToResponse = timeToResponse;
	}
	public boolean isHasTip() {
		return hasTip;
	}
	public void setHasTip(boolean hasTip) {
		this.hasTip = hasTip;
	}
}
