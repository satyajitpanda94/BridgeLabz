package com.bridgelabz.objectorientedprogram;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bridgelabz.objectorientedprogram.commercialdataprocessing.LinkedList;
import com.bridgelabz.objectorientedprogram.commercialdataprocessing.StockAccount;

public class JsonConversion {
	private static ObjectMapper mapr = new ObjectMapper();

	public static String javaToJson(Object obj) {
		String s = "";
		try {
			s = mapr.writeValueAsString(obj);
		} catch (IOException e) {
			System.out.println("Exception during Java to Json.");
			e.printStackTrace();
		}
		return s;
	}

	public static <T> T jsonToJava(File file, TypeReference<LinkedList<StockAccount>> typeReference) {
		T result = null;
		try {
			result = mapr.readValue(file, typeReference);
		} catch (IOException e) {
			System.out.println("Exception during Json to Java.");
			e.printStackTrace();
		}
		return result;
	}

	public static <T> T jsonToJava(File file, Class<T> class1) {
		T result = null;
		try {
			result = mapr.readValue(file, class1);
		} catch (IOException e) {
			System.out.println("Exception during Json to Java.");
			e.printStackTrace();
		}
		return result;
	}
}
