import java.io.IOException;


public class UnionOfRelation {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		generator generate=new generator();
		generate.generateTables("table1", "table2", 1000000000, 1000000000,5, 10);
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println((float)elapsedTime/1000+"sec");

	}

}
