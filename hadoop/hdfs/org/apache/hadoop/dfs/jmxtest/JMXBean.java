package org.apache.hadoop.dfs.jmxtest;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class JMXBean {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws NullPointerException 
	 * @throws MalformedObjectNameException 
	 * @throws NotCompliantMBeanException 
	 * @throws MBeanRegistrationException 
	 * @throws InstanceAlreadyExistsException 
	 */
	public static void main(String[] args) throws InterruptedException, MalformedObjectNameException, NullPointerException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
		// TODO Auto-generated method stub
		MBeanServer mbs = MBeanServerFactory.createMBeanServer("HTTPAgent");
		ObjectName helloWorldName=new ObjectName("HTTPAgent:name=testMBean");
		TestBean mbean = new TestBean("hello boys!");
		mbs.registerMBean(mbean, helloWorldName);
		while(!mbean.getField().equals("stop")){
			System.out.println();
			Thread.sleep(3500L);
		}
	}

}
