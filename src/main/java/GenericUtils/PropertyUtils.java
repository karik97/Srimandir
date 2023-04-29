package GenericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
	private Properties Read_prop;
	static FileInputStream fis;
	/**
	 *this method use to intialize the file input stream,it needs the fis_path 
	 * @param FIS_PATH
	 */
	public PropertyUtils(String fispath)
	{
		try {
			fis=new FileInputStream(fispath);
			Read_prop=new Properties();
			Read_prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param key
	 * @return
	 * this method use to read property data
	 */
	public String readData(Ennum_data key)
	{
		return Read_prop.getProperty(key.name().toLowerCase(),"please give proper key "+key.name().toLowerCase()+" ").trim();
	}

	/**@throws IOException
	 * this method is use to close the stream & property
	 */
	public void readClose()
	{
		try {
			Read_prop.clear();
			fis.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
