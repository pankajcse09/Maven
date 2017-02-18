
package com.myapp.struts;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author kapil
 */


@WebListener // register it as you wish
public class ContainerContextClosedHandler implements ServletContextListener {
    private ScheduledExecutorService scheduler;
    private String path;
    private static final Logger log = LoggerFactory.getLogger(ContainerContextClosedHandler.class);
public ContainerContextClosedHandler() {
            // TODO Auto-generated constructor stub
        }
  @Override
    public void contextInitialized(ServletContextEvent sce) {
       //To change body of generated methods, choose Tools | Templates.
        path=sce.getServletContext().getRealPath("/downloadaudio");
//        System.out.println("path of zip file: "+path);
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new ZipDeletingSchedular(path), 1, 20, TimeUnit.HOURS);
         System.out.println("Context: "+ sce.getServletContext() +" initialized");
    }  

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {       
// Loop through all drivers
    Enumeration<Driver> drivers = DriverManager.getDrivers();
//    System.out.println("drivers.hasMoreElements() :"+ drivers.hasMoreElements());
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
//            System.out.println("Driver2 :"+ driver);
            try {
//                System.out.println("Driver3 :"+ driver +" Deregistering JDBC driver");
                log.info("Deregistering JDBC driver {}", driver);
                DriverManager.deregisterDriver(driver);
            } catch (SQLException ex) {
                log.error("Error deregistering JDBC driver {}", driver, ex); 
            }
         } 
        // MySQL driver leaves around a thread. This static method cleans it up.
        try {
            AbandonedConnectionCleanupThread.shutdown();
        } catch (InterruptedException e) {
            System.out.println("Exception occured in shutting down AbandonedConnectionCleanupThread");
        }
// shutdown scheduler     
        scheduler.shutdownNow();
    }
}