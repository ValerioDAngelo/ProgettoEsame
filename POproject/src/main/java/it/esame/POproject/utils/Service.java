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
//System.out.println(time1[3]);
time2 = pattern2.split(time1[3]);
int time3 = Integer.parseInt (time2[0]);
if (time3 < 13) {

timeStats.timesAM_str.add(time1[3]);	
//timeStats.timesAM.add(time3); 
timeStats.retweet_count_AM = t.retweet_count;
}
else {
timeStats.timesPM_str.add(time1[3]);
//timeStats.timesPM.add(time3);
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
Statsarray = Service.array;
String[] day1 = null;
DayStats dayStats = new DayStats ();


for(Tweet t : Statsarray) {

Pattern pattern = Pattern.compile("\\s");
day1 = pattern.split(t.created_at);
if (day1[1].equals("Jun")) {

Statsarray2.add(t);
day_array.add(day1[0]);


}

}

dayStats.CalcDayStats (Statsarray2, day_array);


return dayStats;	
	
}	

}
