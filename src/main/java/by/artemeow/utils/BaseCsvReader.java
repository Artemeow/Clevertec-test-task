package by.artemeow.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseCsvReader<T> implements BaseReader<T> {

    public List<T> readFile(String path) {
        List<String> linesOfProducts;
        List<T> entities = new ArrayList<>();

        try {
            linesOfProducts = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла " + path);
        } catch (SecurityException e) {
            throw new RuntimeException("Ошибка доступа к файлу " + path);
        }

        if (linesOfProducts.isEmpty())
            return entities;

        String[] header = linesOfProducts.get(0).split(";");
        linesOfProducts.remove(0); //удаляем 1 строку (шапку)

        linesOfProducts
                .forEach(line -> {
                    try {
                        T t = parseToEntity(line, header);
                        entities.add(t);
                    } catch (NumberFormatException e) {
                        throw new RuntimeException("Ошибка преобразования числового поля при чтении " + line);
                    }

                });
        return entities;
    }

    public abstract T parseToEntity(String line, String[] header);
    
}
