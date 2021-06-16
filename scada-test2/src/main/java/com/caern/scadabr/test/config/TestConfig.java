package com.caern.scadabr.test.config;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.caern.scadabr.test.repositories.ScadaBRRepositories;

import com.caern.scadabr.test.entities.ScadaBR;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ScadaBRRepositories scadaBRRepositories;

	@Override
	public void run(String... args) throws Exception {
		Integer moduloID;
		String date;
		Double pressure;
		Integer counter;
		String timeZone;
		
		Date dataAtual;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
		
		List<ScadaBR> lista;
		lista = new ArrayList<ScadaBR>();
		
		Random gerador = new Random();
		
		for(int i=1; i<=20; i++) {
			moduloID = i;
			pressure = gerador.nextDouble()*10;
			BigDecimal bd = new BigDecimal(pressure).setScale(2, RoundingMode.HALF_EVEN); //Arrendondando 'pressure' para duas casas decimais 
			pressure = bd.doubleValue(); //Variavel 'pressure' recebendo o proprio valor arrendondado
			counter = gerador.nextInt(500);
			dataAtual = new Date();
			date = sdf.format(dataAtual);
			timeZone = TimeZone.getDefault().getID();
			ScadaBR scadaBR = new ScadaBR(moduloID, date, pressure, counter, timeZone);
			lista.add(scadaBR);
		}
		scadaBRRepositories.saveAll(lista);
	}
}
