package com.macbethhotel.roomreservation.model.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservationRequest {

	private Long id;
	
	private long roomId;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkin;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkout;
	
	public ReservationRequest(long roomId, LocalDate checkin, LocalDate checkout) {
		super();
		this.roomId = roomId;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public ReservationRequest() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	
	
	
}
