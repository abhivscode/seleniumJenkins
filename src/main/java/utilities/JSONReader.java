package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JSONReader {

    public static ObjectMapper mapper = new ObjectMapper();

    public static <T> T getDataFromJson(String filePath, Class<T> valueType) {
        T data = null;
        try {
            data = mapper.readValue(new File(filePath), valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
