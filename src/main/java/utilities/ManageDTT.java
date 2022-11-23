package utilities;

import org.testng.annotations.DataProvider;

import javax.xml.soap.Name;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDTT extends CommonOps{
    @DataProvider(name = "data-provider-login")
    public  Object[][] getDataObject()  {
        return getDataFromCSV(getData("DDTfile"));
    }
    public static List<String> readCSV (String csvFile)  {
        List<String> lines = null;
        File file = new File(csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return lines;

    }
    public static  Object[][] getDataFromCSV(String filepath)  {
        Object [][] data = new Object[3][2];
        List<String> csvData = readCSV(filepath);
        for (int i = 0;i<csvData.size();i++){
            data[i][0] = csvData.get(i).split(",")[0];
            data[i][1] = csvData.get(i).split(",")[1];

        }
        return data;

    }
}