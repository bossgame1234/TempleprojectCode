package camt.se331.templeProject.service;

import camt.se331.templeProject.dao.GalleryDao;
import camt.se331.templeProject.entity.Gallery;
import camt.se331.templeProject.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
@Service
public class GalleryServiceImpl implements GalleryService {
    @Autowired
    GalleryDao galleryDao;
    @Override
    public List<Gallery> getGallery() {
        return galleryDao.getGallery();
    }

    @Override
    public Gallery getGallery(Long id) {
        return galleryDao.getGallery(id);
    }

    @Override
    public Gallery addGallery(Gallery gallery) {
        return galleryDao.addGallery(gallery);
    }

    @Override
    public Gallery updateGallery(Gallery gallery) {
        return galleryDao.updateGallery(gallery);
    }

    @Override
    public Gallery deleteGallery(Long id) {
        Gallery gallery = galleryDao.getGallery(id);
        return galleryDao.deleteGallery(gallery);
    }

    @Override
    public Gallery addPicture(Long galleryId, Picture picture) {
        return galleryDao.addPicture(galleryId,picture);
    }

    @Override
    public Gallery deletePicture(Long galleryId, Long pictureId) {
        return galleryDao.deletePicture(galleryId,pictureId);
    }

    @Override
    public Gallery editPicture(Long galleryId, Picture picture) {
        return galleryDao.editPicture(galleryId,picture);
    }
}
