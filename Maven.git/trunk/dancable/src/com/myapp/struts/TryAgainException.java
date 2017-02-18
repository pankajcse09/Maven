/*
 * TryAgainException.java
 *
 * Created on April 18, 2008, 4:12 PM
 */

 package com.myapp.struts;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Ashish
 * @version
 */
public class TryAgainException extends ServletException {
        
   public TryAgainException(String msg,Throwable cause)
   {
       super(msg,cause);
   
   
   }    
}
