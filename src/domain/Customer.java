package domain;

import java.util.Observable;

public class Customer extends Observable{
	
	private String name, surname, street, city;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		setChanged();
		notifyObservers();
	}

	private int zip;

	public Customer(String name, String surname) {
		this.name = name;
		this.surname = surname;
		this.id = (int) (Math.random() * 10000); 
	}
	
	public void setAdress(String street, int zip, String city) {
		this.street = street;
		this.zip = zip;
		this.city = city;
		setChanged();
		notifyObservers();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers();
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
		setChanged();
		notifyObservers();
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
		setChanged();
		notifyObservers();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
		setChanged();
		notifyObservers();
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
		setChanged();
		notifyObservers();
	}
	
	@Override
	public String toString() {
		return name + " " + surname + " , " + street + " , " + zip + " " + city;
	}

}
