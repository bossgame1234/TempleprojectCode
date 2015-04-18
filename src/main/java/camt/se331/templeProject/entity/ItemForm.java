package camt.se331.templeProject.entity;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * Created by Dell on 1/4/2558.
 */
public class ItemForm {
    private List<CommonsMultipartFile> files;
    private String tags;

    public List<CommonsMultipartFile> getFiles(){
        return  files;
    }
    public void setFile(List<CommonsMultipartFile> files){
        this.files = files;
    }
    public String getTags(){
        return tags;
    }
}
