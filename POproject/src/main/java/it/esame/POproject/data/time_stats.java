package it.esame.POproject.data;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class time_stats {

String min;
String max;
String avg;
String devst;




public void CalcTimeStats (ArrayList<String> times) {
	
this.min = CalcMin (times);
this.max = CalcMax (times);
this.avg = CalcAvg (times);
this.devst = CalcDevst (times);
	
}	

	
public String CalcMin (ArrayList<String> times) {


String min = times.get(0);	

for (int i=1;i<times.size();i++) 
	
	if (Conversione(times.get(i)) < Conversione(min)) min = times.get(i); 


return min;	
}


public String CalcMax (ArrayList<String> times) {
	
	String max = times.get(0);	

	for (int i=1;i<times.size();i++) 
		
		if (Conversione(times.get(i)) > Conversione(max)) max = times.get(i); 
	
return max;		
}


public String CalcAvg (ArrayList<String> times) {

double avg = 0;
double sum = 0;

for(String element : times)	sum = sum + Conversione(element);

avg = (double) (sum/times.size()); //eccezione nel caso ci sia una divisione per zero

return AntiConversione(avg);	
}



public String CalcDevst (ArrayList<String> times) {
	 
	double avg = 0;
	double sum = 0;

	for(String element : times)	sum = sum + Conversione(element);

	avg = (double) (sum/times.size());		

double appoggio = 0;

for(String element : times)	appoggio = appoggio + Math.pow(((double)Conversione(element))-avg, 2);

double devst = Math.sqrt(appoggio/times.size()); //eccezione nel caso ci sia una divisione per zero

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



public String getMin() {
	return min;
}


public void setMin(String min) {
	this.min = min;
}


public String getMax() {
	return max;
}


public void setMax(String max) {
	this.max = max;
}


public String getAvg() {
	return avg;
}


public void setAvg(String avg) {
	this.avg = avg;
}


public String getDevst() {
	return devst;
}


public void setDevst(String devst) {
	this.devst = devst;
}


public String AntiConversione (double time) {
	
int time2 = ((int) time)/3600;
int time3 = (((int) time)%3600);
int time4 = time3 % 60;
	

return "" + time2 + ":" + time3/60 + ":" + time4 + "";
	
}
	
	
	
	
	
	
	public time_stats() {
		// TODO Auto-generated constructor stub
	}

}
