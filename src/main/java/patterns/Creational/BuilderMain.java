package patterns.Creational;

import java.util.*;


public class BuilderMain {

	private Document document ;
	
	public static void main(String[] args) {

		List<String> dataToConvert = new ArrayList<String>();
		dataToConvert.add("1");
		dataToConvert.add("2");
		dataToConvert.add("3");
		BuilderMain builder = new BuilderMain();
		builder.getASCIIConverted(dataToConvert);
	}

	public void getASCIIConverted(List<String> dataToConvert)
	{
		TextConverter converter = new ASCIIConverter();
		DocumentCreator docCreator = new DocumentCreator();
		docCreator.setConverter(converter);
		
		StringBuilder sb = new StringBuilder(document.getDoc());
		for(String data :  dataToConvert)
		{
			sb.append(docCreator.getConvertedString(data));
		}
		
		document.setDoc(sb.toString());
	}
	
	
}
//Builder Interface
interface TextConverter
{

	public String convertText(String txt);

}
//Concrete builder
class BinaryConverter implements TextConverter
{

	@Override
	public String convertText(String txt) {
		return txt+" :BINARY";
	}
	
}
//Concrete builder
class ASCIIConverter implements TextConverter
{

	@Override
	public String convertText(String txt) {
		return txt+" :ASCII";
	}

}

//Director
class DocumentCreator
{
 private TextConverter converter;

public void setConverter(TextConverter converter) {
	this.converter = converter;
}

public TextConverter getConverter() {
	return converter;
}	


public String getConvertedString(String rawFile){

	return converter.convertText(rawFile);
}

}

//Product
class Document
{
private String doc;

public String getDoc() {
	return doc;
}

public void setDoc(String doc) {
	this.doc = doc;
}

}