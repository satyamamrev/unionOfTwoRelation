import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;


public class UnionOfRelation {
	
		static long SizeOfBuffer=1024;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		generator generate=new generator();
		generate.generateTables("table1", "table2",1*1024*1024 , 1*1024*1024,5, 10);
		unionOfTable1AndTable2("table1", "table2");
		
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println((float)elapsedTime/1000+"sec");

	}
	
	public static void unionOfTable1AndTable2(String table1,String table2) throws IOException
	{
		HashSet<String> set = new HashSet<String>();
		BufferedReader reader = new BufferedReader(new FileReader(table1));
		BufferedReader reader1 = new BufferedReader(new FileReader(table2));
		FileWriter writer = new FileWriter(new File("UnionFile"));
		String line1=null;
		String line2=null;
		ArrayList<String> buffer = new ArrayList<String>();
		int count=0,flag=0;
		/*while((line1=reader.readLine())!=null || (line2=reader1.readLine())!=null )
		{
			
			//count+=line1.length()+line2.length();
			if(line1!=null)
				count+=line1.length();
			if(line2!=null)
				count+=line2.length();
			if(count>UnionOfRelation.SizeOfBuffer)
			{
				for(int i=0;i<buffer.size();i++)
					writer.write(buffer.get(i)+"\n");
				buffer.clear();
				count=0;
				flag=1;
				
			}
			if(!set.contains(line1) && line1!=null)
				buffer.add(line1);
			if(!set.contains(line2) && line2!=null)
				buffer.add(line2);
			
		}*/
		while((line1=reader.readLine())!=null)
		{
			if(!set.contains(line1))
			{
				buffer.add(line1);
				set.add(line1);
				count+=line1.length();
			}

			if(count>UnionOfRelation.SizeOfBuffer)
			{
				for(int i=0;i<buffer.size();i++)
					writer.write(buffer.get(i)+"\n");
				buffer.clear();
				count=0;
				flag=1;
			}
			else
			{
				flag=0;
			}
			
		}
		if(flag==0)
		{
			for(int i=0;i<buffer.size();i++)
				writer.write(buffer.get(i)+"\n");
		}
		buffer.clear();
		flag=0;
		while((line2=reader1.readLine())!=null)
		{
			if(!set.contains(line2))
			{
				buffer.add(line2);
				set.add(line2);
				count+=line2.length();
			}

			if(count>UnionOfRelation.SizeOfBuffer)
			{
				for(int i=0;i<buffer.size();i++)
					writer.write(buffer.get(i)+"\n");
				buffer.clear();
				count=0;
				flag=1;
			}
			else
			{
				flag=0;
			}
			
		}
		if(flag==0)
		{
			for(int i=0;i<buffer.size();i++)
				writer.write(buffer.get(i)+"\n");
		}
		buffer.clear();
		writer.close();
		
	}

}
