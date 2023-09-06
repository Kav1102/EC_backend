package com.ebp.in.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long billId;
	@Column
	private Date billDate;
	@Column
	private LocalDate billDueDate;
	@Column
	private double unitsConsumed;
	@Column
	private double billAmount;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="reading_fk",referencedColumnName="readingId")
	private Reading billForReading;

}
