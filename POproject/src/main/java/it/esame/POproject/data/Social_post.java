package it.esame.POproject.data;



public class Social_post {

	
	
	public String created_at = "";
	public String text = "";
	public Long favourites_count;




	public Long getFavourites_count() {
		return favourites_count;
	}

	public void setFavourites_count(Long favourites_count) {
		this.favourites_count = favourites_count;
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



	
	
	public Social_post() {
		// TODO Auto-generated constructor stub
	}

}
