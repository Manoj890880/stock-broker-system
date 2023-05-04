package com.masai.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@Data
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer TId;
    
	@NotNull
	private Integer com_Id;
    
	@NotNull
	private Integer Customer_Id;
   
	@NotNull
	@Future(message = "Buy_Date should be in future")
	private LocalDate Buy_Date;

	@NotNull
	
	private Integer Buy_Qty;

	@NotNull
	private Integer Buy_Amount;

	@NotNull
	@Future(message = "Sell_Date should be in future")
	private LocalDate sell_Date;

	@NotNull
	private Integer sell_Qty;
    
	@NotNull
	private Integer sell_Amount;

}
