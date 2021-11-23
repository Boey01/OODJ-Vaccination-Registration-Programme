/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_vaccineregistrationprogramme;

/**
 *
 * @author devil
 */
public class File {
    	/**
	 * Encapsulate the fileName using private keyword
	 */
	private final String fileName;

	public File(String fileName) {
		
		this.fileName = fileName;
	}

	protected String getFileName() {
		return fileName;
	}
	
}
