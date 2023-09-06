package com.ebp.in.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reading {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long readingId;

	@Column
	private Double unitsConsumed;

	@Column
	private String readingPhoto;

	@Column
	private Date readingDate;

	@Column
	private Double pricePerUnits;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "connection_id_fk", referencedColumnName = "connectionId")
	private Connection readingForConnection;

}