package com.string.calculator;

import com.string.calculator.InvalidNumber;
import com.string.calculator.StringCalculator;

public class StringCalculator {
	int Add(String numbers) throws InvalidNumber
	{
		int size= numbers.length();
		if(size>0 && numbers!=null)
		{
			String ss[]=numbers.replace("//", "").replace("[","").replace("]","").split("\n");
			StringBuffer s3 =new StringBuffer();
			for(int k=0;k<ss[0].length();k++)
			{
			s3=s3.append(ss[0].charAt(k));
			}
			String s1[] =ss[1].split("["+s3+"]");
			//System.out.println(s3);
			int sum = 0;
			int temp=0;
			String s="";
			for(int i=0;i<s1.length;i++)
			{
				temp=Integer.parseInt(s1[i]);
				if(temp<0) {
					s=s+" "+temp;
				}
				else
					if(temp>=0 && temp<=1000)
					{
				sum=sum+temp;
			}
			}
			if(s.length()>0)
			{
				throw new InvalidNumber(s);
			}
			return sum;
		}
		return 0;
	}
	private boolean isNumeric(String str) {
	    try {
	        Double.parseDouble(str);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

	private char getCustomDelimiter(String line) {
	    if (line == null || line.isEmpty()) {
	        return ',';
	    }
	    if (isNumeric(line)) {
	        return ',';
	    }
	    if (line.length() == 1) {
	        return line.charAt(0);
	    }
	    return ',';
	}
	public static void main(String[] args) throws InvalidNumber {
		StringCalculator  calculator=new StringCalculator();
		System.out.println("sum is : "+calculator.Add("//[*][%]\n1*2%3"));
		System.out.println("check is numeric or not: "+calculator.isNumeric("//[*][%]\\n1%2*6*1%2"));
	System.out.println("delimeter : "+calculator.getCustomDelimiter("//[*][%]\\n1*2%3"));
	}
}
