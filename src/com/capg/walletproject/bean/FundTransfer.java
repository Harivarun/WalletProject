package com.capg.walletproject.bean;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class FundTransfer {

	private BigInteger ReceiverPhone;
	private double amount;
	private LocalDateTime date;
	private double balance;
	
	public BigInteger getReceiverPhone() {
		return ReceiverPhone;
	}

	public void setReceiverPhone(BigInteger receiverPhone) {
		ReceiverPhone = receiverPhone;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}