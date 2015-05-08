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
    @RequestMapping(value = "gallery/{id}",method = RequestMethod.GET)
    public Gallery getGallery(@PathVariable("id")Long pictureId){
        return galleryService.getGallery(pictureId);
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
    @RequestMapping(value = "gallery/deletepicure/{pictureid}",method = RequestMethod.PUT)
    public  Gallery deletePicture(@RequestBody Gallery gallery,@PathVariable("pictureid") Long pictureId, BindingResult bindingResult){
        return   galleryService.deletePicture(gallery, pictureId);
    }


    @RequestMapping(value = "gallery/{id}",method = RequestMethod.DELETE)
    public Gallery deleteGallery(@PathVariable("id") Long id){
        return galleryService.deleteGallery(id);
    }


}
