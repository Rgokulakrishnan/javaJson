package com.jsonapi.example;

import java.io.RandomAccessFile;

public class RandomAccessFileSimulation {

	public RandomAccessFile randomAccessFile () { 
		 RandomAccessFile f = null;
	try {
    f   = new RandomAccessFile("C:\\\\Users\\\\gokul\\\\Documents\\\\json\\\\StudentJson1.json", "rw");
        
        f.setLength(1024 * 1024 * 1024 * 2);
       
   } catch (Exception e) {
        System.err.println(e);
   }
	return f;
	
}
}
