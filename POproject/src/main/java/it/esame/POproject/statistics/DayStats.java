package it.esame.POproject.statistics;

import java.util.ArrayList;

import it.esame.POproject.data.Tweet;

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
	


public void CalcDayStats (ArrayList<Tweet> Statsarray, ArrayList<String> day_array) {

	
for(String day : day_array) DayCounter (day);

//passo pure l'array di numero del mese e qui divido per settimana, poi faccio le funzioni per tutte le 4 settimane
CalcDayStats2 ();


}	


	
	
public void CalcDayStats2 () {
	
	
	this.min_day = CalcMinDay ();
	this.max_day = CalcMaxDay ();
	this.avg = CalcAvgWeek ();
	this.devst = CalcDevstWeek ();
		
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
	
	
public String CalcMinDay () {
	
	
return null;	
}


public String CalcMaxDay ()	{
	
	
	
return null;	
}
	

public double CalcAvgWeek ()	{
	
	
	
return 0;	
}


public double CalcDevstWeek ()	{
	
	
	
return 0;	
}




	public DayStats() {
		// TODO Auto-generated constructor stub
	}

}
