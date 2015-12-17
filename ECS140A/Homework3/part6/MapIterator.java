
public class MapIterator extends SequenceIterator{

	public Map map_it;
	
	public boolean equal( MapIterator other ){ //similar method to SequenceIterator equal()
		if( this.map_it.next == other.map_it.next ){
			return true;
		}
		return false;
	}
	public MapIterator advance(){  //similar method to SequenceIterator advance()
			if( this.map_it.next != null ){
				this.map_it = this.map_it.next;
			}
		return this;
	}
	public Pair get(){ //return the current pair
		return this.map_it.p;
	}
	
}
