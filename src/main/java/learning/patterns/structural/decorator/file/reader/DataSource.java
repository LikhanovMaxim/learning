package learning.patterns.structural.decorator.file.reader;

public interface DataSource {
    void writeData(String data);

    String readData();
}
