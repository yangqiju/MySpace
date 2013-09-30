package com.joyveb.java7.ch3;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

/**
 * Getting file and directory information
 */
public class ch3_3_DirInfo {

	private static String pathname = "C:\\go\\api\\README";

	public static void main(String[] args) throws Exception {
		Path path = FileSystems.getDefault().getPath(pathname);
		displayFileAttributes(path);
	}

	private static void displayFileAttributes(Path path) throws Exception {
		String format = "Exists: %s %n" + "notExists: %s %n"
				+ "Directory: %s %n" + "Regular: %s %n" + "Executable: %s %n"
				+ "Readable: %s %n" + "Writable: %s %n" + "Hidden: %s %n"
				+ "Symbolic: %s %n" + "Last Modified Date: %s %n"
				+ "Size: %s %n";
		System.out.printf(format,
				Files.exists(path, LinkOption.NOFOLLOW_LINKS),
				Files.notExists(path, LinkOption.NOFOLLOW_LINKS),
				Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS),
				Files.isRegularFile(path, LinkOption.NOFOLLOW_LINKS),
				Files.isExecutable(path), Files.isReadable(path),
				Files.isWritable(path), Files.isHidden(path),
				Files.isSymbolicLink(path),
				Files.getLastModifiedTime(path, LinkOption.NOFOLLOW_LINKS),
				Files.size(path));
	}

}
