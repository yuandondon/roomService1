package com.logger.Group1RoomServiceSys.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="FOOD")
public class Food {
	@Id
	private int id;	
	@Column(name="NAME")
	private String name;
	@Column(name="PRICE")
	private int price;
	public Food(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Food() {
		super();
	}
	

}
