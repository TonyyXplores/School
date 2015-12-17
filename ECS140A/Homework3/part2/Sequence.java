public class Sequence{
	private Element e;
	private Sequence next;
	
	public Element first(){ return this.e;} // return the first element
	
	public Sequence(){next = null;}  //initiallize the next sequence to null
	
	public Sequence rest(){ return next;} // return the next sequence
	 
	public int length(){  //return the total length of a sequence
		int length=0;
		Sequence current = this;
		while(current.next != null){ 
			length++;   //increment the count while the next element is not null
			current = current.next; //assign the current sequence to the next one
		}
		return length;  //return the number of count
	}

	public void add(Element elm, int pos){  //adding element at a specific position
		Sequence adding = new Sequence();
		if(pos <0 || pos>length()){  //if position is greater than the sequence length or less than 0, return an error and exit
			System.err.print("Position is not exists\n");
			System.exit(1);
		}
		else if(pos ==0){ //if position is equal to zero, set the next adding sequence to the current, the next adding element to the current
			adding.next = next;
			adding.e = e;
			e = elm;
			next = adding;
			return;
		}
		adding.e = elm; 
		Sequence current = this;
		for(int i=0; i<pos-1;i++)  //assign the current to the next one
			current=current.next;
		adding.next = current.next;
		current.next = adding;
		return;
	}
	
	public void delete(int pos){  //remove element at specific position
		Sequence current = this;
		if(pos<0 || pos >= current.length())
			return;
		for(int i=0; i<pos;i++)
			current= current.next;
		current.e = current.next.e;
		current.next = current.next.next;
		return;
	}
	
	public void Print(){  //printing sequence
		System.out.print("[ ");
		Sequence current = this;
		while(current.next != null){
			current.e.Print();
			System.out.print(" ");
			current = current.next;
		}

		System.out.print("]");
	}
}
