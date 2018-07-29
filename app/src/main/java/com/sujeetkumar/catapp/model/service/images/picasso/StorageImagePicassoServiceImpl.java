package com.sujeetkumar.catapp.model.service.images.picasso;

import android.content.Context;
import android.media.MediaScannerConnection;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.sujeetkumar.catapp.common.domain.Cat;
import com.sujeetkumar.catapp.model.service.FileService;
import com.sujeetkumar.catapp.model.service.images.StorageImageService;

import java.io.File;

import javax.inject.Inject;

public class StorageImagePicassoServiceImpl implements StorageImageService {

    private final Context context;
    private final FileService fileService;

    @Inject
    public StorageImagePicassoServiceImpl(Context context, FileService fileService) {
        this.context = context;
        this.fileService = fileService;
    }

    @Override
    public void saveImageIntoStorage(Cat cat) {
        File file = fileService.getFile(cat);
        Target target = new StorageTarget(cat, context, file);
        Picasso.with(context).load(cat.getImageUrl()).into(target);
    }

    @Override
    public void deleteImageFromStorage(Cat cat) {
        File file = fileService.getFile(cat);
        if (file != null) {
            file.delete();
            MediaScannerConnection.scanFile(context, new String[]{file.getPath()}, null, null);
        }
    }
}
