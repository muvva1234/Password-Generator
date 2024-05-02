package com.passwordgenerator;

public interface PasswordGenerator {
    char[] numberOfLowerCases(int lowerCaseCount);
    char[] numberOfUpperCases(int upperCaseCount);
    char[] numberOfDigits(int digitsCount);
    char[] numberOfSymbols(int symbolCount);
    char[] generatedPassword( char[]uppercase,char[] lowerCase, char[] symbols,char[] digits);
    char[] userGeneratedPassword();
}
