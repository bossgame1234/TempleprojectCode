package camt.se331.templeProject.controller;

import camt.se331.templeProject.entity.History;
import camt.se331.templeProject.entity.Picture;
import camt.se331.templeProject.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Iterator;

/**
 * Created by SONY on 4/5/2558.
 */
@Controller
@RequestMapping(value = "/picture")
public class PictureController {
    @Autowired
    HistoryService historyService;
    @RequestMapping(value = "/addHistoryPicture",method = RequestMethod.POST)
    @ResponseBody
    public History addPicture(HttpServletRequest request,
                            HttpServletResponse response,@RequestParam("historyid")Long historyId){
        MultipartHttpServletRequest mRequest;
        History history = historyService.getHistory();
        try{
            mRequest = (MultipartHttpServletRequest)request;
            Iterator<String> itr= mRequest.getFileNames();
            while(itr.hasNext()){
                MultipartFile multipartFile = mRequest.getFile(itr.next());
                Picture picture = new Picture();
                picture.setPictureName(multipartFile.getName());
                picture.setPictureType(multipartFile.getContentType());
                picture.setPictureLocation(multipartFile.getBytes());

                historyService.addPicture(history, picture);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return history;
    }
}
