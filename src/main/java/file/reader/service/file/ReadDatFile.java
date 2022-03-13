package file.reader.service.file;

import file.reader.service.extractor.RecordExtract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ReadDatFile {

    public List<String> read(String directoryAdress) throws Exception {
        List<String> lines = new ArrayList<>();

        try (DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get(directoryAdress))) {

            for (Path file : paths) {
                BufferedReader reader = new BufferedReader(new FileReader(file.toFile()));

                String linha;
                while ((linha = reader.readLine()) != null) {
                    lines.add(linha);
                }
            }

        } catch (IOException | DirectoryIteratorException ex) {
            throw new Exception("Error reading files " + ex.getMessage());
        }

        return RecordExtract.extractRecordFromLineIfExistMoreThanOne(lines, "/");
    }
}
