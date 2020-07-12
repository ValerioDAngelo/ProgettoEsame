package it.esame.POproject.utils;

import java.util.ArrayList;
import it.esame.POproject.data.Tweet;
import it.esame.POproject.statistics.DayStats;
import it.esame.POproject.statistics.TimeStats;

import java.util.regex.Pattern;




public class Service {
	
	
static ArrayList<Tweet> array;
	

	
public static ArrayList<Tweet> getArray() {
		return array;
	}



public static void setArray (ArrayList<Tweet> array) {
		Service.array = array;
	}

	
public static TimeStats getTimeStats () { //devo fare le statistiche sia per i retweet che per i like
	
ArrayList<Tweet> Statsarray = new ArrayList<Tweet> ();
Statsarray = Service.array;
String[] time1 = null;
String[] time2 = null;
TimeStats timeStats = new TimeStats ();

for(Tweet t : Statsarray) { 

Pattern pattern1 = Pattern.compile("\\s");
Pattern pattern2 = Pattern.compile("\\W");
time1 = pattern1.split(t.created_at);
time2 = pattern2.split(time1[3]);
int time3 = Integer.parseInt (time2[0]);
if (time3 < 13) {

timeStats.timesAM_str.add(time1[3]);	
timeStats.retweet_count_AM = t.retweet_count;
}
else {
timeStats.timesPM_str.add(time1[3]);
timeStats.retweet_count_PM = t.retweet_count;
}

}

timeStats.CalcTimeStats ();

return timeStats;	
	
}	




public static DayStats getDayStats () {
	
ArrayList<Tweet> Statsarray = new ArrayList<Tweet> ();
ArrayList<Tweet> Statsarray2 = new ArrayList<Tweet> ();
ArrayList<String> day_array = new ArrayList<String> ();
ArrayList<Tweet> Statsarray_1w = new ArrayList<Tweet> ();
ArrayList<Tweet> Statsarray_2w = new ArrayList<Tweet> ();
ArrayList<Tweet> Statsarray_3w = new ArrayList<Tweet> ();
ArrayList<Tweet> Statsarray_4w = new ArrayList<Tweet> ();
Statsarray = Service.array;
String[] day1 = null;
int number_month;
DayStats dayStats = new DayStats ();


for(Tweet t : Statsarray) {

Pattern pattern = Pattern.compile("\\s");
day1 = pattern.split(t.created_at);
number_month = Integer.parseInt(day1[2]);
if (day1[1].equals("Jun")) {

Statsarray2.add(t);
day_array.add(day1[0]);

if (number_month <= 7) Statsarray_1w.add(t);
if (number_month > 7 && number_month <= 14) Statsarray_2w.add(t);
if (number_month > 14 && number_month <= 21) Statsarray_3w.add(t);
if (number_month > 21 && number_month <= 28) Statsarray_4w.add(t);

}

}

dayStats.CalcDayStats (Statsarray2, day_array, Statsarray_1w, Statsarray_2w, Statsarray_3w, Statsarray_4w );


return dayStats;	
	
}	

}
