
import java.util.Arrays;
class BookYourShow{



	Show[] shows ;
	int trackShows;


	BookYourShow(){
		trackShows = 0;
		shows = new Show[trackShows];
	}


	void addAShow(Show show){
		trackShows++ ;
		shows = Arrays.copyOf(shows,trackShows);
		shows[trackShows - 1] = show;
	}

	Show getAShow(String movieName, String dateTime){
		for (Show show : shows ) {
			if( show.movieName.equals(movieName) && show.dateTime.equals(dateTime) ){
				return show;
			}
		}
		return null;
	}

	boolean removeMovie(String movieName, String dateTime){
		for (int  i =0 ; i < shows.length ; i ++ ) {
			if( shows[i].movieName.equals(movieName) && shows[i].dateTime.equals(dateTime)  ){
				shows[i] = new Show("","",new String[0] );
				return true;
			}
		}
		return false;
	}





}