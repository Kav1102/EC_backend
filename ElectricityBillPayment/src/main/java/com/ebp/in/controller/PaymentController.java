package com.ebp.in.controller;

import java.util.List;

import com.ebp.in.entity.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ebp.in.entity.Payment;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.service.IPaymentService;

@RestController
@RequestMapping(value="/payment")
public class PaymentController {

	@Autowired
	private IPaymentService paymentService;

	@PostMapping(value = "/payBill")
	public ResponseEntity<PaymentStatus> payBill(@RequestBody Payment payment)
	{
		PaymentStatus paymentStatus= paymentService.payBill(payment);
		return new ResponseEntity<PaymentStatus>(paymentStatus, HttpStatus.CREATED);
	}

	@GetMapping(value="/consumerNumber/{consumerNumber}")
	public ResponseEntity<List<Payment>> viewHistoricalPayment(Long consumerNumber)throws NoSuchCustomerException
	{
		List<Payment> readByconsumerNumber=paymentService.viewHistoricalPayment(consumerNumber);
		return new ResponseEntity<List<Payment>>(readByconsumerNumber,HttpStatus.OK);				
	}
}
