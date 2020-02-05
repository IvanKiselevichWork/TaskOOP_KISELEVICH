package by.kiselevich.task1.reader;

import by.kiselevich.task1.entity.toy.Cube;
import by.kiselevich.task1.entity.toy.Toy;
import by.kiselevich.task1.entity.toy.ToySize;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ToyFileReaderTest extends Assert {

    private static final String TEST_FILEPATH = "TEST.TXT";
    private ToyFileReader toyFileReader = new ToyFileReader(TEST_FILEPATH);

    @After
    public void deleteTestFileIfExist() {
        File testFile = new File(TEST_FILEPATH);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    public void readToysTestPositive() throws IOException {
        Files.write(Paths.get(TEST_FILEPATH), "CUBE;MEDIUM;12;3".getBytes());

        toyFileReader.setToyFilepath(TEST_FILEPATH);
        List<Toy> toys = toyFileReader.readToys();
        for (Toy toy : toys) {
            assertEquals(BigDecimal.valueOf(12),toy.getCost());
            assertEquals(ToySize.MEDIUM,toy.getSize());
            assertEquals(Cube.class,toy.getClass());
        }
    }

    @Test
    public void readToysTestNegative1() throws IOException {
        String wrongFilepath = "asdfasfdasdf.sdfasdf";

        toyFileReader.setToyFilepath(wrongFilepath);
        List<Toy> toys = toyFileReader.readToys();
        assertEquals(0, toys.size());
    }

    @Test
    public void readToysTestNegative2() throws IOException {
        Files.write(Paths.get(TEST_FILEPATH), "45545; 545 452 ;".getBytes());

        toyFileReader.setToyFilepath(TEST_FILEPATH);
        List<Toy> toys = toyFileReader.readToys();
        assertEquals(0, toys.size());
    }
}
