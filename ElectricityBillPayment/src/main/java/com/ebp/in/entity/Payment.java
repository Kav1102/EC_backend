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
public class Payment  {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long paymentId;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="bill_fk",referencedColumnName="billId")
	private Bill billPayment;
	
	@Column
	private Date paymentDate;
	
	@Enumerated(EnumType.STRING)
	@Column
	private PaymentMode paymentMode;
	
	@Column
	private double latePaymentCharges;
	
	@Column
	private double totalPaid;
	
	@Enumerated(EnumType.STRING)
	@Column
	private PaymentStatus status;

	}