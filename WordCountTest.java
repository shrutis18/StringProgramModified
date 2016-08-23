import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by shruti on 23/8/16.
 */
public class WordCountTest {

    public static File file;
    String filename="input.txt";

    @Test(expected = java.io.FileNotFoundException.class)
    public void wordCount() throws Exception {
        WordCount wb=new WordCount("input",1);
        wb.wordCount();
        wb.display();

    }

}