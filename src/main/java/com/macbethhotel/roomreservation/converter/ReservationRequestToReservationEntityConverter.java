package com.macbethhotel.roomreservation.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import com.macbethhotel.roomreservation.entity.ReservationEntity;
import com.macbethhotel.roomreservation.model.request.ReservationRequest;

public class ReservationRequestToReservationEntityConverter implements Converter<ReservationRequest,ReservationEntity>{

	Logger logger = LoggerFactory.getLogger(ReservationRequestToReservationEntityConverter.class);
	
	@Override
	public ReservationEntity convert(ReservationRequest source) {
		
		ReservationEntity reservationEntity = new ReservationEntity();
		
		reservationEntity.setCheckIn(source.getCheckin());
		reservationEntity.setCheckOut(source.getCheckout());
		reservationEntity.setRoomId(source.getRoomId());
		System.out.println(""+source.getRoomId()+source.getId());
		
		if(source.getId() != null) {
			reservationEntity.setId(source.getId());
		}
		return reservationEntity;
	}

}
