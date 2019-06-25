package com.macbethhotel.roomreservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.macbethhotel.roomreservation.entity.RoomEntity;
import com.macbethhotel.roomreservation.repository.RoomRepository;

@Component
public class H2Bootstrap implements CommandLineRunner{

	@Autowired
	RoomRepository roomRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Start import data:");

		roomRepository.save(new RoomEntity(405,"2222"));
		roomRepository.save(new RoomEntity(406,"66222"));
		roomRepository.save(new RoomEntity(407,"266222"));
		roomRepository.save(new RoomEntity(408,"642"));
		
		
		Iterable<RoomEntity> iter = roomRepository.findAll();
		
		for(RoomEntity room: iter) {
			System.out.println(room.getRoomNumber());
		}
	}

}
