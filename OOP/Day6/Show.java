import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
class Show{

	String movieName;
	String dateTime;
	String[] seats;
	Patron[] patron;
	String[][] bookedSeats ;
	int trackBooking; 

	Show(String movieName, String dateTime, String[] seats) {
		this.movieName = movieName;
		this.dateTime = dateTime;
		this.seats = seats;
		trackBooking = 0;
		patron =  new Patron[trackBooking];
		bookedSeats = new String[trackBooking][];
	}



	void UpdateSeats(Patron _patron, String[] _seats){
		trackBooking++;
		patron = Arrays.copyOf(patron,trackBooking);
		bookedSeats = Arrays.copyOf(bookedSeats,trackBooking);
		bookedSeats[trackBooking - 1] = _seats; 
		patron[trackBooking - 1] = _patron;
	}

	void bookAShow(Patron _patron, String[] _seats ){
		int bookCount = 0;
		for (int i = 0 ; i < _seats.length ; i ++ ) {
			inner :
			for ( int y =0 ; y < seats.length ; y++ ) {
				if( _seats[i].equals(seats[y])){
					seats[y] = " ";
					bookCount ++ ;
					break inner;	
				}	
			}
		}

		if(bookCount == _seats.length){
			UpdateSeats(_patron, _seats);
			System.out.println("seats booked for " + _patron.name+ " tickets are " + Arrays.toString(_seats) );
		}else {
			System.out.println( Arrays.toString(_seats)+ "Seats already booked , Sorry " + _patron.name );
		}


	}


	void printTickets(Patron _patron){
		for (int i = 0 ; i < trackBooking ; i++) {
			if( patron[i].name.equals(_patron.name) ){
				System.out.println( _patron.name  +  " ,your seat number for "+ movieName + "on " + dateTime + "are "+ Arrays.toString(bookedSeats[i])  );
				return;
			}	
		}
		System.out.println(  _patron.name + ", Sorry no tickets are available with your crendentials");

	}


















}