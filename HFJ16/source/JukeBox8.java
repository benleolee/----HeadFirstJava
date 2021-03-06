import java.util.*;
import java.io.*;

public class JukeBox8{
	ArrayList<Song> songList = new ArrayList<>();
	public static void main(String[] args){
		new JukeBox8().go();
	}

	class ArtistCompare implements Comparator<Song>{
		public int compare(Song one, Song two){
			return one.getArtist().compareTo(two.getArtist());
		}
	}

	public void go(){
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
		ArtistCompare artistCompare = new ArtistCompare();
		Collections.sort(songList, artistCompare);
		System.out.println(songList);

		TreeSet<Song> songSet = new TreeSet<Song>();
		songSet.addAll(songList);
		System.out.println(songSet);
		System.out.println("?");
	}

	public void getSongs(){
		try{
			File file = new File("JukeBox6TestFile.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine())!= null){
				addSong(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void addSong(String lineToParse){
		String[] token = lineToParse.split("/");

		Song nextSong = new Song(token[0], token[1], token[2], token[3]);
		songList.add(nextSong);
	}
}