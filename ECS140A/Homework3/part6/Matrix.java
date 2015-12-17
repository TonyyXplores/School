public class Matrix extends Sequence{
	private int rowsize;
	private int colsize;
	private Sequence m;

	public Matrix(int rowsize, int colsize){ //initiallize the rowsize and colsize
		this.rowsize = rowsize;
		this.colsize = colsize;
		m = new Sequence();
		for(int i=0; i<(rowsize*colsize);i++)
			m.add(new MyInteger(),i);	//adding numbers to matrix m
	}
		
	public void Set(int row, int col, int value){ //assigning value to the specific row and column
		((MyInteger)m.index((row*colsize)+col)).Set(value);
	}

	public int Get(int row, int col){ //return the value of given row and column
		return((MyInteger)m.index((row*colsize)+col)).Get();
	}
	
	public Matrix Sum(Matrix mat){ //adding matrix
		if(mat.rowsize != this.rowsize && mat.colsize != this.colsize) //error checking
			return null;
		Matrix sum = new Matrix(rowsize, colsize); //create new matrix for the sum
		int value = 0;
		for(int i=0;i<(rowsize*colsize);i++){
			value = ((MyInteger)m.index(i)).Get()+ ((MyInteger)mat.m.index(i)).Get(); //start adding
			((MyInteger)sum.m.index(i)).Set(value); //assigning value to the sum matrix
		}
		return sum;
	}

	public Matrix Product(Matrix mat){ //multiplying matrix
		if(colsize != mat.rowsize){ //error checking
			System.out.println("Matrix dimensions incompatible for Product");
			System.exit(1);
		}
		int product = 0;
		Matrix mult = new Matrix(rowsize, mat.colsize); //create new matrix for the product
		for(int i=0; i<rowsize;i++){
			for(int j=0; j<mat.colsize;j++){
				for(int k =0;k<colsize;k++){ //start multiplying
					product =((MyInteger)mult.m.index(i*mat.colsize+j)).Get()+ ((MyInteger)m.index(i*this.colsize+k)).Get() * ((MyInteger)mat.m.index(k*mat.colsize+j)).Get();
					((MyInteger)mult.m.index(i*mat.colsize+j)).Set(product); //assigning value to the product matrix
				}
			}
		}
		return mult;
	}

	public void Print(){ //printing matrix
		Matrix current = this;
		for(int i =0; i<rowsize; i++){
			System.out.print("[ ");
			for(int j=0;j<colsize;j++)
				System.out.print(((MyInteger)current.m.index(i*colsize+j)).Get()+ " ");
			System.out.println("]");
		}
	}		
	
}
