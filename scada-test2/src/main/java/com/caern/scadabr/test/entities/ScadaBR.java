package com.caern.scadabr.test.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ScadaBR")
public class ScadaBR implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer moduloID;
	private String date;
	private Double pressure;
	private Integer counter;
	private String timeZone;
	private String stringscadabr;
	public ScadaBR() {
		super();
	}
	
	public ScadaBR(Integer moduloID, String date, Double pressure, Integer counter, String timeZone) {
		super();
		this.moduloID = moduloID;
		this.date = date;
		this.timeZone = timeZone;
		this.pressure = pressure;
		this.counter = counter;
		this.stringscadabr = "moduloID:" + moduloID +";" +
				moduloID.toString() + ".date:"+date+";" +
				moduloID.toString() + ".tz:" + timeZone+";" +
				moduloID.toString()+".pressure:"+pressure.toString()+";" +
				moduloID.toString()+".counter:"+counter.toString(); 
	}

	public Integer getModuloID() {
		return moduloID;
	}

	public void setModuloID(Integer moduloID) {
		this.moduloID = moduloID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	public String getStringscadabr() {
		return stringscadabr;
	}

	public void setStringscadabr(String stringscadabr) {
		this.stringscadabr = stringscadabr;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
	
	
}
