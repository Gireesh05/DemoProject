package actualTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Date 
{
	int index=0;
	public static void main(String[] arg)
	{
		Date d=new Date();
		
		Scanner in=new Scanner(System.in);
		
		System.out.println("Enter Month"); String month=in.nextLine().toLowerCase();
		System.out.println("Enter Date"); int date=in.nextInt();
		System.out.println("Enter Year"); int year=in.nextInt();
		
		if(date<=0||date>31)
		{
			System.out.println("Invalid Date :"+date);
		}
		else if(year%4==0)
		{
			//Leap Year
			d.details(month, date, year,1);
		}
		else
			d.details(month, date, year,0);
	}
	
	public void details(String month, int date, int year, int extraDay)
	{
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		
		map.put("january", 31);
		map.put("february", 28+extraDay);
		map.put("march", 31);
		map.put("april", 30);
		map.put("may", 31);
		map.put("june", 30);
		map.put("july", 31);
		map.put("august", 31);
		map.put("september", 30);
		map.put("october", 31);
		map.put("november", 30);
		map.put("december", 31);
		
		ArrayList<String> months=new ArrayList<String>();
		
		months.add("january"); months.add("february"); months.add("march"); months.add("april"); months.add("may"); months.add("june");
		months.add("july"); months.add("august"); months.add("september"); months.add("october"); months.add("november"); months.add("december");
		
		if(map.containsKey(month))
		{
			int days=map.get(month);
			
			//December 31st
			if(month.equalsIgnoreCase("december")&&date==31)
			{
				System.out.println("Previous date :"+ (date-1)+" "+month+" "+year);
				System.out.println("Next Date :"+1+" "+months.get(0)+" "+(year+1));
			}
			else if(month.equalsIgnoreCase("january")&&date==1)
			{
				System.out.println("Previous date :"+31+" "+months.get(months.size()-1)+" "+(year-1));
				System.out.println("Next Date :"+(date+1)+" "+month+" "+year);
			} 
			else if(date==days) //For every month end except December
			{
				index=months.indexOf(month);
				System.out.println("Previous date :"+(date-1)+" "+month+" "+year);
				System.out.println("Next date :"+1+" "+months.get(index+1)+" "+year);
			}
			else if(date==1) // 1st of every month
			{
				index=months.indexOf(month);
				System.out.println("Previous date:"+map.get(months.get(index-1))+" "+months.get(index-1)+" "+year);
				System.out.println("Next date : "+(date+1)+" "+month+" "+year);
			}
			else if(date!=days)
			{
				System.out.println("Invalid Date");
			}
			else //remaining days
			{
				System.out.println("Previous Date :"+(date-1)+" "+month+" "+year);
				System.out.println("Next Date :"+(date+1)+" "+month+" "+year);
			}
		}
		else
		{
			System.out.println("Invalid Month :"+ month);
		}
		
	}

}
