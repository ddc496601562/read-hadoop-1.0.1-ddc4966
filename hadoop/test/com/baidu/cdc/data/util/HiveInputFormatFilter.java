package baidu.cdc.data.util;


import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.JobConfigurable;
/**
 * 
 * @author dingdongchao
 * a filter for exculde some files in hive inputFormat path .
 */
public class HiveInputFormatFilter  implements PathFilter ,JobConfigurable{
	public static String REGUL_NAME="hive.partition.file.filter";
	//filter  regular  ，Java  regular  
	private String regularRule="";
	@Override
	public boolean accept(Path path) {
		String name=path.getName();
		if(regularRule!=null)
			return !name.matches(regularRule);
		try {
			FileSystem.get(null, null);
			URI uri=new URI("hdfs://hy-ecomoff-hdfs.dmop.baidu.com:54310");
			System.out.println(uri.getScheme());
			String disableCacheName = String.format("fs.%s.impl.disable.cache", uri.getScheme());
			System.out.println(disableCacheName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public void configure(JobConf job) {
		regularRule=job.get(REGUL_NAME, null);
		System.out.println("load this class success!!!");
	}
	public static void  main(String[]  args){
		
		System.out.println("000760".matches("@manifest.*"));
	}
	 FileSystem  kk ;
	 

}
