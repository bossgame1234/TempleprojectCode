package camt.se331.templeProject.dao;

import camt.se331.templeProject.entity.Gallery;
import camt.se331.templeProject.entity.Picture;
import camt.se331.templeProject.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
@Profile("db.dbGalleryDao")
@Repository
public class DbGalleryDao implements GalleryDao{
    @Autowired
    GalleryRepository galleryRepository;
    @Override
    public List<Gallery> getGallery() {
        return galleryRepository.findAll();
    }

    @Override
    public Gallery getGallery(Long id) {
        return galleryRepository.findOne(id);
    }

    @Override
    public Gallery addGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    @Override
    public Gallery updateGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    @Override
    public Gallery deleteGallery(Gallery gallery) {
        galleryRepository.delete(gallery);
        gallery.setGalleryId(null);
        return gallery;
    }

}
