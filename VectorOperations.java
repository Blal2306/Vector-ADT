import java.util.Scanner;


public class VectorOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner n = new Scanner(System.in);
		VectorADT a, b; //Stores the Vector data
		printMenu(); //initial input and print the menu
		char c = getInput();
		
		
		while(c!='Q') //the program ends on Q
		{
			switch(Character.toUpperCase(c))
			{
				case 'A' : 
			
					a = getVector(1);
					b = getVector(2);
					System.out.println("A + B : "+VectorADT.add(a,b));
					System.out.println();
					break;
				
				case 'D' : 
			
					a = getVector(1);
					b = getVector(2);
				
					while (a.getSize()!=b.getSize())
					{
						System.out.println("Vectors not equal length, Enter Again ...");
						a = getVector(1);
						b = getVector(2);
					}
				
					System.out.println("Dot product of A and B : "+VectorADT.dotProduct(a,b));
				
					System.out.println();
					break;
			
				case 'E' : 
			
					a = getVector(1);
					b = getVector(2);
				
					System.out.println("Vectors A and B are "+((a.equals(b)) ? "equal":"NOT equal"));
				
					System.out.println();
					break;
			
				case 'M' : 
			
					System.out.print("Enter the Scalar : ");
					int s = n.nextInt();
					a = getVector(1);
				
					System.out.println("The resulting vector is : "+VectorADT.multiplyByScalar(a, s));
					System.out.println();
					break;
			
				case 'S' : 
			
					a = getVector(1);
					b = getVector(2);
				
					System.out.println("A - B : "+VectorADT.subtract(a,b));
				
					System.out.println();
					break;		
			}
			printMenu();
			c = getInput();
		}
		
		System.out.println("Quiting Program ....");
		System.exit(0);
		
		
		
	}
	public static void printMenu()
	{
		System.out.println("*************************************");
		System.out.println("A\t(Add 2 Vectors)");
		System.out.println("D\t(Dot Product)");
		System.out.println("E\t(Test if 2 Vectors are Equal)");
		System.out.println("M\t(Multiply by Scalar)");
		System.out.println("S\t(Subtract 2 Vectors)");
		System.out.println("Q\t(Quit Program)");
		System.out.println();
		System.out.println("*************************************");
		
		System.out.println();
	}
	public static char getInput()
	{
		Scanner x = new Scanner(System.in);
		System.out.print("Enter Your Choice : ");
		String out = x.next();
		
		return out.charAt(0);
	}
	//Get the vector data
	public static VectorADT getVector(int x)
	{
		final int MAX_ELEMENTS = 60;
		VectorADT out;
		String[] del;
		
		//Initial input
		String userInput;
		System.out.print("Enter "+ ((x == 1) ? "First " : "Second ")+"Vector : ");
		Scanner y = new Scanner(System.in);
		userInput = y.nextLine();
		del = userInput.split(" ");
		
		//Vector length must be less than MAXIMUM allowed
		while(del.length > MAX_ELEMENTS)
		{
			System.out.println("Too many elements ... vector elements must be <= "+MAX_ELEMENTS);
			System.out.print("Enter "+ ((x == 1) ? "First " : "Second ")+"Vector : ");
			userInput = y.nextLine();
			del = userInput.split(" ");
		}
		
		
		//Insert the elements in the vector
		out = new VectorADT(del.length);
		for(int i = 0; i <= out.getSize(); i++)
		{
			out.setElements(Integer.parseInt(del[i]), i);
		}
		
		return out;
		
	}

}
