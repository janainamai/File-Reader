package file.reader;

import file.reader.service.file.ReadDatFile;
import file.reader.service.file.WriteDatFile;

import java.util.List;

public class FileReaderApplication {

    private static final ReadDatFile readDatFile = new ReadDatFile();
    private static final WriteDatFile writeDatFile = new WriteDatFile();

    public static void main(String[] args) {
        try {
            String homepath = System.getenv("HOMEPATH");

            String directoryToRead = homepath + "/data/in";
            List<String> records = readDatFile.read(directoryToRead);

            String directoryToWrite = homepath + "/data/out/result.done.dat";
            writeDatFile.createFileResult(directoryToWrite, records);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
