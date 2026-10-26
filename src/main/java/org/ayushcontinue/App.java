package org.ayushcontinue;


import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App
{
    public static void main(String[] args) throws LifecycleException {
        System.out.println("Creating Tomcat...");
        // Problem: Tomcat started, but the HTTP connector was not initialized,
        // so the browser couldn't connect to localhost:8080.

        // Fix: Set the port and initialize the connector before starting Tomcat.
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addContext("", null);

        Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
        context.addServletMappingDecoded("/hello", "HelloServlet");

        tomcat.getConnector();

        System.out.println("Starting Tomcat...");
        tomcat.start();

        System.out.println("Tomcat started. Waiting for requests...");
        tomcat.getServer().await();
    }
}
