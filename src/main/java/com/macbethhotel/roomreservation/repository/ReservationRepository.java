package com.macbethhotel.roomreservation.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.macbethhotel.roomreservation.entity.ReservationEntity;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {

	@Query("select r from ReservationEntity r where r.checkIn < :endDate and r.checkOut >= :startDate ")
	List<ReservationEntity> findFullRoomByStartBeforeOrEndAfter(
			@Param("endDate")@DateTimeFormat(iso = ISO.DATE) LocalDate endDate,
			@Param("startDate") @DateTimeFormat(iso = ISO.DATE) LocalDate startDate);

}
