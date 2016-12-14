package com.pankaj.coder.utility.ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArrayListCollection {

	public static List<String> getListWithData() {
		List<String> list = new ArrayList<String>();
		list.add("indexList01");
		list.add("indexList02");
		list.add("indexList03");
		return list;
	}

	public static Vector<String> getVectorWithData() {
		Vector<String> vector = new Vector<String>();
		vector.add("indexVector01");
		vector.add("indexVector02");
		vector.add("indexVector03");
		return vector;
	}
	
	public static Vector<Integer> getVectorWithIntData() {
		Vector<Integer> vector = new Vector<Integer>();
		vector.add(1);
		vector.add(2);
		vector.add(3);
		return vector;
	}
}
