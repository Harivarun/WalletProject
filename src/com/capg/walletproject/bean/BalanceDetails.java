package com.capg.walletproject.bean;

import java.math.BigInteger;

public class BalanceDetails {

	private BigInteger phoneNumber;
	private double balance = 0.0;

	public BalanceDetails() {
		super();
	}
	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
