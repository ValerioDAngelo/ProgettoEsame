package it.esame.POproject.statistics;

import java.util.ArrayList;

import it.esame.POproject.data.DayStats2;
import it.esame.POproject.data.Tweet;
import java.util.regex.Pattern;

public class DayStats {

	
public int counter_Mon;
public int counter_Tue;
public int counter_Wed;
public int counter_Thu;
public int counter_Fri;
public int counter_Sat;
public int counter_Sun;
public String min_day;
public String max_day;
public double avg;
public double devst;
public String min_day_w1;
public String max_day_w1;
public double avg_w1;
public double devst_w1;
public String min_day_w2;
public String max_day_w2;
public double avg_w2;
public double devst_w2;
public String min_day_w3;
public String max_day_w3;
public double avg_w3;
public double devst_w3;
public String min_day_w4;
public String max_day_w4;
public double avg_w4;
public double devst_w4;





public void CalcDayStats (ArrayList<Tweet> Statsarray, ArrayList<String> day_array, ArrayList<Tweet> Statsarray_1w, ArrayList<Tweet> Statsarray_2w, ArrayList<Tweet> Statsarray_3w, ArrayList<Tweet> Statsarray_4w) {

	
for(String day : day_array) DayCounter (day);

DayStats2 week_stats1 = new DayStats2 ();
DayStats2 week_stats2 = new DayStats2 ();
DayStats2 week_stats3 = new DayStats2 ();
DayStats2 week_stats4 = new DayStats2 ();


CalcDayStats2 (Statsarray_1w, week_stats1);
CalcDayStats2 (Statsarray_2w, week_stats2);
CalcDayStats2 (Statsarray_3w, week_stats3);
CalcDayStats2 (Statsarray_4w, week_stats4);

this.min_day_w1 = week_stats1.min_day_w;
this.max_day_w1 = week_stats1.max_day_w;
this.avg_w1 = week_stats1.avg_w;
this.devst_w1 = week_stats1.devst_w;

this.min_day_w2 = week_stats2.min_day_w;
this.max_day_w2 = week_stats2.max_day_w;
this.avg_w2 = week_stats2.avg_w;
this.devst_w2 = week_stats2.devst_w;

this.min_day_w3 = week_stats3.min_day_w;
this.max_day_w3 = week_stats3.max_day_w;
this.avg_w3 = week_stats3.avg_w;
this.devst_w3 = week_stats3.devst_w;

this.min_day_w4 = week_stats4.min_day_w;
this.max_day_w4 = week_stats4.max_day_w;
this.avg_w4 = week_stats4.avg_w;
this.devst_w4 = week_stats4.devst_w;
	

	
}
	


	
	
public DayStats2 CalcDayStats2 (ArrayList<Tweet> week, DayStats2 week_stats) {
	
	
	week_stats.min_day_w = CalcMinDay (week);
	week_stats.max_day_w = CalcMaxDay (week);
	week_stats.avg_w = CalcAvgWeek (week);
	week_stats.devst_w = CalcDevstWeek (week);

return week_stats;

	}		
	


public void DayCounter (String day) {
	
	if (day.equals("Mon")) this.counter_Mon++ ;
	if (day.equals("Tue")) this.counter_Tue++ ;
	if (day.equals("Wed")) this.counter_Wed++ ;
	if (day.equals("Thu")) this.counter_Thu++ ;
	if (day.equals("Fri")) this.counter_Fri++ ;
	if (day.equals("Sat")) this.counter_Sat++ ;
	if (day.equals("Sun")) this.counter_Sun++ ;		
	
}
	
	
public String CalcMinDay (ArrayList<Tweet> week) {
	
//devo creare un array di day per ogni settimana

int [] counter_week = new int[7];
counter_week[0] = 0;
counter_week[1] = 0;
counter_week[2] = 0;
counter_week[3] = 0;
counter_week[4] = 0;
counter_week[5] = 0;
counter_week[6] = 0;

String [] day = null;

for(Tweet t : week) {

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


public String CalcMaxDay (ArrayList<Tweet> week)	{
	
	
	
return null;	
}
	

public double CalcAvgWeek (ArrayList<Tweet> week)	{
	
	
	
return 0;	
}


public double CalcDevstWeek (ArrayList<Tweet> week)	{
	
	
	
return 0;	
}




	public DayStats() {
		// TODO Auto-generated constructor stub
	}

}
