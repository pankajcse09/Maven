package com.pankaj.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.pankaj.constants.ApplicationConstants;
import com.pankaj.exception.ApplicationException.AppException;

public class PropertyUtils {
	
	 private static HashMap<String,String> propMap; //static hashmap to store all the properties read from the properties.xml file.
	 
static 
	    {
	        try 
	        { 
	            propMap = new HashMap();
	         //   logger.info("INSIDE STATIC BLOCK OF PROPERTY UTILS");
	            String fileName = ApplicationConstants.PROPERTIES_XML_FILE_NAME ;
	          //InputStream isProp = (new PropertyUtils()).getClass().getResourceAsStream(fileName);            
	            InputStream isProp = PropertyUtils.class.getClassLoader().getResourceAsStream(fileName);
	            Properties props = new Properties();
	            props.loadFromXML(isProp);
	            Enumeration enum1 = props.keys();            
	            while(enum1.hasMoreElements())
	            {
	                String key = (String)enum1.nextElement();
	                String value = props.getProperty(key);
	                /*if(value.startsWith(FMEA_HOME))
	                {
	                    value = value.replace(FMEA_HOME,System.getProperty(FMEA_HOME));
	                }*/
	                propMap.put(key,value);
	            }
	        }
	        catch(Exception ex)
	        {
	            
	        }        
	    }
	 
	public static String getPropertyValue(String key) 
   {   
       if(propMap!=null) // check to see if the hashmap is not null
           return (String)propMap.get(key); 
       else
           return "";
   }

	public static String getValue(String id, String propertyFile) throws AppException
	{
		String value = null;
		
		
		if( id == null || "".equals(id) || propertyFile == null || "".equals(propertyFile))
			throw new AppException("The value of parameter passed in function is null or empty string");
		
		String fileName = getPropertyValue(propertyFile);
		InputStream isProp = PropertyUtils.class.getClassLoader().getResourceAsStream(fileName);
       Properties props = new Properties();
       
              
       try {
			props.loadFromXML(isProp);
		} catch (InvalidPropertiesFormatException e) {
			e.getStackTrace();
			throw new AppException("Exception occured while loading property file :"+propertyFile);
		} catch (IOException e) {
			e.getStackTrace();
			throw new AppException("Exception occured while loading property file :"+propertyFile);
		}
       Enumeration enum1 = props.keys();            
       while(enum1.hasMoreElements())
       {
           String key = (String)enum1.nextElement();
           
           if( id.equalsIgnoreCase(key))
              value = props.getProperty(key);
                     
       }

		return value;
	}
}
