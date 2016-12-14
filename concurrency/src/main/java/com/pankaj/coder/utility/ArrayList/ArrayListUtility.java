package com.pankaj.coder.utility.ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArrayListUtility {

	/**
	 * addElementAtIndes method to add value
	 * At given index of ArrayList
	 * @param index
	 * @author pankajbharti
	 */
	public static void addElementAtIndes(int index) {
		List<String> list = ArrayListCollection.getListWithData();
		list.add(index, "A4");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void appendElementOfOtherCollection() {
		List<String> list = ArrayListCollection.getListWithData();
		//Vector<String> vector =ArrayListCollection.getVectorWithData();
		Vector<Integer> intVector =ArrayListCollection.getVectorWithIntData();
		list.add(String.valueOf(intVector));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
