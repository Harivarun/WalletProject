package com.capg.walletproject.dao;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import com.capg.walletproject.bean.PrintTransaction;
import com.capg.walletproject.bean.WalletBean;
import com.capg.walletproject.exception.WalletException;

public interface IWalletDAO {
	public boolean createAccount(WalletBean w) throws WalletException;

	public double showBalance();

	public double withDraw(double amount) throws WalletException;

	public double fundTransfer(BigInteger phoneNumber, double amount) throws WalletException;

	public double deposit(double amount) throws WalletException;

	public List<PrintTransaction> printTransaction(LocalDateTime fDate, LocalDateTime tDate, String type);
}
