package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;


public class excelReader {

    private static XSSFSheet mSheet;

    static configReader configReader;

    public excelReader() {
    }

    public void readExcelFile(){
        configReader = new configReader();
        if (mSheet != null){
            return;
        }
        // file path get
        File src = new File(configReader.getExcelPath());

        try {
            //read the file, streams of character decode
            FileInputStream file = new FileInputStream(src);

            //read and write excelfiles, sheets, properties
            XSSFWorkbook wb = new XSSFWorkbook(file);

            mSheet = wb.getSheetAt(0);

        } catch (Exception ex) {
            System.out.println("You got: " + ex);
        }
    }

    public static String GetCellValue(int row, int col) {
        if (mSheet == null){
            return "";
        }
        XSSFCell cell = mSheet.getRow(row).getCell(col);
        return cell.getStringCellValue();
    }


}
