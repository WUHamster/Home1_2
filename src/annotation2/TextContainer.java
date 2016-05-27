package annotation2;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by WUHamster on 27.05.2016.
 */

@SaveTo(adress = "D:\\work\\test.txt")
public class TextContainer {
    String text = "Some very important text!";


    @Saver
    public void save(String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        writer.write(text);
        writer.close();
    }
}
