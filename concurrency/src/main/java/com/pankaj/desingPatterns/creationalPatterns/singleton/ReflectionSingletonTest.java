package com.pankaj.designPatterns.creationalPatterns.singleton;

import java.lang.reflect.Constructor;

/**
 * To destroy all singleton approaches
 */

public class ReflectionSingletonTest {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		EnumSingleton enumSingleton =EnumSingleton.INSTANCE;
		enumSingleton.getStringData();
		
		SingletonPattern instanceOne = SingletonPattern.getBillPughInstance();
		SingletonPattern instanceTwo = null;
		
		try {
			
			Constructor[] constructors = SingletonPattern.class.getDeclaredConstructors();
			
			for(Constructor constr:constructors ){
				/**
				 * Below code will destroy the singleton pattern
				 */
				constr.setAccessible(true);
				instanceTwo =(SingletonPattern) constr.newInstance();
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
		
	}
}
