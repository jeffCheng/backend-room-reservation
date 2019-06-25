package com.macbethhotel.roomreservation.converter;

import org.springframework.core.convert.converter.Converter;

import com.macbethhotel.roomreservation.entity.ReservationEntity;
import com.macbethhotel.roomreservation.model.response.ReservationResponse;

public class ReservationEntityToReservationResponseConverter implements Converter<ReservationEntity, ReservationResponse> {

	@Override
	public ReservationResponse convert(ReservationEntity source) {
		ReservationResponse reservationResponse = new ReservationResponse();
		reservationResponse.setId(source.getId());
		reservationResponse.setCheckIn(source.getCheckIn());
		reservationResponse.setCheckOut(source.getCheckOut());
		return reservationResponse;
	}

}
