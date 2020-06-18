package uebung09;

import static pr.MakeItSimple.*;

public class Song {

	private String songName;
	private String albumName;
	private String[] artists;

	Song(String newSong) {

		if (newSong.charAt(newSong.length() - 1) == ';') {
			throw new PRException("Empty where artist name was expected.");
		} else if (newSong.charAt(0) == ';') {
			throw new PRException("Empty where song name was expected.");
		}

		String[] songArray = newSong.split(";");

		if (songArray.length < 3) {
			throw new PRException("Invalid input: " + newSong);
		}

		this.songName = songArray[0];
		this.albumName = songArray[1];
		artists = new String[songArray.length - 2];

		for (int i = 0; i + 2 < songArray.length; i++) {
			this.artists[i] = songArray[i + 2];
		}

	}

	String getSongName() {
		return this.songName;
	}

	String getAlbumName() {
		return this.albumName;
	}

	String[] getArtists() {
		return this.artists;
	}

	@Override
	public String toString() {
		String artistsString = "";

		artistsString += this.getArtists()[0];

		if (getArtists().length > 1) {
			for (int i = 1; i < this.getArtists().length; i++) {
				artistsString += ", " + this.getArtists()[i];
			}
		}

		return "Song: " + getSongName() + "\nAlbum: " + getAlbumName() + "\nBy: " + artistsString;

	}

}
