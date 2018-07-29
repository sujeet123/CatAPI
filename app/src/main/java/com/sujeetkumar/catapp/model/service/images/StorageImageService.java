package com.sujeetkumar.catapp.model.service.images;


import com.sujeetkumar.catapp.common.domain.Cat;

public interface StorageImageService {

    String FOLDER_NAME = "voted_cats";

    void saveImageIntoStorage(Cat cat);

    void deleteImageFromStorage(Cat cat);

}
