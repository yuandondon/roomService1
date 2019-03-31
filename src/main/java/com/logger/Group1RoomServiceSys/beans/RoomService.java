package com.logger.Group1RoomServiceSys.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="ROOM_SERVICE")
public class RoomService {

	@Id
	@Column(name="ID")
	private int id;	
	@Column(name="ROOM_NUMBER")
	private int roomNumber;
//	@Column(name="RESERVATION_NUMBER")
//	private int reservationNumber;
	@Column(name="BED_SHEET")
	private int bedSheet;
	@Column(name="REFILL_BATH")
	private int refillBath;
	@Column(name="MADE_BY")
	private int madeBy;
	@Column(name="STATUS")
	private int status;
	@Column(name="CHECK_OUT_BY")
	private int checkOutBy;
	
//	@OneToMany
//	@JoinColumn(name="RS_ID", referencedColumnName="RESERVATION_NUMBER")
//	private List<FoodOrder> foodOrder;
	
//	@OneToMany
//	@JoinColumn(name="RESERVATION_NUMBER", referencedColumnName="RS_ID")
//	private List<FoodOrder> foodOrder;
	
	@OneToMany(mappedBy = "rsID", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<FoodOrder> foodOrder;
	
	

//	public RoomService() {
//		super();
//	}
//	
//	@Override
//	public String toString() {
//		return "RoomService [id=" + id + ", roomNumber=" + roomNumber + ", bedSheet=" + bedSheet + ", refillBath="
//				+ refillBath + ", madeBy=" + madeBy + ", status=" + status + ", checkOutBy=" + checkOutBy
//				+ ", foodOrder=" + foodOrder + "]";
//	}
//	
	
	
	
	
	

}
