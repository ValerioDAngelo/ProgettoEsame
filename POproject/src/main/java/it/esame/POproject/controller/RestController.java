package it.esame.POproject.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping; //vedere eventuali eccezioni
import it.esame.POproject.utils.Service;
import it.esame.POproject.utils.test;
import it.esame.POproject.data.CompleteStats;
import it.esame.POproject.data.Tweet;
import it.esame.POproject.statistics.DayStats;
import it.esame.POproject.statistics.TimeStats;
import it.esame.POproject.statistics.day_stats;


@org.springframework.web.bind.annotation.RestController


/** Controller dell'applicazione che permette le chiamate GET, 
 * ognuna delle quali restituisce i parametri richiesti.
 * 
 */




public class RestController {
	
/**
 * restituisce sulla rotta "/Data" l'array di tweets.	
 * @return un Arraylist di <code>Tweet</code>
 */
	
@RequestMapping (value = "/Data") //se non viene scritta nessuna di queste 3, allora msg di postman

public ArrayList<Tweet> getData() {
	
	return (ArrayList<Tweet>) Service.getArray();
	
}



@RequestMapping (value = "/MetaData") 

public ArrayList<Tweet> getMetaData() {
	
	return (ArrayList<Tweet>) Service.getArray();
	
}


/**
 * restituisce sulla rotta "/TimeStats" le statistiche (min, max, avg, devst)
 * relative alle fasce orarie dei tweets.	
 * @return un oggetto di tipo <code>Stats</code>
 */


@RequestMapping (value = "/TimeStats") //devo fare double per la media, non int

public TimeStats getTimeStats() {
	
TimeStats timestats = Service.getTimeStats();	
	
	return (TimeStats) timestats;
	
}


/**
 * restituisce sulla rotta "/DayStats" le statistiche (min, max, avg, devst)
 * relative ai giorni della settimana nel periodo di Giugno 2020.	
 * @return un oggetto di tipo <code>Stats</code>
 */


@RequestMapping (value = "/DayStats") //eccezione rotta scritta male? su postman esce un errore

public DayStats getDayStats() {

DayStats daystats = Service.getDayStats();

	return (DayStats) daystats;
	
}



@RequestMapping (value = "/timeStats") 

public CompleteStats gettimeStats() {
	
CompleteStats timestats = test.getTimeStats();	
	
	return (CompleteStats) timestats;
	
}


@RequestMapping (value = "/dayStats") 

public day_stats getdayStats() {
	
day_stats daystats = test.getDayStats();	
	
	return (day_stats) daystats;
	
}


}








