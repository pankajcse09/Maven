package com.pankaj.coder.desingPatterns.creationalPatterns.singleton;

public class SingletonPatternTest {

	public static void main(String[] args) {
	
		SingletonEnum enumInstance =SingletonEnum.Instance;
		enumInstance.displayMessage();
		
		SingletonPattern instanceOne = SingletonPattern.getBillPughInstance();
	System.out.println(instanceOne);
	
	}

	
}
