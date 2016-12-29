package com.eduardo.boardingcards;

/**
 * Representa al titular y propietario de una tarjeta de embarque
 * @author eduardo
 *
 */
public class BoardingCardOwner {
	
	private String name;
	private String firstName;
	private int age;
	
	// M�s atributos ...
	
	/**
	 * Construye un objeto que representa el propietario de una tarjeta de embarque o viaje
	 * @param name El nombre del propietario
	 * @param firstName El primer apellido del propietario
	 * @param age La edad del propietario
	 */
	public BoardingCardOwner(String name, String firstName, int age) {
		this.name = name;
		this.firstName = firstName;
		this.age = age;
	}

	/**
	 * Construye un propietario de tarjeta de embarque con los siguientes datos:
	 * <ul>
	 * <li>Name: ""</li>
	 * <li>First Name: ""</li>
	 * <li>Age: 0</li>
	 * </ul>
	 */
	public BoardingCardOwner() {
		name = "";
		firstName = "";
		age = 0;
	}

	/**
	 * Permite obtener el nombre del propietario de la tarjeta de embarque
	 * @return El nombre del propietario de la tarjeta de embarque
	 */
	public String getName() {
		return name;
	}

	/**
	 * Permite modificar el nombre del propietario de la tarjeta de embarque
	 * @param name El nombre del propietario de la tarjeta de embarque
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Permite obtener el primer apellido del propietario de la tarjeta de embarque
	 * @return El primer apellido del propietario de la tarjeta de embarque
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Permite modificar el primer apellido del propietario de la tarjeta de embarque
	 * @param firstName El primer apellido del propietario de la tarjeta de embarque
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Permite obtener la edad del propietario de la tarjeta de embarque
	 * @return La edad del propietario de la tarjeta de embarque
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Permite modificar la edad del propietario de la tarjeta de embarque
	 * @param age La edad del propietario de la tarjeta de embarque
	 */
	public void setAge(int age) {
		this.age = age;
	}

}
