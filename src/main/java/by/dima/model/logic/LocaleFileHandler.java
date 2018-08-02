package by.dima.model.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class LocaleFileHandler implements FileHandler {

    @Value(value = "#{'${java.io.tmpdir}' + '${file.separator}' + 'spitter' + '${file.separator}'}")
    private String preffix;

    @Override
//    @Value("#{systemEnvironment.file.separator}")
    public void loadFile(String filename, MultipartFile file) {
        try {
            file.transferTo(new File(preffix + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File getFile(String filename) {
        return new File(preffix + filename);
    }


}
