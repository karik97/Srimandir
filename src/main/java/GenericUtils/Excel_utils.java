package GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Kartik
 *
 */

public class Excel_utils {
	Workbook open;	
	DataFormatter df;
	/**
	 * 
	 * @param fis_path
	 */
	FileInputStream fis;
	public Excel_utils(String fis_path)
	{
		try {
			df=new DataFormatter();
			fis = new FileInputStream(fis_path);
			open=WorkbookFactory.create(fis);
		}
		catch (Exception e) {

			e.printStackTrace();
		} 
	}	
	/**
	 * this method use to close the stream & excel
	 */
	public void close()
	{
		try {
			fis.close();
			open.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> fetchTextView(String sheet) {
		ArrayList<String> arlis=new ArrayList<String>();
		Sheet sh = open.getSheet(sheet);
		for(int i=0; i<sh.getLastRowNum(); i++) {
			arlis.add(df.formatCellValue(sh.getRow(i).getCell(0)));
		}
		return arlis;
	}
	
	public ArrayList<String> rashifalElement(String sheet) {
		ArrayList<String> arlis=new ArrayList<String>();
		Sheet sh = open.getSheet(sheet);
		for(int i=0; i<sh.getLastRowNum(); i++) {
			arlis.add(df.formatCellValue(sh.getRow(i).getCell(1)));
		}
		return arlis;
	}
}




