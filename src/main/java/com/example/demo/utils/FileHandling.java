package com.example.demo.utils;

import java.io.File;

import com.cantire.tetris.log.TetrisLogger;

/**
 * This class provide services related to file handling
 * 
 * @author Rahil_Khan
 */
public class FileHandling {

	/**
	 * Check and create dir if it does not exist. Read more:
	 * https://www.java67.com/2014/02/how-to-create-file-and-directory-in-java.html#ixzz7ayjYCWr3
	 * 
	 * @return boolean
	 */
	public boolean checkAndCreateDirectory(String dir) {
		boolean success = false;
		File directory = new File(dir);

		if (directory.exists()) {
			TetrisLogger.debug("Directory already exists ...");
			success = true;
		} else {
			TetrisLogger.debug("Directory not exists, creating now");
			success = directory.mkdir();
			if (success) {
				TetrisLogger.debug("Successfully created new directory : %s%n", dir);
			} else {
				TetrisLogger.debug("Failed to create new directory: %s%n", dir);
			}
		}

		return success;
	}

}
