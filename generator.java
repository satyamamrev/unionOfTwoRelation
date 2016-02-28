import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class generator {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		long n,r=10,size_of_file=250000000,line=0;
		Random rndm=new Random();
		ArrayList<String> attribute= new ArrayList<String>();
		ArrayList<String> records = new ArrayList<String>();
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();
		int i=0;
		
		// to generate the n number of attribute
		long startTime = System.currentTimeMillis();

		while(i<n)
		{
			int random=rndm.nextInt(3);
			switch(random)
			{
				case 0 :attribute.add(i,"char");
						break;
						
				case 1 :attribute.add(i, "date");
						break;
						
				case 2 :attribute.add(i, "int");
						break;
			}
			i++;
		}
		
		FileWriter writer=new FileWriter(new File("test.txt"));  // filewriter for entering record into file
				
		long count=0;   // to keep track of size of file
		
		while(count<size_of_file)
		{
			i=0;
			while(i<100)
			{
			
				StringBuilder record=new StringBuilder();
				int j=0;
				while(j<n)
				{
	
					switch(attribute.get(j))
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
					if(j+1!=n)
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
				System.out.println("Adding line : "+line);
				
				line++;
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
				System.out.println("Adding line : "+line);
				line++;
			}
			records.clear();
		}
		writer.flush(); 
		writer.close();
			
		long stopTime = System.currentTimeMillis();
	      long elapsedTime = stopTime - startTime;
	      System.out.println(elapsedTime);
	}

}
