package camt.se331.templeProject.controller;

import camt.se331.templeProject.entity.Gallery;
import camt.se331.templeProject.entity.Picture;
import camt.se331.templeProject.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
@RestController
@RequestMapping("/")
public class GalleryController {
    @Autowired
    GalleryService galleryService;

    @RequestMapping(value = "gallery",method = RequestMethod.GET)
    public List<Gallery> getGallery(){
        return galleryService.getGallery();
    }


    @RequestMapping(value = "gallery",method = RequestMethod.POST)
    public @ResponseBody
    Gallery addGallery(@RequestBody Gallery gallery, BindingResult bindingResult){
        return galleryService.addGallery(gallery);
    }

    @RequestMapping(value = "gallery/{id}",method = RequestMethod.PUT)
    public  Gallery editGallery(@RequestBody Gallery Gallery, BindingResult bindingResult){
        return   galleryService.updateGallery(Gallery);
    }

    @RequestMapping(value = "gallery/{id}/addpicure",method = RequestMethod.PUT)
    public  Gallery addPicture(@PathVariable("id") Long id,@RequestBody Picture picture, BindingResult bindingResult){
        return   galleryService.addPicture(id,picture);
    }
    @RequestMapping(value = "gallery/{id}/deletepicure/{pictureid}",method = RequestMethod.PUT)
    public  Gallery deletePicture(@PathVariable("id") Long id,@PathVariable("pictureid") Long pictureId, BindingResult bindingResult){
        return   galleryService.deletePicture(id, pictureId);
    }
    @RequestMapping(value = "gallery/{id}/editpicure",method = RequestMethod.PUT)
    public  Gallery editPicture(@PathVariable("id") Long id,@RequestBody Picture picture, BindingResult bindingResult){
        return   galleryService.editPicture(id,picture);
    }


    @RequestMapping(value = "gallery/{id}",method = RequestMethod.DELETE)
    public Gallery deleteGallery(@PathVariable("id") Long id){
        return galleryService.deleteGallery(id);
    }


}
