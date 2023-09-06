package com.ebp.in.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Connection {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long connectionId;

	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long consumerNumber;


	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="user_id",referencedColumnName = "user_id")
	private Customer customerConnection;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id",referencedColumnName ="addressId")
	private Address connectionAddress;
	
	@Column
	@Enumerated(EnumType.STRING)
	private ConnectionType connectionType;

	@Column
	private Date applicationDate;
	
	@Column
	private Date connectionDate;

	@Column
	@Enumerated(EnumType.STRING)
	private ConnectionStatus connectionStatus;
}
