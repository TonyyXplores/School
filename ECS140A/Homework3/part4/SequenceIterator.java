public class SequenceIterator{
	Sequence iterator;
	public boolean equal(SequenceIterator other){ //boolean function that check if the element in the sequence equal to each other
		if(this.iterator.next == other.iterator.next)
			return true;
		else
			return false;
	}

	public SequenceIterator advance(){ //move on if the next element is not null
		if(this.iterator.next != null)
			this.iterator = this.iterator.next;
		return this;
	}

	public Element get(){ //return the current element
		return this.iterator.e;
	}
}
