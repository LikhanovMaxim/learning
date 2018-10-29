package learning.patterns.structural.decorator.file.reader.decorators;

import learning.patterns.structural.decorator.file.reader.DataSource;

import java.util.Base64;

public class EncryptionDecorator extends DataSourceDecorator {

    private static final int SHIFT = 1;

    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        super.writeData(encode(data));
    }

    private String encode(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) SHIFT;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    @Override
    public String readData() {
        return decode(super.readData());
    }

    private String decode(String data) {
        byte[] result = Base64.getDecoder().decode(data);

        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) SHIFT;
        }

        return new String(result);
    }
}
