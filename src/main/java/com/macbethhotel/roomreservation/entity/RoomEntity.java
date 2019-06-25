package com.macbethhotel.roomreservation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name ="Room")
public class RoomEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private int roomNumber;

	@NotNull
	private String price;
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ReservationEntity> revervationEntityList;

	public RoomEntity(@NotNull int roomNumber, @NotNull String price) {
		this.roomNumber = roomNumber;
		this.price = price;
	}

	public RoomEntity() {
		super();
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<ReservationEntity> getRevervationEntityList() {
		return revervationEntityList;
	}

	public void setRevervationEntityList(List<ReservationEntity> revervationEntityList) {
		this.revervationEntityList = revervationEntityList;
	}
	
	public void addReservationEntity(ReservationEntity reservationEntity) {
		if(revervationEntityList == null) {
			revervationEntityList = new ArrayList<>();
		}
		revervationEntityList.add(reservationEntity);
	}

}
