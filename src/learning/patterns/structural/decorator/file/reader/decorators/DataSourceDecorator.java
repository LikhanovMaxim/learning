package learning.patterns.structural.decorator.file.reader.decorators;

import learning.patterns.structural.decorator.file.reader.DataSource;

public abstract class DataSourceDecorator implements DataSource {
    private final DataSource wrapper;

    DataSourceDecorator(DataSource source) {
        wrapper = source;
    }

    @Override
    public void writeData(String data) {
        wrapper.writeData(data);
    }

    @Override
    public String readData() {
        return wrapper.readData();
    }
}
