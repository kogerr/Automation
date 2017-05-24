import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Outsourcer {
	private static final String DIR = new String("E:\\xkovger\\esm\\usm\\doc\\");
//	private static final String DIR = new String("C:\\id\\");
	private static final File FILE = new File(DIR + "interface_descriptions.adoc");
	
	private static void writeFile(String text){
		File targetFile = FILE;
		try (BufferedWriter writer = Files.newBufferedWriter(targetFile.toPath())) {
		    writer.write(text);
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}
	
	private static void writeInc(String title, String text){
		System.out.println(DIR + "api\\" + title.toLowerCase().replace(" ", "") + ".inc");
		try {
			File targetFile = new File (DIR + "api\\" + title.toLowerCase().replace(" ", "") + ".inc");
			targetFile.createNewFile();
			BufferedWriter writer = Files.newBufferedWriter(targetFile.toPath());
			writer.write(text);
			writer.close();
		} catch (IOException x) {
		    x.printStackTrace();
		}
			
		
	}
	
	private static String toLink(String title) {
		return "\ninclude::api/" + title.toLowerCase().replace(" ", "") + ".inc[]\n";
	}
	
	private static String swap(String text) {
		String textCopy = new String(text);
//		Pattern pattern = Pattern.compile("(?s)\r\n([\\w ]+)\r\n(~+)\r\n(.+?)\r\n\\[\\[\\D+\\]\\]\r\n(\\D+)\r\n(~+)\r\n");
		Pattern pattern = Pattern.compile("(?s)\r\n([-\\w ]+)\r\n(~+)\r\n(.+?)\r\n\\[\\[[-\\w]+\\]\\]\r\n([-\\w]+)\r\n(~+)\r\n");
		Matcher matcher = pattern.matcher(text);
		int start = 0;
		int count = 0;
		while(matcher.find(start)) {
			count++;
			System.out.println(text.indexOf(matcher.group(3)));
			System.out.println(matcher.start(3));
			start = matcher.start(3);
			System.out.println("matcher.group == text.indexOf: " + (matcher.start(3)==(text.indexOf(matcher.group(3)))));

			textCopy = textCopy.replace(matcher.group(3), toLink(matcher.group(1)));
			writeInc(matcher.group(1), matcher.group(3));
						
		}
		System.out.println("count: " + count);
		return textCopy;
	}

	public static void main(String[] args) {
		String text = ByteReader.read(FILE);
		String copy = (swap(text));
		writeFile(copy);

	}

}
