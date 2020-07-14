package it.esame.POproject.statistics;

import java.util.ArrayList;

import it.esame.POproject.data.Tweet;
import java.util.regex.Pattern;


public class day_stats {


	public static String min_day_w1;
	public static String max_day_w1;
	public static String min_day_w2;
	public static String max_day_w2;
	public static String min_day_w3;
	public static String max_day_w3;
	public static String min_day_w4;
	public static String max_day_w4;






	public static void CalcDayStats (ArrayList<Tweet> Statsarray_1w, ArrayList<Tweet> Statsarray_2w, ArrayList<Tweet> Statsarray_3w, ArrayList<Tweet> Statsarray_4w) {

		day_stats.min_day_w1 = CalcMinDay(Statsarray_1w);	
		day_stats.max_day_w1 = CalcMaxDay(Statsarray_1w);	
			
		
		day_stats.min_day_w2 = CalcMinDay(Statsarray_2w);	
		day_stats.max_day_w2 = CalcMaxDay(Statsarray_2w);	
			
		
		day_stats.min_day_w3 = CalcMinDay(Statsarray_3w);	
		day_stats.max_day_w3 = CalcMaxDay(Statsarray_3w);	
			
		
		day_stats.min_day_w4 = CalcMinDay(Statsarray_4w);	
		day_stats.max_day_w4 = CalcMaxDay(Statsarray_4w);	
			
		
		
	}
		

	
		
		
	public static String CalcMinDay (ArrayList<Tweet> Statsarray_w) {
		

	int [] counter_week = new int[7];
	
	for (int i = 1; i<7; i++) counter_week[i] = 0;

	String [] day = null;

	for(Tweet t : Statsarray_w) {

	Pattern pattern = Pattern.compile("\\s");
	day = pattern.split(t.created_at);

	if (day[0].equals("Mon")) counter_week[0]++ ;
	if (day[0].equals("Tue")) counter_week[1]++ ;
	if (day[0].equals("Wed")) counter_week[2]++ ;
	if (day[0].equals("Thu")) counter_week[3]++ ;
	if (day[0].equals("Fri")) counter_week[4]++ ;
	if (day[0].equals("Sat")) counter_week[5]++ ;
	if (day[0].equals("Sun")) counter_week[6]++ ;		
	}

	int min = counter_week[0];

	for (int i = 1; i<7; i++) if (counter_week[i]<min)  min = counter_week[i];
		

	if (min == counter_week[0]) return "Mon";
	else if (min == counter_week[1]) return "Tue";
	else if (min == counter_week[2]) return "Wed";
	else if (min == counter_week[3]) return "Thu";
	else if (min == counter_week[4]) return "Fri";
	else if (min == counter_week[5]) return "Sat";
	else if (min == counter_week[6]) return "Sun";


	return null;	

	}


	public static String CalcMaxDay (ArrayList<Tweet> Statsarray_w)	{
		
		int [] counter_week = new int[7];
		
		for (int i = 1; i<7; i++) counter_week[i] = 0;

		String [] day = null;

		for(Tweet t : Statsarray_w) {

		Pattern pattern = Pattern.compile("\\s");
		day = pattern.split(t.created_at);

		if (day[0].equals("Mon")) counter_week[0]++ ;
		if (day[0].equals("Tue")) counter_week[1]++ ;
		if (day[0].equals("Wed")) counter_week[2]++ ;
		if (day[0].equals("Thu")) counter_week[3]++ ;
		if (day[0].equals("Fri")) counter_week[4]++ ;
		if (day[0].equals("Sat")) counter_week[5]++ ;
		if (day[0].equals("Sun")) counter_week[6]++ ;		
		}

		int max = counter_week[0];

		for (int i = 1; i<7; i++) if (counter_week[i]<max)  max = counter_week[i];
			

		if (max == counter_week[0]) return "Mon";
		else if (max == counter_week[1]) return "Tue";
		else if (max == counter_week[2]) return "Wed";
		else if (max == counter_week[3]) return "Thu";
		else if (max == counter_week[4]) return "Fri";
		else if (max == counter_week[5]) return "Sat";
		else if (max == counter_week[6]) return "Sun";
	
		
	return null;	
	}
		






	public String getMin_day_w1() {
		return min_day_w1;
	}





	public void setMin_day_w1(String min_day_w1) {
		day_stats.min_day_w1 = min_day_w1;
	}





	public String getMax_day_w1() {
		return max_day_w1;
	}





	public void setMax_day_w1(String max_day_w1) {
		day_stats.max_day_w1 = max_day_w1;
	}






	public String getMin_day_w2() {
		return min_day_w2;
	}





	public void setMin_day_w2(String min_day_w2) {
		day_stats.min_day_w2 = min_day_w2;
	}





	public String getMax_day_w2() {
		return max_day_w2;
	}





	public void setMax_day_w2(String max_day_w2) {
		day_stats.max_day_w2 = max_day_w2;
	}












	public String getMin_day_w3() {
		return min_day_w3;
	}





	public void setMin_day_w3(String min_day_w3) {
		day_stats.min_day_w3 = min_day_w3;
	}





	public String getMax_day_w3() {
		return max_day_w3;
	}





	public void setMax_day_w3(String max_day_w3) {
		day_stats.max_day_w3 = max_day_w3;
	}








	public String getMin_day_w4() {
		return min_day_w4;
	}





	public void setMin_day_w4(String min_day_w4) {
		day_stats.min_day_w4 = min_day_w4;
	}





	public String getMax_day_w4() {
		return max_day_w4;
	}





	public void setMax_day_w4(String max_day_w4) {
		day_stats.max_day_w4 = max_day_w4;
	}


	
}
