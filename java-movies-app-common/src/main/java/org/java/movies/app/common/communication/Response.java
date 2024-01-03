/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.java.movies.app.common.communication;

import java.io.Serializable;

import org.java.movies.app.common.communication.MyException;

/**
 *
 * @author Administrator
 */
public class Response implements Serializable{
	 private Object result;
	 private MyException exception;

	    public Response() {
	    }


	    public Response(Object result, MyException exception) {
			super();
			this.result = result;
			this.exception = exception;
		}


		public MyException getException() {
			return exception;
		}


		public void setException(MyException exception) {
			this.exception = exception;
		}


		public Object getResult() {
	        return result;
	    }

	    public void setResult(Object result) {
	        this.result = result;
	    }
	    
    
    
}
