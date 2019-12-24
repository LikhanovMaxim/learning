package learning.patterns.structural.decorator;

import learning.patterns.structural.decorator.file.reader.DataSource;
import learning.patterns.structural.decorator.file.reader.FileDataSource;
import learning.patterns.structural.decorator.file.reader.decorators.CompressionDecorator;
import learning.patterns.structural.decorator.file.reader.decorators.DataSourceDecorator;
import learning.patterns.structural.decorator.file.reader.decorators.EncryptionDecorator;

public class App {

    private static final String OUT_OUTPUT_DEMO_TXT = "out/OutputDemo.txt";

    public static void main(String[] args) {
        System.out.println("1) Simple file");
        DataSource simpleFile = new FileDataSource(OUT_OUTPUT_DEMO_TXT);
        writeAndRead(simpleFile);

        System.out.println("\n2) With encoding");
        DataSourceDecorator encoded = new EncryptionDecorator(
                new FileDataSource(OUT_OUTPUT_DEMO_TXT));
        writeAndRead(encoded);

        System.out.println("\n3) With encoding and compression");
        DataSourceDecorator compress = new CompressionDecorator(
                new FileDataSource(OUT_OUTPUT_DEMO_TXT));
        writeAndRead(compress);

        System.out.println("\n4) With encoding and compression");
        DataSourceDecorator encodedAndCompress = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource(OUT_OUTPUT_DEMO_TXT)));
        writeAndRead(encodedAndCompress);
    }

    private static void writeAndRead(DataSource encoded) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
//        DataSourceDecorator encoded = getDataSourceDecorator();
        encoded.writeData(salaryRecords);

        DataSource plain = new FileDataSource(OUT_OUTPUT_DEMO_TXT);

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }

}
