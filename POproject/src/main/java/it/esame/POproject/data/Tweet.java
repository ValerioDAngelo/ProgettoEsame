package it.esame.POproject.data;



public class Tweet {

	
	
public String created_at = "";
public String text = "";
public Boolean retweeted;
public Long retweet_count;
public Long favorite_count;




public Long getFavorite_count() {
	return favorite_count;
}

public void setFavorite_count(Long favorite_count) {
	this.favorite_count = favorite_count;
}




public Long getRetweet_count() {
	return retweet_count;
}

public void setRetweet_count(Long retweet_count) {
	this.retweet_count = retweet_count;
}




public String getCreated_at() {
	return created_at;
}

public void setCreated_at(String created_at) {
	this.created_at = created_at;
}




public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}




public Boolean getRetweeted() {
	return retweeted;
}

public void setRetweeted(Boolean retweeted) {
	this.retweeted = retweeted;
}

public Tweet() {

super();

	// TODO Auto-generated constructor stub
}	






}
