package uebung09;

import static pr.MakeItSimple.*;

public class Start {

	public static void main(String[] args) {

		SongList list = new SongLinkedList();

		String[] songs = readStringArray("src/lillyUebung9/songs.txt");

		for (String songString : songs) {

			Song song = new Song(songString);

			list.addLast(song);

		}

		boolean end = false;
		while (end == false) {
			println("Enter (1) to find a song.");
			println("Enter (2) to find out the length of the list.");
			println("Enter (3) to add a new song at the end of the list.");
			println("Enter (4) to remove an element from the list.");
			println("Enter (5) to empty the list.");
			println("Enter (0) to exit the program.");
			println("***************************************************");

			int menu = readInt();

			if (menu == 1) {
				println("Please enter the song that you are looking for: ");
				String song = readString();
				if (list.contains(song)) {
					println("The list does contain the song:");
					println(list.get(list.indexOf(song)));
					println("Position of song in list: " + list.indexOf(song));
				} else {
					println("The list does not contain the song:");
				}
				println("***************************************************");
			} else if (menu == 2) {
				println("The list contains " + list.size());
				println("***************************************************");
			} else if (menu == 3) {
				println("Enter the song you want to add to the list: songName;albumName;artist - you can enter multiple artists.");
				list.addLast(new Song(readString()));
				print(list.get(list.size() - 1));
				println("***************************************************");
			} else if (menu == 4) {
				println("Enter the position of the element you want to remove from the list");
				list.remove(readInt());
				println("***************************************************");
			} else if (menu == 5) {
				list.clear();
				println("***************************************************");
			} else if (menu == 0) {
				end = true;
			}

		}

	}

}
