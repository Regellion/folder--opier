import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;


public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите адрес папки которую нужно скопировать: ");
        String from = scanner.nextLine();
        System.out.println("Укажите адрес папки в которую нужно скопировать файлы: ");
        String to = scanner.nextLine();
        try {
            myMethodCopy(from, to);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Метод копирования папки с сохранением структуры.
    private static void myMethodCopy(String from, String to) throws IOException {
        // Превращаем пути в Path'и
        Path fromPath = Paths.get(from);
        Path toPath = Paths.get(to);
        // Получаем поток из путей исходной директории
            Files.walk(fromPath)
                    .forEach(path -> {
                        try {
                            // копируем каждую папку/файл по новому пути
                            Files.copy(path, toPath.resolve(fromPath.relativize(path)));
                        } catch (IOException e) {
                            e.getMessage();
                        }
                    });
    }
}
