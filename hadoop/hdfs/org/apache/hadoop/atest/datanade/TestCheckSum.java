package org.apache.hadoop.atest.datanade;

import java.util.Random;

import org.apache.hadoop.util.DataChecksum;

public class TestCheckSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataChecksum dataChecksum=DataChecksum.newDataChecksum(1, 1024);
		byte[] dataBytes=new byte[3096];
		for(int i=0;i< dataBytes.length;i++){
			dataBytes[i]=(byte)(i%128);
		}
		dataChecksum.reset();
		dataChecksum.update(dataBytes, 0, 1024);
		System.out.println(dataChecksum.getValue()+"   "+dataChecksum.getNumBytesInSum());
		dataChecksum.update(dataBytes, 1*1024, 1024);
		System.out.println(dataChecksum.getValue()+"   "+dataChecksum.getNumBytesInSum());
		dataChecksum.update(dataBytes, 2*1024, 1024);
		System.out.println(dataChecksum.getValue()+"   "+dataChecksum.getNumBytesInSum());
		dataChecksum=DataChecksum.newDataChecksum(1, 3096);
		dataChecksum.reset();
		dataChecksum.update(dataBytes, 0, 3096);
		System.out.println(dataChecksum.getValue()+"   "+dataChecksum.getNumBytesInSum());
		
		

	}

}
