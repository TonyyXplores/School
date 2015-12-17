
public class Pair extends Element {
	public MyChar c;
	public Element e;
	
	public Pair ( MyChar c, Element e ){ //initiallize the character c and element e
		this.c = c;
		this.e = e;
	}
	public void Print(){ //printing pair
		System.out.print( "('" + c.Get() + "' ");
		this.e.Print();
		System.out.print( ")" );
	}
	
	
	
	
}
