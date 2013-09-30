package com.joyveb.java7.ch6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class ch6_4_SecureDirectoryStream {

	private static String pathname = "C:\\log\\test";

	public static void main(String[] args) throws IOException {
		Path path = Paths.get(pathname);
		SecureDirectoryStream<Path> sds = (SecureDirectoryStream) Files
				.newDirectoryStream(path);
		PosixFileAttributeView view = sds
				.getFileAttributeView(PosixFileAttributeView.class);
		PosixFileAttributes attributes = view.readAttributes();
		Set<PosixFilePermission> permissions = attributes.permissions();
		for (PosixFilePermission permission : permissions) {
			System.out.print(permission.toString() + ' ');
		}
		System.out.println();

	}

}
