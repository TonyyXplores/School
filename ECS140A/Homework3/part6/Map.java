public class Map extends Sequence{ //extension of sequence
	public Pair p;
	public Map next;
	
	public Map(){ next = null; } //initiallize the next sequence to null
	public MapIterator begin(){ //similar method to sequence begin()
		MapIterator begin = new MapIterator();
		begin.map_it = this.copy();
		return begin;
	}
	public MapIterator end(){ //similar method to sequence end()
		MapIterator end = new MapIterator();
		end.map_it = this.copy();
		while( end.map_it.next != null ){
			end.map_it = end.map_it.next;
		}
		return end;
	}

	public void add(Pair inval){ //adding the pair value
		Map adding = new Map();
		Map current = this;
		adding.p = inval;
		if( current.length() == 0 || adding.p.c.Get() < current.p.c.Get() ){
			adding.next = current.next;
			adding.p = current.p;
			current.p = inval;
			current.next = adding;
			return;
		}
		while ( adding.p.c.Get() >= current.p.c.Get() ){	//sort of sorting before adding into the map
				if( adding.p.c.Get() == current.p.c.Get() ){
					if( current.next.next != null ){
						if( adding.p.c.Get() < current.next.p.c.Get() ){
							adding.next = current.next;
							current.next = adding;
							return;
						}
						else{
							current = current.next;
						}
					}
					else if ( current.next.next == null ){
						adding.next = current.next;
						current.next = adding;
						return;
					}	
			}
			else if ( adding.p.c.Get() > current.p.c.Get() ){
				if( current.next.next != null ){
					if( adding.p.c.Get() < current.next.p.c.Get() ){
						adding.next = current.next;
						current.next = adding;
						return;
					}
					else{
						current = current.next;
					}
				}
				else if ( current.next.next == null ){
					adding.next = current.next;
					current.next = adding;
					return;
				}
			}	
		}		
	}		
	public MapIterator find( MyChar key ){ //return the value of given key
		MapIterator m = new MapIterator();
		Map current = this;
		while( current.next!= null ){
			if( current.p.c.Get() == key.Get() ){ //checking if current character equal to key character
				m.map_it = current; //if so, assignment that value to the current 
				return m;
			}
			current = current.next; //assign current equal to the next one
		}
		m.map_it = current; //assign iterator equal to current.
		return m;
	}
	public Map copy(){ //similar method to sequence copy()
		Map deep = new Map();
		Map current = this;
		while ( current.next != null ){
				deep.add( current.p );	
			current = current.next;
		}
		return deep;
	}	
	public int length(){ //similar method to sequence length()
		int length = 0;
		Map current = this;
		while( current.next != null ){	
			length++;
			current = current.next;
		}
		return length;
	}	
	public void Print(){ //printing map
		  System.out.print( "[ ");
		  Map current = this;
		  	while( current.next != null ){ 
		  			current.p.Print();
		  			current = current.next;
		  			System.out.print( " " );
		  	}
		  System.out.print( "]" );
		 }
	
}
