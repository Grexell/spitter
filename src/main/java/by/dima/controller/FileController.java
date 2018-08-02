package by.dima.controller;

import by.dima.model.logic.FileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/img")
public class FileController {
    @Autowired
    private FileHandler fileHandler;

//    , produces = {""}
    @RequestMapping(value = "/{location:.+}")
    public ResponseEntity getImage(@PathVariable String location) throws IOException {
        return new ResponseEntity(Files.readAllBytes(fileHandler.getFile(location).toPath()), HttpStatus.OK);
    }
}
