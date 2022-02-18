package com.company;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        FileSearchInfo info = fetchFileSearchInfo(); // get user input info (file extension, part of name, init directory)
        Set<Path> paths = new HashSet<>(); // final collection to persist found paths
        FileSearch fileSearch = new FileSearch(info, paths); // FileVisitor implementation with info and destiny collection
        Files.walkFileTree(info.getDirectory(), fileSearch); // Start searching files

        fileSearch.getPathsCollection()
                .forEach(System.out::println);  //Collection output
    }

    private static FileSearchInfo fetchFileSearchInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose directory you want to look through: ");
        String directory = sc.nextLine();
        System.out.println("Enter the file extension of the file you want to find (pdf, docx, pptx, etc.): ");
        String extension = sc.nextLine();
        System.out.println("Enter the part of name of the file desired to be found: ");
        String namePart = sc.nextLine();
        System.out.printf("Looking for *%s*.%s file in the directory: %s%n", namePart, extension, directory);

        return FileSearchInfo.createFileSearchInfo(directory, extension, namePart);
    }
}
class FileSearch implements FileVisitor<Path> {
    private final FileSearchInfo searchInfo;
    private final Collection<Path> pathsCollection;

    public Collection<Path> getPathsCollection() {
        return pathsCollection;
    }

    public FileSearch(FileSearchInfo searchInfo, Collection<Path> paths){
        this.searchInfo = searchInfo;
        this.pathsCollection = paths;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String fullFile = file.getFileName().toString();
        if (!fullFile.contains("."))
            return FileVisitResult.CONTINUE;

        String name = fullFile.split("\\.")[0];
        String ext = fullFile.split("\\.")[1];

        if (name.contains(searchInfo.getFileNamePart()) && ext.equals(searchInfo.getFileExtension()))
            pathsCollection.add(file);

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Cannot obtain access to file: " + file.getFileName().toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        boolean finishedSearch = Files.isSameFile(dir, searchInfo.getDirectory());
        if (finishedSearch)
            return FileVisitResult.TERMINATE;
        return FileVisitResult.CONTINUE;
    }
}
class FileSearchInfo {

    private final String schema = "file://";
    private final Path directory;
    private final String fileExtension;
    private final String fileNamePart;

    public static FileSearchInfo createFileSearchInfo(String directory, String fileExtension, String fileNamePart){
        return new FileSearchInfo(directory, fileExtension, fileNamePart);
    }

    private FileSearchInfo(String directory, String fileExtension, String fileNamePart) {
        this.directory = Paths.get(URI.create( schema.concat(directory) ));
        this.fileExtension = fileExtension;
        this.fileNamePart = fileNamePart;
    }

    public Path getDirectory() {
        return directory;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public String getFileNamePart() {
        return fileNamePart;
    }
}
