package com.macbethhotel.roomreservation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.macbethhotel.roomreservation.entity.RoomEntity;

public interface PageableRoomRepository extends PagingAndSortingRepository<RoomEntity, Long>{

	
	//@Query(nativeQuery =true,value = "SELECT * FROM Employee as e WHERE e.employeeName NOT IN (:names)")
	Page<RoomEntity> findByIdNotIn(List<Long> ids, Pageable page);
	
}
