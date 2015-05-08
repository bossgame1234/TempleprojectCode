package camt.se331.templeProject.service;

import camt.se331.templeProject.entity.Gallery;
import camt.se331.templeProject.entity.Picture;

import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
public interface GalleryService {
    public List<Gallery> getGallery();
    public Gallery getGallery(Long id);
    public Gallery addGallery(Gallery gallery);
    public Gallery updateGallery(Gallery gallery);
    public Gallery deleteGallery(Long gallery);
    public Gallery addPicture(Gallery gallery,Picture picture);
    public Gallery deletePicture(Gallery gallery,Long pictureId);
}
