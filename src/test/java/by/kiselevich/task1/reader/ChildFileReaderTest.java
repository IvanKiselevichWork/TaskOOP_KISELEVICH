package by.kiselevich.task1.reader;

import by.kiselevich.task1.entity.child.Child;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ChildFileReaderTest extends Assert {

    private static final String TEST_FILEPATH = "TEST.TXT";
    private ChildFileReader childFileReader = new ChildFileReader(TEST_FILEPATH);

    @After
    public void deleteTestFileIfExist() {
        File testFile = new File(TEST_FILEPATH);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    public void readChildrenFromFileTestPositive() throws IOException {
        Files.write(Paths.get(TEST_FILEPATH), "Ivan;Kiselevich;14;100;2".getBytes());

        childFileReader.setChildrenFilepath(TEST_FILEPATH);
        List<Child> children = childFileReader.readChildrenFromFile();
        assertEquals(1, children.size());
        for (Child child : children) {
            assertEquals("Ivan", child.getFirstName());
            assertEquals("Kiselevich", child.getLastName());
            assertEquals(14, child.getAge());
            assertEquals(BigDecimal.valueOf(100), child.getBudget());
            assertEquals(2, child.getHours());
        }
    }

    @Test
    public void readChildrenFromFileTestNegative1() {
        String wrongFilepath = "asdfasfdasdfasdf.txtx";

        childFileReader.setChildrenFilepath(wrongFilepath);
        List<Child> children = childFileReader.readChildrenFromFile();
        assertEquals(0, children.size());
    }

    @Test
    public void readChildrenFromFileTestNegative2() throws IOException {
        Files.write(Paths.get(TEST_FILEPATH), "asdfasfdasdf;".getBytes());

        childFileReader.setChildrenFilepath(TEST_FILEPATH);
        List<Child> children = childFileReader.readChildrenFromFile();
        assertEquals(0, children.size());
    }

}
