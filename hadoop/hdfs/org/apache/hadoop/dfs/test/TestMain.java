package org.apache.hadoop.dfs.test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.net.DNS;

public class TestMain {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 * @throws SocketException 
	 */
	public static void main(String[] args) throws UnknownHostException, SocketException {
		// TODO Auto-generated method stub
		Configuration conf=new Configuration();
		String machineName = DNS.getDefaultHost(
                conf.get("dfs.datanode.dns.interface","default"),
                conf.get("dfs.datanode.dns.nameserver","default"));
		System.out.println(machineName);
		Enumeration<NetworkInterface> list=NetworkInterface.getNetworkInterfaces();
		while(list.hasMoreElements()){
			NetworkInterface netInterface=list.nextElement();
			System.out.println(netInterface);
		}
		NetworkInterface netInterface=NetworkInterface.getByName("eth2");
		System.out.println(netInterface);
		byte[] bytes=netInterface.getHardwareAddress();
		System.out.println(bytes.length);
		System.out.println(netInterface.getInetAddresses());
		Enumeration<InetAddress> addresses=netInterface.getInetAddresses();
		while(addresses.hasMoreElements()){
			System.out.println(addresses.nextElement().getCanonicalHostName());
		}
	}

}
