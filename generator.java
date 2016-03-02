import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class generator {
	
	ArrayList<String> attributes = new ArrayList<String>();
	ArrayList<String> records = new ArrayList<String>();
	
	// function used to generate tables 
	public void generateTables(String tableName1,String tableName2,long Table1Size,long Table2Size,long n,long duplicatn) throws IOException
	{
		generateAttribute(n);		// generate 'n' number of attributes 
		generateTable(tableName1, Table1Size, duplicatn); // generate first table
		generateTable(tableName2, Table2Size, duplicatn); // generate second table
		
		
		
	}
	
	// function used to generate attributes 
	public void generateAttribute(long n)
	{
		Random rndm= new Random();
		int i=0;
		while(i<n)
		{
			int random=rndm.nextInt(3);
			switch(random)
			{
				case 0 :attributes.add(i,"char");
						break;
						
				case 1 :attributes.add(i, "date");
						break;
						
				case 2 :attributes.add(i, "int");
						break;
						
			}
			i++;
		}
	}
	
	// function used to generate single table
	
	public void generateTable(String tablename,long sizeOfFile,long r) throws IOException
	{
		FileWriter writer=new FileWriter(new File(tablename)); // filewriter for entering record into file
		Random rndm=new Random();
		long count=0;
		
		while(count<sizeOfFile)
		{
			int i=0;
			while(i<100)
			{
			
				StringBuilder record=new StringBuilder();
				int j=0;
				int len=attributes.size();
				while(j<len)
				{
	
					switch(attributes.get(j))
					{
						case "char" :	StringBuilder dataset=new StringBuilder("AaXbBcdqwefAgwertQAhisjkWfSlmsnoEDp3q1rR9Dst6Quv3E4wx2Cyz1XABDCdDFDEeFGoHiIJuKLyMNtOPrQeRSwTaUVqwwerWNCXYZ");
										int x=rndm.nextInt(85);
									 	record.append(dataset.substring(x,x+10));
									 	//count+=record.length();
										break;
										
						case "date" :	record.append(rndm.nextInt(22)+10);
										record.append('/');
										record.append(rndm.nextInt(3)+10);
										record.append('/');
										record.append(rndm.nextInt(999)+2000);
										break;
										
						case "int" :	record.append(rndm.nextInt(1000000)+923102034); 	
							
										break;
					}
					if(j+1!=len)
					{
						record.append(',');
					}
					else
					{
						record.append('\n');
					}
					j++;
					
				}
				
				
				records.add(i,record.toString());
				
				writer.write(record.toString());
				count+=record.length();
				i++;
			}
			// for r % duplication
			
			long duplication=r;
			while((duplication--)>=1)
			{
				String dup=records.get(rndm.nextInt(100));
				count+=dup.length();
				writer.write(dup);
				
			}
			records.clear();
		}
		writer.flush(); 
		writer.close();
		
		
	}

}
