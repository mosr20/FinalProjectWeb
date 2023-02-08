package utilities;

import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import static utilities.GetData.getData;

public class ManageDTT {
    @DataProvider(name = "data-provider-login")
    public  Object[][] getDataObject()
    {
        return new  Object[][]{
        {"user_err_1","pass_err_1"},
        {"user_err_2","pass_err_2"},
        {"user_err_3","pass_err_3"},
        {"user_err_4","pass_err_4"},
        {"user_err_5","pass_err_5"}
        };
    }
}