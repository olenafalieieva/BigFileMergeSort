package ua.goit.alg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TestMergeSortBigFile {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    static String property = "java.io.tmpdir";
    static String tempDir = System.getProperty(property);
    
    @SuppressWarnings("deprecation")
    @Test
    public void test() throws IOException {
	
	File createdFileTested = folder.newFile("tempDir/file.txt");
	File createdFileExpected = folder.newFile("tempDir/expectedfile.txt");
	FileWriter fw1 = new FileWriter(createdFileTested);
	String cq1 = "0 9 9 9 1 3 5 7 2 3 5 8 1 8 5 3 1 8 4 5 7";
	fw1.append(cq1);
	fw1.flush();
	fw1.close();
	FileWriter fw2 = new FileWriter(createdFileExpected);
	String cq2 = "0 1 1 1 2 3 3 3 4 5 5 5 5 7 7 8 8 8 9 9 9";
	fw2.append(cq2);
	fw2.flush();
	fw2.close();
	//Arrays arrayInFile = new Arrays();
	File fileActual = Arrays.mergeSort(createdFileTested, 5);
	
	Assert.assertEquals(fileActual, createdFileExpected);
    }

}
