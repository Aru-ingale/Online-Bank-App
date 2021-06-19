package com.bankapp.util;

import java.util.Random;

public class BankUtil {
	public static void main(String[] args) {
		System.out.println(generateBankAccountNumber("RCITY0101"));
		System.out.println(generateUserID());
	}
	
	public static String generateBankAccountNumber(String maxAccountNumber) {
		String accountInitial = "RCITY";
		String accountNumber = "";
		if(maxAccountNumber.equalsIgnoreCase("")) {
			accountNumber = maxAccountNumber.substring(5, maxAccountNumber.length());
			int i = Integer.parseInt(accountNumber);
			int strLen = (i+"").length();
			if(strLen == 1) {
				accountInitial ="RCITY000";
			}
			if(strLen == 2) {
				accountInitial ="RCITY00";
			}
			if(strLen == 3) {
				accountInitial ="RCITY0";
			}
			if(strLen == 4) {
				accountInitial ="RCITY";
			}
			i+=1;
			return accountInitial+i;
		}else {
			return accountInitial + "0001";
		}
		
	}
	
	public static int generateUserID() {
	    Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 100000 + r.nextInt(100000));
	}
	
	public static String generateRandomPassword(int len) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
          +"lmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

}
