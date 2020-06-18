package uebung09;

public class SongLinkedListNode {

	private Song value;
	private SongLinkedListNode next;

	SongLinkedListNode(Song value, SongLinkedListNode next) {
		this.value = value;
		this.next = next;
	}

	SongLinkedListNode getNext() {

		return this.next;

	}

	void setNext(SongLinkedListNode node) {

		this.next = node;

	}

	Song getSong() {

		return this.value;

	}

}
