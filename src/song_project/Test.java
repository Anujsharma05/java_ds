package song_project;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		
		List<Song> songs = Songs.getSongs();
		
//		findAllRockSongs(songs);
//		exampleOne(songs);
//		listAllGenres(songs);
//		notOriginalArtist(songs);
//		sortSongs(songs);
//		joinWords(songs);
//		genreExistOrNot(songs);
//		findFirstOccurrence(songs);
		testCase(songs);
	}
	private static void testCase(List<Song> songs) {
		String s = songs.stream().map(Song::getArtist).distinct().collect(Collectors.joining(","));
		Stream s1 = songs.stream().map(Song::getArtist);
		Stream s2 = s1.distinct();
		
		System.out.println(s2.count());
//		System.out.println(s1.count());
		
	}
	
	private static void findFirstOccurrence(List<Song> songs) {
		Optional<Song> optional = songs.stream().filter(song -> song.getYear()==1995).findFirst();
		System.out.println(optional.get());
		
	}

	private static void genreExistOrNot(List<Song> songs) {
		boolean exists = songs.stream().anyMatch(song -> song.getGenre().equals("R&B"));
		System.out.println(exists);
		
	}

	private static void joinWords(List<Song> songs) {
		String s = songs.stream().map(Song::getArtist).distinct().collect(Collectors.joining(","));
		System.out.println(s);
		
	}

	private static void sortSongs(List<Song> songs) {
		
		List<Song> sorted = songs.stream().sorted(Comparator.comparingInt(Song::getYear)).collect(Collectors.toList());
		System.out.println(sorted);
	}

	private static void notOriginalArtist(List<Song> songs) {
		String songTitle = "With a Little Help from My Friends";
		
		List<String> artists = songs.stream().filter(song -> song.getTitle().equals(songTitle))
											 .map(song -> song.getArtist())
											 .filter(artist -> !artist.contains("Beatles"))
											 .collect(Collectors.toList());
		System.out.println(artists);
				
	}

	private static void listAllGenres(List<Song> songs) {
		
		//approach one
		List<String> genres = songs.stream().map(song -> song.getGenre()).distinct().collect(Collectors.toList());
		System.out.println(genres);
		
		//approach two
		Set<String> gen = songs.stream().map(song -> song.getGenre()).collect(Collectors.toSet());
		System.out.println(gen);
		
		long count = songs.stream().map(Song::getGenre).count();
		System.out.println(count);
		
	}

	static void findAllRockSongs(List<Song> songs) {
		List<Song> rockSongs = songs.stream().filter(song -> song.getGenre().contains("Rock")).collect(Collectors.toList());
		System.out.println(rockSongs);
	}
	
	static void exampleOne(List<Song> songs) {
		
		List<Song> list = songs.stream().filter(song -> song.getArtist().contains("Beatles"))
										.filter(song -> song.getTitle().startsWith("H"))
										.filter(song -> song.getYear() > 1995)
										.collect(Collectors.toList());

		list.forEach(System.out::println);
	}
	

}
