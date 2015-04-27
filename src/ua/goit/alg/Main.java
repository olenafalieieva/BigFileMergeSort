package ua.goit.alg;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    //public static void main(String[] args) throws IOException {
    static String property = "java.io.tmpdir";
    static String tempDir = System.getProperty(property);
	File origfile = new File("tempDir/TEST.txt");
	File result = new File("tempDir/RESULT.txt");

	File file = File.createTempFile("TMPFile", "merge", new File("tempDir/Temp"));
	//file.deleteOnExit(); 
	result = Arrays.mergeSort(origfile, 7);

	//Arrays.writeIntToFile(file, 9, 0);
//	ArrayList<File> split = Arrays.splitSort(origfile, 6);
//	printFiles(split);
	//File merge = Arrays.mergeFiles(split.get(0), split.get(1));
    }

    public static void printFiles(ArrayList<File> split) throws IOException{
	for(File part : split) {
	    printFile(part);
	}
    }
    public static void printFile(File part) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	DataInputStream fin = new DataInputStream(new FileInputStream(part));
	String name;
	boolean eof = false;
	System.out.println("Print File "+part.getName()+"? y/n");
	name = br.readLine();
	if(name.equals("y"))
	    try{
		while (!eof) {
		    System.out.println((fin.readInt()));
		} 
	    } catch (EOFException e){
		eof = true;
	    }
	fin.close();
    }


}





