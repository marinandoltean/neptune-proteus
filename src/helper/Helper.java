package helper;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.imageio.ImageIO;

public class Helper {
	public static class ImageHelper {
		public static String GetBase64Encoding(String urlImagine) {
			try
			{
				URL url = new URL(urlImagine);
				URLConnection urlConnection = url.openConnection();
				urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
				
				BufferedImage bufferedImage = ImageIO.read(url);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, "png", baos);
				return new String(com.sun.org.apache.xml.internal.security.utils.Base64.encode(baos.toByteArray())).replace("'", "''");
			}
			catch (Exception e)
			{
				return null;
			}			
		}
	}
}
