package com.ebp.in.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {

	@Column(unique = true,nullable = false)
	@NotNull(message ="Aadhaar no is Required")
	private Long aadhaarNumber;
	@Column
	@NotEmpty(message ="Name is Required")
	private String firstName;
	@Column
	private String middleName;
	@Column
	private String lastName;
	@Column(unique = true,nullable = false)
	@NotEmpty(message ="Mobile no is Required")
	private String mobileNumber;
	@Column(unique = true,nullable = false)
	@Email
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-zA-A]+", message = "enter email in valid format")
	private String email;
	@Column
	@Enumerated(EnumType.STRING)
	private Gender gender;

}
