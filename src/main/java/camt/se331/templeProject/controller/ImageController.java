package camt.se331.templeProject.controller;

import camt.se331.templeProject.entity.ItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.logging.Logger;

/**
 * Created by Dell on 1/4/2558.
 */
@RestController
@RequestMapping("/")
public class ImageController {

        @ResponseStatus(HttpStatus.OK)
        @RequestMapping(value = "/upload")
        public void upload(@RequestParam("file") MultipartFile file, @RequestParam("username") String username ) throws IOException {

            byte[] bytes;

            if (!file.isEmpty()) {
                bytes = file.getBytes();
                //store file in storage
            }

            System.out.println(String.format("receive %s from %s", file.getOriginalFilename(), username));
        }


    }

