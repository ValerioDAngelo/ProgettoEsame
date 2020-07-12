package it.esame.POproject.statistics;

import java.util.ArrayList;
import java.lang.Math;
import java.util.regex.Pattern;

public class TimeStats {
	

public ArrayList<String> timesAM_str = new ArrayList<String> ();
public ArrayList<String> timesPM_str = new ArrayList<String> ();
public Long retweet_count_AM;
public Long retweet_count_PM;

public String min_AM;
public String min_PM;
public String max_AM;
public String max_PM;
public String avg_AM;
public String avg_PM;
public String devst_AM;
public String devst_PM;
	
	
public void CalcTimeStats () {
	
this.min_AM = CalcMinAM ();
this.min_PM = CalcMinPM ();
this.max_AM = CalcMaxAM ();
this.max_PM = CalcMaxPM ();
this.avg_AM = CalcAvgAM ();
this.avg_PM = CalcAvgPM ();
this.devst_AM = CalcDevstAM ();
this.devst_PM = CalcDevstPM ();
	
}	





public String CalcMinAM () {


String min = this.timesAM_str.get(0);	

for (int i=1;i<timesAM_str.size();i++) 
	
	if (Conversione(timesAM_str.get(i)) < Conversione(min)) min = timesAM_str.get(i); 


return min;	
}



public String CalcMinPM () {
	
	String min = this.timesPM_str.get(0);	

	for (int i=1;i<timesPM_str.size();i++) 
		
		if (Conversione(timesPM_str.get(i)) < Conversione(min)) min = timesPM_str.get(i); 


	return min;		
}



public String CalcMaxAM () {
	
	String max = this.timesAM_str.get(0);	

	for (int i=1;i<timesAM_str.size();i++) 
		
		if (Conversione(timesAM_str.get(i)) > Conversione(max)) max = timesAM_str.get(i); 
	
return max;		
}


public String CalcMaxPM () {
	
	String max = this.timesPM_str.get(0);	

	for (int i=1;i<timesPM_str.size();i++) 
		
		if (Conversione(timesPM_str.get(i)) > Conversione(max)) max = timesPM_str.get(i); 
	
return max;		
	
}


public String CalcAvgAM () {

double avg = 0;
double sum = 0;

for(String element : timesAM_str)	sum = sum + Conversione(element);

avg = (double) (sum/timesAM_str.size()); //eccezione nel caso ci sia una divisione per zero

return AntiConversione(avg);	
}


public String CalcAvgPM () {
	
	double avg = 0;
	double sum = 0;

	for(String element : timesPM_str)	sum = sum + Conversione(element);

	avg = (double) (sum/timesPM_str.size()); //eccezione nel caso ci sia una divisione per zero

	return AntiConversione(avg);
}


public String CalcDevstAM () {
	 
	double avg = 0;
	double sum = 0;

	for(String element : timesAM_str)	sum = sum + Conversione(element);

	avg = (double) (sum/timesAM_str.size());		

double appoggio = 0;

for(String element : timesAM_str)	appoggio = appoggio + Math.pow(((double)Conversione(element))-avg, 2);

double devst = Math.sqrt(appoggio/timesAM_str.size()); //eccezione nel caso ci sia una divisione per zero

return AntiConversione(devst);	
}


public String CalcDevstPM () {
	
	double avg = 0;
	double sum = 0;

	for(String element : timesPM_str)	sum = sum + Conversione(element);

	avg = (double) (sum/timesPM_str.size());		

double appoggio = 0;

for(String element : timesPM_str)	appoggio = appoggio + Math.pow(((double)Conversione(element))-avg, 2);

double devst = Math.sqrt(appoggio/timesPM_str.size()); //eccezione nel caso ci sia una divisione per zero

return AntiConversione(devst);	
}



public int Conversione (String time) {

String [] time2;
int time3 = 0;
Pattern pattern = Pattern.compile("\\W");	
time2 = pattern.split(time);
time3 = (Integer.parseInt(time2[0])*3600) + (Integer.parseInt(time2[1])*60) + Integer.parseInt(time2[2]);
	
return time3;
}


public String AntiConversione (double time) {
	
int time2 = ((int) time)/3600;
int time3 = (((int) time)%3600);
int time4 = time3 % 60;
	

return "" + time2 + ":" + time3/60 + ":" + time4 + "";
	
}



}
