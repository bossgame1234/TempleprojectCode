package camt.se331.templeProject.service;

import camt.se331.templeProject.dao.GalleryDao;
import camt.se331.templeProject.entity.Gallery;
import camt.se331.templeProject.entity.Picture;
import camt.se331.templeProject.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
@Service
public class GalleryServiceImpl implements GalleryService {
    @Autowired
    GalleryDao galleryDao;
    @Autowired
    PictureRepository pictureRepository;
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
        gallery.setGalleryDate(Calendar.getInstance().getTime());
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
    public Gallery addPicture(Gallery gallery, Picture picture) {
        gallery.getPictureList().add(picture);
        return galleryDao.updateGallery(gallery);
    }

    @Override
    public Gallery deletePicture(Gallery gallery, Long pictureId) {
        gallery.setPictureList(galleryDao.getGallery(gallery.getGalleryId()).getPictureList());
        Picture picture = pictureRepository.findOne(pictureId);
        gallery.getPictureList().remove(picture);
        return galleryDao.updateGallery(gallery);
    }


}
