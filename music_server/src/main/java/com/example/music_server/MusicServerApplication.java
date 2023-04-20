package com.example.music_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//1231
@MapperScan("com.example.music_server.Dao")//123
public class MusicServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(MusicServerApplication.class, args);
	}

}
