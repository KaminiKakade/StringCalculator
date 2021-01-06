package com.string.calculator;

public class InvalidNumber extends Exception {
	InvalidNumber(String s)
	{
		System.out.println("negatives not allowed "+s);
	}
}
