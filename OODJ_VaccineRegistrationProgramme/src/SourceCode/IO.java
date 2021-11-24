/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

/**
 *
 * @author devil
 */
public abstract class IO {
    
    	/**
	 * Encapsulate the fileName using private keyword
	 */
        public static String path = "src/";
    	private String fileName;

	public IO(String fileName) {	
	this.fileName = fileName;
        
	}

	protected String getFileName() {
           return fileName;
	}
        
        public String getDirectory(){        
           return path+fileName;
        }
                
        public void Write(String file){};
        public void Read(String file){};
	
}
