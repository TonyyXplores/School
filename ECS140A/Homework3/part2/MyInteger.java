public class MyInteger extends Element{
	private int num;
	public MyInteger() {num = 0;}  //Initiallize the number
	public int Get() {return this.num;}  //return the current number
	public void Set(int val) {this.num = val;}  //assign value to the current number
	public void Print(){System.out.print(num);}
}
