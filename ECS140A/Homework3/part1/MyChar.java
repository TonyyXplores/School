public class MyChar extends Element{
	private char c;
	public MyChar(){c= '0';}        //Initialize the character c
	public char Get() {return this.c;} //return the current character
 	public void Set (char val) {this.c = val;} //set value for the current character.
}
