package com.ddc.hdfs.test;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FSImageFileTestMain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataInputStream in=new DataInputStream(new FileInputStream("/fsimage"));
		System.out.println("image vision="+in.readInt());
		System.out.println("namespaceId="+in.readInt());
		System.out.println("numFile="+in.readLong());
		System.out.println("genstamp is :"+in.readLong());
		in.close();
	}

}
