import java.util.Arrays;

import javax.management.RuntimeErrorException;


public class VectorADT implements Cloneable {

	
	int[] vector;
	
	public VectorADT(int size)
	{
		vector = new int[size];
		Arrays.fill(vector, 0);
	}
	public Object clone()
	{
		VectorADT output;
		
		try
		{
			output = (VectorADT) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			throw new RuntimeErrorException(null, "NO GOOD ....");
		}
		return output;
	}
	public boolean equals(Object obj)
	{
		VectorADT t; //the test object
		if(obj instanceof VectorADT)
		{
			t = (VectorADT) obj;
			if(t.getSize() != getSize())
				return false;
			for(int i = 0; i <= getSize(); i++)
				if(t.getElement(i) != getElement(i))
					return false;
		}
		
		return true;
	}
	public void setElements(int value, int element)
	{
		vector[element] = value;
	}
	public int getElement(int element)
	{
		return vector[element];
	}
	public int getSize()
	{
		return vector.length-1;
	}
	public static VectorADT add(VectorADT v1, VectorADT v2)
	{
		VectorADT output = ((v1.getSize()+1) > (v2.getSize()+1)) ? v1 : v2;
		int length = ((v1.getSize()+1) > (v2.getSize()+1)) ? v2.getSize()+1 : v1.getSize()+1;
		for(int i = 0; i < length; i++)
		{
			output.setElements((v1.getElement(i) + v2.getElement(i)), i);
		}
		
		return output;
		
	}
	public static VectorADT subtract(VectorADT v1, VectorADT v2)
	{
		VectorADT output = ((v1.getSize()+1) > (v2.getSize()+1)) ? v1 : v2;
		int length = ((v1.getSize()+1) > (v2.getSize()+1)) ? v2.getSize()+1 : v1.getSize()+1;
		for(int i = 0; i < length; i++)
		{
			output.setElements((v1.getElement(i) - v2.getElement(i)), i);
		}
		
		return output;
	}
	public static VectorADT multiplyByScalar(VectorADT v, int scalar)
	{
		VectorADT output = new VectorADT(v.getSize()+1);
		
		for(int i = 0; i <= v.getSize(); i++)
			output.setElements(v.getElement(i)*scalar, i);
		return output;
			
		
		
	}
	public static int dotProduct(VectorADT v1, VectorADT v2)
	{
		int output = 0;
		
		for(int i = 0 ; i <= v1.getSize(); i++)
			output+=v1.getElement(i)*v2.getElement(i);
		
		return output;
	}
	public String toString()
	{
		String output = "";
		for(int i = 0; i <= getSize(); i++)
			output+=getElement(i)+", ";
		return output;
		
	}
	
	///PRINT THE VECTOR
	public void printVector()
	{
		for(int i = 0; i < vector.length; i++)
		{
			System.out.print(vector[i]+", ");
		}
		
		System.out.println();
	}
}
