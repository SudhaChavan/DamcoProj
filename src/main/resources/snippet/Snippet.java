package snippet;

public class Snippet {
	String sheetName="PlanitTesting";
			String userDirectory = System.getProperty("user.dir");
			System.out.println("userDirectory: "+userDirectory);
			String a= userDirectory+"\\src\\main\\resources\\TestData.xlsx";
			List<Map<String,String>> testData = 
					reader.getData(a, sheetName);
}

