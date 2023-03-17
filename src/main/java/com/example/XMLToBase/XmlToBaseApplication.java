package com.example.XMLToBase;

import com.example.XMLToBase.db.XmlTools.XMLAttributeReader;
import com.example.XMLToBase.db.entity.GarAddressobject;
import com.example.XMLToBase.db.service.GarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class XmlToBaseApplication implements CommandLineRunner {
	@Autowired
	GarService garService;

	public static void main(String[] args) {
		SpringApplication.run(XmlToBaseApplication.class, args).close();
	}

	@Override
	public void run(String[] args) throws Exception {
		if (args.length > 0) {
			garService.loadGar();
		}
	}

}
