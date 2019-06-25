package com.macbethhotel.roomreservation.rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.macbethhotel.roomreservation.converter.ReservationRequestToReservationEntityConverter;
import com.macbethhotel.roomreservation.converter.RoomEntityToReservableRoomResponseConverter;
import com.macbethhotel.roomreservation.entity.ReservationEntity;
import com.macbethhotel.roomreservation.entity.RoomEntity;
import com.macbethhotel.roomreservation.model.request.ReservationRequest;
import com.macbethhotel.roomreservation.model.response.ReservableRoomResponse;
import com.macbethhotel.roomreservation.model.response.ReservationResponse;
import com.macbethhotel.roomreservation.repository.PageableRoomRepository;
import com.macbethhotel.roomreservation.repository.ReservationRepository;
import com.macbethhotel.roomreservation.repository.RoomRepository;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
@CrossOrigin
public class ReservationResource {
	Logger logger = LoggerFactory.getLogger(ReservationResource.class);

	@Autowired
	private PageableRoomRepository pageableRoomRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private RoomEntityToReservableRoomResponseConverter converter;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private ConversionService converstionService;

	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<ReservableRoomResponse> getAvailableRoom(
			@RequestParam(value = "checkin", required = true ) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
			@RequestParam(value = "checkout", required = true ) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut,
			Pageable pageable) {
		List<ReservationEntity> list = reservationRepository.findFullRoomByStartBeforeOrEndAfter(checkOut, checkIn);
		List<Long> res = new ArrayList<>();
		for (ReservationEntity r : list) {
			System.out.println(r.getRoomId());
			res.add(r.getRoomId());
		}
		System.out.println("This is one.");
		Page<RoomEntity> roomEntityList = (list.size() == 0) ? pageableRoomRepository.findAll(pageable)
				: pageableRoomRepository.findByIdNotIn(res, pageable);
		return roomEntityList.map(converter::convert);
	}

	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> createReservation(@RequestBody ReservationRequest reservationRequest) {

		ReservationEntity reservationEntity = converstionService.convert(reservationRequest, ReservationEntity.class);
		reservationRepository.save(reservationEntity);
		// System.out.println(reservationEntity.getRoomId());
		System.out.println("111" + reservationEntity.getRoomId() + "   " + reservationEntity.getId());

		RoomEntity roomEntity = roomRepository.findById(reservationRequest.getRoomId())
				.orElseThrow(EntityNotFoundException::new);
		roomEntity.addReservationEntity(reservationEntity);
		roomRepository.save(roomEntity);

		// reservationEntity.setRoomEntity(roomEntity);

		ReservationResponse reservationResponse = converstionService.convert(reservationEntity,
				ReservationResponse.class);

		return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);
	}

	@RequestMapping(path = "/{roomId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RoomEntity> getRoomById(@PathVariable Long roomId) {
		RoomEntity roomEntity = roomRepository.findById(roomId).orElseThrow(EntityNotFoundException::new);
		return new ResponseEntity<>(roomEntity, HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservableRoomResponse> updateReservation(
			@RequestBody ReservationRequest reservationRequest) {
		return new ResponseEntity<>(new ReservableRoomResponse(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteReservation(@PathVariable long reservationId) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
