package java_eight.song_project;

public class Song {

	private String title;
	private String artist;
	private String genre;
	private int year;
	private int timesPlayed;

	public Song() {}
	
	public Song(String title, String artist, String genre, int year, int timesPlayed) {
		super();
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.year = year;
		this.timesPlayed = timesPlayed;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getGenre() {
		return genre;
	}

	public int getYear() {
		return year;
	}

	public int getTimesPlayed() {
		return timesPlayed;
	}
	
	public boolean randomTestMethod() {
		return true;
	}

	@Override
	public String toString() {
		return "Song [title=" + title + ", artist=" + artist + ", genre=" + genre + ", year=" + year + ", timesPlayed="
				+ timesPlayed + "]";
	}

}
