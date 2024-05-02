package com.passwordgenerator;
import java.security.SecureRandom;
import java.util.Scanner;
/**
 * This class represents a Password Generator that creates random passwords based on user-defined criteria.
 */
public class Demo implements PasswordGenerator {
    // Member variables to store password criteria and a SecureRandom instance for secure random number generation
    private int passwordLength;
    private int upperCaseCount;
    private int lowerCaseCount;
    private int symbolCount;
    private int digitsCount;
    private SecureRandom secureRandom;
    /**
     * Constructor to initialize the SecureRandom instance.
     */
    public Demo(){
      secureRandom=new SecureRandom();
    }
    // Getters and setters for password criteria
    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    public void setUpperCaseCount(int upperCaseCount) {
        this.upperCaseCount = upperCaseCount;
    }

    public void setLowerCaseCount(int lowerCaseCount) {
        this.lowerCaseCount = lowerCaseCount;
    }

    public void setSymbolCount(int symbolCount) {
        this.symbolCount = symbolCount;
    }

    public void setDigitsCount(int digitsCount) {
        this.digitsCount = digitsCount;
    }
    public int getPasswordLength() {
        return passwordLength;
    }

    public int getUpperCaseCount() {
        return upperCaseCount;
    }

    public int getLowerCaseCount() {
        return lowerCaseCount;
    }

    public int getSymbolCount() {
        return symbolCount;
    }

    public int getDigitsCount() {
        return digitsCount;
    }
    // Methods to generate random characters for password criteria
    @Override
    public char[] numberOfLowerCases(int lowerCaseCount){
       char ch1[]=new char[lowerCaseCount];
        for(int i=0;i<=lowerCaseCount-1;i++){
           int randomNumber= secureRandom.nextInt(122-97+1)+97;
            ch1[i]=(char)randomNumber;
        }
        return ch1;
   }
    @Override
    public char[] numberOfUpperCases(int upperCaseCount){
        char ch2[]=new char[upperCaseCount];
        for(int i=0;i<=upperCaseCount-1;i++){
            int randomNumber= secureRandom.nextInt(90-65+1)+65;
            ch2[i]=(char)randomNumber;
        }
        return ch2;
    }
    @Override
    public char[] numberOfDigits(int digitsCount){
        char ch3[]=new char[digitsCount];
        for(int i=0;i<=digitsCount-1;i++){
            int randomNumber= secureRandom.nextInt(57-48+1)+48;
            ch3[i]=(char)randomNumber;
        }
        return ch3;
    }
    @Override
    public char[] numberOfSymbols(int symbolCount){
        char ch4[]=new char[symbolCount];
        for(int i=0;i<=symbolCount-1;i++){
            int randomNumber=secureRandom.nextInt(38-35+1)+35;
            ch4[i]=(char)randomNumber;
        }
        return ch4;
    }
    // Method to generate a password based on user-defined criteria
    @Override
    public char[] generatedPassword( char[]uppercase,char[] lowerCase, char[] symbols,char[] digits) {
        char mergedArray[] = new char[uppercase.length + lowerCase.length + symbols.length + digits.length];
        try {
            if (mergedArray.length == getPasswordLength()) {
                System.arraycopy(uppercase, 0, mergedArray, 0, uppercase.length);
                System.arraycopy(lowerCase, 0, mergedArray, uppercase.length, lowerCase.length);
                System.arraycopy(symbols, 0, mergedArray, (uppercase.length + lowerCase.length), symbols.length);
                System.arraycopy(digits, 0, mergedArray, (uppercase.length + lowerCase.length + symbols.length), digits.length);
            } else {
                throw new IllegalArgumentException("invalid password length");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("An error Occured:" + e.getMessage());
            return new char[0];
        }
        return mergedArray;
    }
    // Method to take user input and generate a password
    @Override
    public char[] userGeneratedPassword() {
        Demo demo = new Demo();
        boolean flag = false;
        char[] finalPassword = new char[getPasswordLength()];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Length of password:");
        int passLen = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Number of uppercases:");
        int numOfUpperCases = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Number of Lowercases:");
        int numOfLowerCases = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Number of symbols:");
        int numOfSymbols = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Number of Digits:");
        int numOfDigits = scanner.nextInt();
        scanner.nextLine();
        scanner.close();

        if (passLen <= 0 || numOfUpperCases <= 0 || numOfLowerCases <= 0 || numOfSymbols <= 0 || numOfDigits <= 0) {
            System.out.println("Enter the postive Integer value which is more than \"0\" ");
            return new char[0];
        } else {
            demo.setPasswordLength(passLen);
            demo.setUpperCaseCount(numOfUpperCases);
            char[] uppercase = demo.numberOfUpperCases(demo.getUpperCaseCount());
            demo.setLowerCaseCount(numOfLowerCases);
            char[] lowerCase = demo.numberOfLowerCases(demo.getLowerCaseCount());
            demo.setSymbolCount(numOfSymbols);
            char[] symbols = demo.numberOfSymbols(demo.getSymbolCount());
            demo.setDigitsCount(numOfDigits);
            char[] digits = demo.numberOfDigits(demo.getDigitsCount());
            finalPassword = demo.generatedPassword(uppercase, lowerCase, symbols, digits);

        }
        return finalPassword;
    }

    }


