package com.joyveb.java7.ch2;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;

public class Ch2_1_PathProcess {

	public static void main(String[] args) {
		
		
		// testPath();
		// testFilePath();
		// relative2Absolute();
		// normalize();
		// combinPath();
	}

	public static void testFilePath() {
		try {
			Path path1 = Paths.get(new URI("file:///C:/go/api/README"));
			File file = new File(path1.toUri());
			Path toPath = file.toPath();
			
			Path path2 = FileSystems.getDefault().getPath("C:\\go\\api\\README");
			Iterator iterator = path2.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			
			Path path3 = Paths.get("C:", "go", "api", "README");
			System.out.println("Absolute path: " + path3.toAbsolutePath());
			System.out.println("URI: " + path3.toUri());
			System.out.println("Normalized Path: " + path3.normalize());
			System.out.println("Normalized URI: " + path3.normalize().toUri());
			System.out.println();
			
			System.out.println(toPath.equals(path1));
		} catch (URISyntaxException e) {
			System.out.println("Bad URI");
		}
	}

	public static void testPath() {
		Path path = FileSystems.getDefault().getPath("C:\\go\\api\\README");
		Iterator iterator = path.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.printf("toString: %s\n", path.toString());
		System.out.printf("getFileName: %s\n", path.getFileName());
		System.out.printf("getRoot: %s\n", path.getRoot());
		System.out.printf("getNameCount: %d\n", path.getNameCount());
		for (int index = 0; index < path.getNameCount(); index++) {
			System.out.printf("getName(%d): %s\n", index, path.getName(index));
		}
		System.out.printf("subpath(0,2): %s\n", path.subpath(0, 2));
		System.out.printf("getParent: %s\n", path.getParent());
		System.out.println(path.isAbsolute());

		try {
			path = Paths.get("C:", "go", "api", "README");
			System.out.printf("Absolute path: %s", path.toAbsolutePath());
		} catch (InvalidPathException ex) {
			System.out.printf("Bad path: [%s] at position %s", ex.getInput(),
					ex.getIndex());
		}
	}

	public static void relative2Absolute() {
		String separator = FileSystems.getDefault().getSeparator();
		System.out.println("The separator is " + separator);
		try {
			Path path = Paths.get(new URI("file:///C:/go/api/README"));
			System.out.println("subpath: " + path.subpath(0, 3));
			path = Paths.get("C:", "go", "api", "README");
			System.out.println("Absolute path: " + path.toAbsolutePath());
			System.out.println("URI: " + path.toUri());
		} catch (URISyntaxException ex) {
			System.out.println("Bad URI");
		} catch (InvalidPathException ex) {
			System.out.println("Bad path: [" + ex.getInput() + "] at position"
					+ ex.getIndex());
		}
	}

	public static void normalize() {
		Path path = Paths.get("/home/docs/../music/SpaceMachine A.mp3");
		System.out.println("Absolute path: " + path.toAbsolutePath());
		System.out.println("URI: " + path.toUri());
		System.out.println("Normalized Path: " + path.normalize());
		System.out.println("Normalized URI: " + path.normalize().toUri());
		System.out.println();
		path = Paths.get("/home/./music/ Robot Brain A.mp3");
		System.out.println("Absolute path: " + path.toAbsolutePath());
		System.out.println("URI: " + path.toUri());
		System.out.println("Normalized Path: " + path.normalize());
		System.out.println("Normalized URI: " + path.normalize().toUri());
		try {
			System.out.println("Real path: " + path.toRealPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void combinPath() {
		Path rootPath = Paths.get("C:\\go\\api\\");
		Path partialPath = Paths.get("README");
		Path resolvedPath = rootPath.resolve(partialPath);
		System.out.println("rootPath: " + rootPath);
		System.out.println("partialPath: " + partialPath);
		System.out.println("resolvedPath: " + resolvedPath);
		System.out.println("Resolved absolute path: "
				+ resolvedPath.toAbsolutePath());
	}
	
	public static void moveFile(Path arquivoOrigem, Path arquivoDestino) throws Exception { 
        Files.move(arquivoOrigem, arquivoDestino, StandardCopyOption.REPLACE_EXISTING); 
    }

    public static void copyFile(Path arquivoOrigem, Path arquivoDestino) throws Exception { 
        Files.copy(arquivoOrigem, arquivoDestino, StandardCopyOption.REPLACE_EXISTING); 
    }

    public static void deleteFile(Path arquivo) throws Exception { 
        Files.delete(arquivo); 
    }

    public static Path createFile(String arquivo) throws Exception { 
        return Files.createFile(Paths.get(arquivo)); 
    }

    public static Path createDictory(String diretorio) throws Exception { 
        return Files.createDirectories(Paths.get(diretorio)); 
    }

    public static void creatSymbolicLink(Path linkSimbolico, Path arquivo) throws Exception { 
        Files.createSymbolicLink(linkSimbolico, arquivo); 
    }

    public static void createLink(Path link, Path arquivo) throws Exception { 
        Files.createLink(link, arquivo); 
    }

}
