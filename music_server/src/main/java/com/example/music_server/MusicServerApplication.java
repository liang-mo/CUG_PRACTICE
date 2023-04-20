package com.example.music_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//123
@MapperScan("com.example.music_server.Dao")
public class MusicServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(MusicServerApplication.class, args);
	}

}
