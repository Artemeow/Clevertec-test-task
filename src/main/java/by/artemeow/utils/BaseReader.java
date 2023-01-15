package by.artemeow.utils;

import java.util.List;

public interface BaseReader<T> {

    List<T> readFile(String Path);

}
