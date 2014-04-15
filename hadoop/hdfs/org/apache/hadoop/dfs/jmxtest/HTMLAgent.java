package org.apache.hadoop.dfs.jmxtest;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

import com.sun.jdmk.comm.HtmlAdaptorServer;

public class HTMLAgent {

    private MBeanServer mbs = null;

    public HTMLAgent() {

        // create a MBeanServer
        mbs = MBeanServerFactory.createMBeanServer("HTTPAgent");
        // create an adapter
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        // create a MBean
        TestBean mbean = new TestBean("hello boys!");
        ObjectName adapterName = null;
        ObjectName helloWorldName = null;
        try {
            adapterName = new ObjectName("HTTPAgent:name=htmladaffpter,port=9092");
            // regisetr the adapter to the MBeanServer
            mbs.registerMBean(adapter, adapterName);
            // declare the port which the adapter user
            adapter.setPort(9092);
            // start the adapter
            adapter.start();
            helloWorldName = new ObjectName("HTTPAgent:name=testMBean");
            mbs.registerMBean(mbean, helloWorldName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new HTMLAgent();
    }
}
