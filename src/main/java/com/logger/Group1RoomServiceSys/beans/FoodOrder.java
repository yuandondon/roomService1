package com.logger.Group1RoomServiceSys.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="FOOD_ORDER")
public class FoodOrder {
	
	@Id
	private int id;
	@Column(name="RS_ID")
	private int rsID;
	@Column(name="FOOD_ID")
	private int foodID;
	@Column(name="QTY")
	private int qty;
	
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID", referencedColumnName = "FOOD_ID")
	private Food food;
	
	public FoodOrder(int id, int rsID, int foodID, int qty) {
		super();
		this.id = id;
		this.rsID = rsID;
		this.foodID = foodID;
		this.qty = qty;
	}
	public FoodOrder() {
		
	}

}
