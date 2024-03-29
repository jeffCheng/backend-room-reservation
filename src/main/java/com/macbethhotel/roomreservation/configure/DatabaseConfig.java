package com.macbethhotel.roomreservation.configure;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.macbethhotel.roomreservation.repository")
@EnableTransactionManagement
public class DatabaseConfig {

}
