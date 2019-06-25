package com.macbethhotel.roomreservation.model.response;

import java.time.LocalDate;

public class ReservationResponse {

	private long id;
	private LocalDate checkIn;
	private LocalDate checkOut;
	public ReservationResponse() {
		super();
	}
	public ReservationResponse(long id, LocalDate checkIn, LocalDate checkOut) {
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	
	
	
	
}
