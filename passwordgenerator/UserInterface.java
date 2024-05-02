package com.passwordgenerator;
public class UserInterface {
    public static void main(String[] args) {
        Demo demo = new Demo();
        char[] ch = demo.userGeneratedPassword();
        for (char i : ch) {
            System.out.print(i);
        }
    }
}