package com.capg.walletproject.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import com.capg.walletproject.bean.PrintTransaction;
import com.capg.walletproject.bean.WalletBean;
import com.capg.walletproject.dao.IWalletDAO;
import com.capg.walletproject.dao.WalletDAOImp;
import com.capg.walletproject.exception.WalletException;
import com.capg.walletproject.exception.WalletExceptionMessages;

public class WalletServiceImp implements IWalletService {

	IWalletDAO dao = new WalletDAOImp();
	WalletBean bean = new WalletBean();

	@Override
	public boolean createAccount(WalletBean w) throws WalletException {
		boolean isCreated = false;
		if (validations(w)) {
			isCreated = dao.createAccount(w);
		}
		return isCreated;
	}

	@Override
	public double showBalance() {
		return dao.showBalance();
	}

	@Override
	public double withDraw(double amount) throws WalletException {
		double balance = 0.0;
		if (validAmount(amount)) {
			balance = dao.withDraw(amount);
		}
		return balance;
	}

	@Override
	public double fundTransfer(BigInteger phoneNumber, double amount) throws WalletException {

		double balance = 0.0;
		if (validAmount(amount) && validPhoneNumber(phoneNumber)) {
			balance = dao.fundTransfer(phoneNumber, amount);
		}
		return balance;
	}

	@Override
	public double deposit(double amount) throws WalletException {
		double balance = 0.0;
		if (validAmount(amount)) {
			balance = dao.deposit(amount);
		}
		return balance;
	}

	@Override
	public boolean validations(WalletBean w) throws WalletException {
		boolean isValid = false;
		if (w.getFirstName().trim().length() < 4) {
			throw new WalletException(WalletExceptionMessages.ERRORNAME);
		} else if (w.getLastName().trim().length() < 4) {
			throw new WalletException(WalletExceptionMessages.ERRORNAME);
		} else if (!(String.valueOf(w.getPhoneNumber()).matches("(0)?[6-9][0-9]{9}"))) {
			throw new WalletException(WalletExceptionMessages.ERRORPHONE);
		} else if (w.getAddress().length() == 0) {
			throw new WalletException(WalletExceptionMessages.ERRORADDRESS);
		} else if (!(w.getEmail().matches("^[A-Za-z0-9.]+@[A-Za-z0-9.-]+\\\\.[A-Z]{2,6}$"))) {
			throw new WalletException(WalletExceptionMessages.ERROREMAIL);
		} else {
			isValid = true;
		}
		return isValid;
	}

	@Override
	public boolean validPhoneNumber(BigInteger phoneNumber) throws WalletException {
		boolean isValid = false;
		if (phoneNumber.toString().matches("(0)?[6-9][0-9]{9}")) {
			isValid = true;
		} else {
			throw new WalletException(WalletExceptionMessages.ERRORPHONE);
		}
		return isValid;
	}

	@Override
	public boolean validAmount(double amount) throws WalletException {
		boolean isValid = false;
		if (amount > 0) {
			isValid = true;
		} else {
			throw new WalletException(WalletExceptionMessages.ERRORNEGATIVEVALUE);
		}
		return isValid;
	}

	@Override
	public List<PrintTransaction> printTransaction(LocalDateTime fDate, LocalDateTime tDate, String type) {
		return dao.printTransaction(fDate, tDate, type);
	}
}
