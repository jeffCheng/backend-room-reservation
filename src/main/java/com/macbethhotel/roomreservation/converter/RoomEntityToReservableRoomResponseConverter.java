package com.macbethhotel.roomreservation.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.macbethhotel.roomreservation.entity.RoomEntity;
import com.macbethhotel.roomreservation.model.Links;
import com.macbethhotel.roomreservation.model.Self;
import com.macbethhotel.roomreservation.model.response.ReservableRoomResponse;
import com.macbethhotel.roomreservation.rest.ResourceConstants;

@Component
public class RoomEntityToReservableRoomResponseConverter implements Converter<RoomEntity,ReservableRoomResponse>{

	@Override
	public ReservableRoomResponse convert(RoomEntity source) {
		// TODO Auto-generated method stub
		ReservableRoomResponse reservationResponse = new ReservableRoomResponse();
		reservationResponse.setId(source.getId());
		reservationResponse.setRoomNumber(source.getRoomNumber());
		reservationResponse.setPrice(Double.valueOf(source.getPrice()));
		
		Links links =new Links();
		Self self = new Self();
		self.setRef(ResourceConstants.ROOM_RESERVATION_V1+"/" + source.getId());
		links.setSelf(self);
		reservationResponse.setLinks(links);
		return reservationResponse;
	}

}
