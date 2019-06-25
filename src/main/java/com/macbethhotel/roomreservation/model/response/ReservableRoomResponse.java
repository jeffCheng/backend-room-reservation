package com.macbethhotel.roomreservation.model.response;

import com.macbethhotel.roomreservation.model.Links;

public class ReservableRoomResponse {

	private long id;
	private int roomNumber;
	private double price;
	private Links links;
	
	public ReservableRoomResponse() {
		super();
	}
	
	public ReservableRoomResponse(int roomNumber, double price, Links links) {
		super();
		this.roomNumber = roomNumber;
		this.price = price;
		this.links = links;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Links getLinks() {
		return links;
	}
	public void setLinks(Links links) {
		this.links = links;
	}
	
	
}
