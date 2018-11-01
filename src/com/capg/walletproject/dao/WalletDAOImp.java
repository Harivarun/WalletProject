package com.capg.walletproject.dao;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.capg.walletproject.bean.BalanceDetails;
import com.capg.walletproject.bean.Deposit;
import com.capg.walletproject.bean.FundTransfer;
import com.capg.walletproject.bean.PrintTransaction;
import com.capg.walletproject.bean.WalletBean;
import com.capg.walletproject.bean.Withdraw;
import com.capg.walletproject.database.WalletDatabase;

public class WalletDAOImp implements IWalletDAO {

	List<PrintTransaction> transaction = new ArrayList<>();

	BalanceDetails balancedetails = new BalanceDetails();

	@Override
	public boolean createAccount(WalletBean w) {
		return WalletDatabase.getAccountList().add(w);
	}

	@Override
	public double showBalance() {
		return WalletDatabase.getBalancedetails().get(0).getBalance();
	}

	@Override
	public double withDraw(double amount) {
		double balance = 0.0;
		WalletDatabase.getBalancedetails();
		Withdraw withdraw = new Withdraw();
		LocalDateTime date = LocalDateTime.now();
		if (WalletDatabase.getBalancedetails().get(0).getBalance() > amount) {
			balance = WalletDatabase.getBalancedetails().get(0).getBalance() - amount;
			balancedetails.setBalance(balance);
			WalletDatabase.getBalancedetails().set(0, balancedetails);

			withdraw.setAmount(amount);
			withdraw.setBalance(balance);
			withdraw.setDate(date);

			WalletDatabase.getWithdrawList().add(withdraw);
		}
		return balance;
	}

	@Override
	public double fundTransfer(BigInteger phoneNumber, double amount) {

		double balance1 = 0.0;
		double balance2 = 0.0;
		FundTransfer fundTransfer = new FundTransfer();
		LocalDateTime date = LocalDateTime.now();
		if (WalletDatabase.getBalancedetails().get(0).getBalance() > amount) {
			WalletDatabase.getBalancedetails();
			balance1 = WalletDatabase.getBalancedetails().get(0).getBalance() - amount;
			balancedetails.setBalance(balance1);
			WalletDatabase.getBalancedetails().set(0, balancedetails);

			WalletDatabase.getBalancedetails();
			balance2 = WalletDatabase.getBalancedetails().get(1).getBalance() + amount;
			balancedetails.setBalance(balance2);
			WalletDatabase.getBalancedetails().set(1, balancedetails);

			fundTransfer.setAmount(amount);
			fundTransfer.setBalance(balance1);
			fundTransfer.setDate(date);
			fundTransfer.setReceiverPhone(phoneNumber);

			WalletDatabase.getFundTransferList().add(fundTransfer);
		}
		return balance1;
	}

	@Override
	public double deposit(double amount) {
		double balance = 0.0;
		LocalDateTime date = LocalDateTime.now();
		Deposit deposit = new Deposit();

		WalletDatabase.getBalancedetails();
		balance = WalletDatabase.getBalancedetails().get(0).getBalance() + amount;
		balancedetails.setBalance(balance);
		WalletDatabase.getBalancedetails().set(0, balancedetails);

		deposit.setAmount(amount);
		deposit.setBalance(balance);
		deposit.setDate(date);

		WalletDatabase.getDepositList().add(deposit);

		return balance;
	}

	@Override
	public List<PrintTransaction> printTransaction(LocalDateTime fDate, LocalDateTime tDate, String type) {

		PrintTransaction printTransaction = new PrintTransaction();
		// FundTransfer fundTransfer = new FundTransfer();
		if (type.equals("deposit")) {
			for (Deposit deposit : WalletDatabase.getDepositList()) {
				if (deposit.getDate().isAfter(fDate) && deposit.getDate().isBefore(tDate)) {
					printTransaction.setAmount(deposit.getAmount());
					printTransaction.setBalance(deposit.getBalance());
					printTransaction.setDate(deposit.getDate());
					printTransaction.setPhoneNumber(WalletDatabase.getBalancedetails().get(0).getPhoneNumber());

					transaction.add(printTransaction);

				}
			}
		}
		if (type.equals("withdraw")) {
			for (Withdraw withdraw : WalletDatabase.getWithdrawList()) {
				if (withdraw.getDate().isAfter(fDate) && withdraw.getDate().isBefore(tDate)) {

					printTransaction.setAmount(withdraw.getAmount());
					printTransaction.setBalance(withdraw.getBalance());
					printTransaction.setDate(withdraw.getDate());
					printTransaction.setPhoneNumber(WalletDatabase.getBalancedetails().get(0).getPhoneNumber());

					transaction.add(printTransaction);

				}
			}
		}
		if (type.equals("fundtransfer")) {
			for (FundTransfer fundTransfer : WalletDatabase.getFundTransferList()) {
				if (fundTransfer.getDate().isAfter(fDate) && fundTransfer.getDate().isBefore(tDate)) {
					printTransaction.setAmount(fundTransfer.getAmount());
					printTransaction.setBalance(fundTransfer.getBalance());
					printTransaction.setDate(fundTransfer.getDate());
					printTransaction.setPhoneNumber(WalletDatabase.getBalancedetails().get(0).getPhoneNumber());

					transaction.add(printTransaction);

				}
			}
		}
		return transaction;

	}
}
