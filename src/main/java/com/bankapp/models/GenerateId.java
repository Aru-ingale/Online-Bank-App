package com.bankapp.models;

import java.security.SecureRandom;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class GenerateId {

  public static void main (String... arguments) {
    try {
      
      SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
      String randomNum = Integer.valueOf(prng.nextInt()).toString();
      MessageDigest sha = MessageDigest.getInstance("SHA-1");
      byte[] result =  sha.digest(randomNum.getBytes());

      System.out.println("Random number: " + randomNum);
    }
    catch (NoSuchAlgorithmException ex) {
      System.err.println(ex);
    }
  }

  
  static private String hexEncode(byte[] input){
    StringBuilder result = new StringBuilder();
    char[] digits = {'0', '1', '2', '3', '4','5','6','7','8','9','a','b','c','d','e','f'};
    for (int idx = 0; idx < input.length; ++idx) {
      byte b = input[idx];
      result.append(digits[ (b&0xf0) >> 4 ]);
      result.append(digits[ b&0x0f]);
    }
    return result.toString();
  }


} 