package it.esame.POproject.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping; //vedere eventuali eccezioni
import it.esame.POproject.utils.test;
import it.esame.POproject.data.CompleteStats;
import it.esame.POproject.data.Tweet;
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
	
	return (ArrayList<Tweet>) test.getArray();
	
}


/**
 * restituisce sulla rotta "/MetaData" l'array di metadata relativi ai parametri dei tweets.	
 * @return un Arraylist di <code>Metadata</code>
 */

@RequestMapping (value = "/MetaData") 

public ArrayList<Tweet> getMetaData() {
	
	return (ArrayList<Tweet>) test.getArray();
	
}



/**
 * restituisce sulla rotta "/timeStats" le statistiche (min, max, avg, devst)
 * relative alle fasce orarie (AM, PM) dei tweets.	
 * @return un oggetto di tipo <code>CompleteStats</code>
 */


@RequestMapping (value = "/timeStats") 

public CompleteStats gettimeStats() {
	
CompleteStats timestats = test.getTimeStats();	
	
	return (CompleteStats) timestats;
	
}



/**
 * restituisce sulla rotta "/dayStats" le statistiche (min, max)
 * relative ai giorni della settimana nel periodo di Giugno 2020.	
 * @return un oggetto di tipo <code>day_stats</code>
 */


@RequestMapping (value = "/dayStats") //eccezione rotta scritta male? su postman esce un errore

public day_stats getdayStats() {
	
day_stats daystats = test.getDayStats();	
	
	return (day_stats) daystats;
	
}


}








