package uebung09;

import static pr.MakeItSimple.*;

public class SongLinkedList implements SongList {

	private SongLinkedListNode head = null;

	@Override
	public void addLast(Song s) {

		// new node element
		SongLinkedListNode newNode = new SongLinkedListNode(s, null);

		// list is empty
		SongLinkedListNode currentNode = head;
		if (currentNode == null) {
			head = newNode;
		}

		// list contains elements
		else {
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(newNode);

		}
	}

	@Override
	public void remove(int position) {

		if (position < 0 || this.size() <= position) {
			throw new PRException("Position " + position + " cannot be found in list.");
		}

		// change next pointer of the element one before element on position
		if (position == 0) {
			this.head = getElementAt(position).getNext();
		} else {
			getElementAt(position - 1).setNext(getElementAt(position).getNext());
		}
	}

	// Hilfsmethode:
	SongLinkedListNode getElementAt(int position) {

		int currentPosition = 0;
		SongLinkedListNode currentNode = head;

		while (currentPosition < position) {
			currentPosition++;
			currentNode = currentNode.getNext();
		}

		return currentNode;

	}

	@Override
	public int size() {
		if (head == null) {
			return 0;
		} else {
			int size = 1;
			SongLinkedListNode currentNode = head;
			while (currentNode.getNext() != null) {
				size++;
				currentNode = currentNode.getNext();
			}

			return size;
		}

	}

	@Override
	public Song get(int position) {

		if (position < 0 || this.size() <= position) {
			throw new PRException("Position cannot be found in list.");
		}

		return getElementAt(position).getSong();

	}

	@Override
	public void clear() {

		head = null;

	}

	@Override
	public boolean contains(String songName) {

		if (this.size() < 1) {
			throw new PRException("List is empty.");
		}

		for (int i = 0; i < this.size(); i++) {
			if (get(i).getSongName().equals(songName)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public int indexOf(String songName) {

		if (this.size() < 1) {
			throw new PRException("List is empty.");
		}

		int index = 0;

		// iterate through list to find element
		while (index < this.size()) {
			if (get(index).getSongName().equals(songName)) {
				return index;
			}
			index++;
		}

		// doesn't contain searched element
		return -1;

	}

}
