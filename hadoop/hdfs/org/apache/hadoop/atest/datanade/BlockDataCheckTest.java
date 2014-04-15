package org.apache.hadoop.atest.datanade;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.hadoop.util.DataChecksum;

public class BlockDataCheckTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//meta文件
		DataInputStream checksumIn= new DataInputStream(new BufferedInputStream(new FileInputStream("D:/hdfs/blk_-8834172473825889857_1040.meta"), 1024));
		//block文件，数据格式：bytesPerChecksum的数据,bytesPerChecksum的数据,bytesPerChecksum的数据,bytesPerChecksum的数据,bytesPerChecksum的数据。。。。。。。。。
		DataInputStream dataIn=new DataInputStream(new BufferedInputStream(new FileInputStream("D:/hdfs/blk_-8834172473825889857"), 1024));
		//meta文件数据：数据version(shot),checkType(byte,0--无校验，1--CRC32校验),bytesPerChecksum(每多少数据做一次校验),bytesPerChecksum个byte数据的校验码,bytesPerChecksum个byte数据的校验码,bytesPerChecksum个byte数据的校验码。。。。。。。
		short version=checksumIn.readShort();
		byte checkType=checksumIn.readByte();
		int bytesPerChecksum=checksumIn.readInt();
		System.out.println(version+"   "+checkType+"   "+bytesPerChecksum);
		DataChecksum dataChecksum=DataChecksum.newDataChecksum(checkType, bytesPerChecksum);
		byte[]  dataBytes=new byte[bytesPerChecksum];
		byte[]  checkBytes=new byte[dataChecksum.getChecksumSize()];
		int readLen=0;
		while((readLen=dataIn.read(dataBytes))>0){
			checksumIn.read(checkBytes);
			dataChecksum.reset();
			dataChecksum.update(dataBytes, 0, dataBytes.length);
			if(dataChecksum.compare(checkBytes, 0)){
				System.out.println("right !!"+"   data size is :"+readLen);
			}else{
				System.err.println("wrong !!");
				throw new RuntimeException("-------------------");
			}
			Thread.sleep(5000L);
		}
		dataIn.close();
		checksumIn.close();
	}
}
