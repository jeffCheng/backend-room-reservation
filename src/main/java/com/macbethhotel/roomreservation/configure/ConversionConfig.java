package com.macbethhotel.roomreservation.configure;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.macbethhotel.roomreservation.converter.ReservationEntityToReservationResponseConverter;
import com.macbethhotel.roomreservation.converter.ReservationRequestToReservationEntityConverter;
import com.macbethhotel.roomreservation.converter.RoomEntityToReservableRoomResponseConverter;

@Configuration
public class ConversionConfig {
	
	private Set<Converter> getConverters(){
		Set<Converter> converters = new HashSet<Converter>();
		converters.add(new RoomEntityToReservableRoomResponseConverter());
		converters.add(new ReservationEntityToReservationResponseConverter());
		converters.add(new ReservationRequestToReservationEntityConverter());
		return converters;
	}
	
	@Bean
	@Primary
	public ConversionService conversionService() {
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
		bean.setConverters(getConverters());
		bean.afterPropertiesSet();
		return bean.getObject();
	}

}
