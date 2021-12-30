package com.pp.librarymanagement.lib;

public interface IStorageManager {
    <T> T read(DataType dataType);
    <T> void write(T data, DataType dataType);
}
