package learning.patterns.structural.decorator.file.reader.decorators;

import learning.patterns.structural.decorator.file.reader.DataSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressionDecorator extends DataSourceDecorator {
    private static final int SIZE = 512;
    private int compLevel = 6;

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        super.writeData(compress(data));
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }

    private String compress(String stringData) {
        byte[] data = stringData.getBytes();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(SIZE);
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(compLevel));
            deflaterOutputStream.write(data);
            deflaterOutputStream.close();
            byteArrayOutputStream.close();
            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray()); //TODO Why do we use encoding?
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String decompress(String readData) {
        byte[] data = Base64.getDecoder().decode(readData);
        try {
            InputStream in = new ByteArrayInputStream(data);
            InflaterInputStream iin = new InflaterInputStream(in);
            ByteArrayOutputStream bout = new ByteArrayOutputStream(SIZE);
            int b;
            while ((b = iin.read()) != -1) {
                bout.write(b);
            }
            in.close();
            iin.close();
            bout.close();
            return new String(bout.toByteArray());
        } catch (IOException ex) {
            return null;
        }
    }

    public int getCompLevel() {
        return compLevel;
    }

    public void setCompLevel(int compLevel) {
        this.compLevel = compLevel;
    }
}
