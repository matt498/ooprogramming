package Basics;

public class Cinema {
	protected String movie;
	protected int npeople;
	
	public Cinema(String movie, int npeople) {
		this.movie = movie;
		this.npeople = npeople;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public int getNpeople() {
		return npeople;
	}

	public void setNpeople(int npeople) {
		this.npeople = npeople;
	}
}
