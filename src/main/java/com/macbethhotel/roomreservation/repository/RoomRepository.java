package com.macbethhotel.roomreservation.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.macbethhotel.roomreservation.entity.RoomEntity;

public interface RoomRepository extends CrudRepository < RoomEntity, Long > {
	Optional<RoomEntity> findById(Long id);
}
