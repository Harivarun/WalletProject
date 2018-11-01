package com.capg.walletproject.database;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.capg.walletproject.bean.BalanceDetails;
import com.capg.walletproject.bean.Deposit;
import com.capg.walletproject.bean.FundTransfer;
import com.capg.walletproject.bean.WalletBean;
import com.capg.walletproject.bean.Withdraw;


public class WalletDatabase {

	private static List<WalletBean> list = new ArrayList<>();
	private static List<BalanceDetails> balanceList = new ArrayList<>();
    private static List<Withdraw> withdrawList = new ArrayList<>();
	private static List<Deposit> depositList = new ArrayList<>();
	private static List<FundTransfer> fundTranserList = new ArrayList<>();
	static {
		WalletBean walletBean = new WalletBean();
		walletBean.setFirstName("hari");
		walletBean.setLastName("varun");
		walletBean.setPhoneNumber(new BigInteger("6542312423"));
		walletBean.setAddress("address-1");
		walletBean.setEmail("mshvarunkumar@gmail.com");
		walletBean.setUserName("HariVarun");
		list.add(walletBean);
		WalletBean walletBean2 = new WalletBean();
		walletBean2.setFirstName("hari");
		walletBean2.setLastName("varun");
		walletBean2.setPhoneNumber(new BigInteger("7416368112"));
		walletBean2.setAddress("address-2");
		walletBean2.setEmail("mshvarunkumar96@gmail.com");
		walletBean2.setUserName("HariVarun");
		list.add(walletBean2);
		
		BalanceDetails balanceDetails = new BalanceDetails();
		balanceDetails.setBalance(1000.0);
		balanceDetails.setPhoneNumber(new BigInteger("1234567890"));
		balanceList.add(balanceDetails);
		
		BalanceDetails balanceDetails2 = new BalanceDetails();
		balanceDetails2.setBalance(2000.0);
		balanceDetails2.setPhoneNumber(new BigInteger("1234567891"));
		balanceList.add(balanceDetails2);
		
		Deposit deposit=new Deposit();
		deposit.setAmount(3000.0);
		deposit.setBalance(4000.0);
		deposit.setDate(LocalDateTime.of(2014, 01, 23, 12, 02));
		depositList.add(deposit);
		
		Deposit deposit2=new Deposit();
		deposit.setAmount(5000.0);
		deposit.setBalance(5000.0);
		deposit.setDate(LocalDateTime.of(2016, 02, 10, 17, 02));
		depositList.add(deposit2);
		
		Withdraw withdraw=new Withdraw();
		withdraw.setAmount(4000.0);
		withdraw.setBalance(0.0);
		withdraw.setDate(LocalDateTime.of(2015, 05, 24, 9, 12));
		withdrawList.add(withdraw);
		
		Withdraw withdraw2=new Withdraw();
		withdraw.setAmount(2000.0);
		withdraw.setBalance(3000.0);
		withdraw.setDate(LocalDateTime.of(2017, 01, 11, 23, 56));
		withdrawList.add(withdraw2);
		
		FundTransfer fundTransfer=new FundTransfer();
		fundTransfer.setAmount(1000.0);
		fundTransfer.setBalance(2000.0);
		fundTransfer.setDate(LocalDateTime.of(2017, 01, 12, 7, 45));
		fundTransfer.setReceiverPhone(new BigInteger("8121845782"));
		fundTranserList.add(fundTransfer);
		
		FundTransfer fundTransfer2=new FundTransfer();
		fundTransfer.setAmount(2000.0);
		fundTransfer.setBalance(1000.0);
		fundTransfer.setDate(LocalDateTime.of(2016, 02, 11, 3, 25));
		fundTransfer.setReceiverPhone(new BigInteger("9678493121"));
		fundTranserList.add(fundTransfer2);
		
	}

	public static List<WalletBean> getAccountList() {
		return list;
	}

	public static List<BalanceDetails> getBalancedetails() {
		return balanceList;
	}
	
	public static List<Deposit> getDepositList() {
		return depositList;
	}

	public static List<Withdraw> getWithdrawList() {
		return withdrawList;
	}

	public static List<FundTransfer> getFundTransferList() {
		return fundTranserList;
	}

	
}
