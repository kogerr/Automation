
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteReader {
	private String text;

	
	private ByteReader(File targetFile) {
		try {
			FileInputStream fis = new FileInputStream(targetFile.getPath());
			byte[] data = new byte[(int) targetFile.length()];
			fis.read(data);
			fis.close();
			text = new String(data, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String read(File targetFile) {
		return new ByteReader(targetFile).text;
	}
	
}
