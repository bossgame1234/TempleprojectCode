package camt.se331.templeProject.dao;

import camt.se331.templeProject.entity.Gallery;
import camt.se331.templeProject.entity.Picture;

import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
public interface GalleryDao {
public List<Gallery> getGallery();
public Gallery getGallery(Long id);
public Gallery addGallery(Gallery gallery);
public Gallery updateGallery(Gallery gallery);
public Gallery deleteGallery(Gallery gallery);
}
