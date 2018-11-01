package com.capg.walletproject.test;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.walletproject.bean.PrintTransaction;
import com.capg.walletproject.service.IWalletService;
import com.capg.walletproject.service.WalletServiceImp;

public class TestXyzWalletService {

	static IWalletService service = null;
    static List<PrintTransaction> expResult = null;
	@BeforeClass
	public static void init() {
		service = new WalletServiceImp();
		PrintTransaction printTransaction=new PrintTransaction();
		printTransaction.setAmount(5000.0);
		printTransaction.setBalance(5000.0);
		printTransaction.setDate(LocalDateTime.of(2016, 02, 10, 17, 02));
		printTransaction.setPhoneNumber(new BigInteger("1234567890"));
		expResult.add(printTransaction);
	}

	@Test
	public void TestPrintTransaction() {
		List<PrintTransaction> result=service.printTransaction(LocalDateTime.of(2016, 01, 01, 12, 00), LocalDateTime.of(2016, 01, 01, 12, 00), "deposit");
	    Assert.assertEquals(expResult, result);
	}
}