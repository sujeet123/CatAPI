package com.sujeetkumar.catapp.application.dagger.module;

import android.content.Context;

import com.squareup.otto.Bus;

import com.sujeetkumar.catapp.application.CaturdayApplication;
import com.sujeetkumar.catapp.model.providers.catapi.CatApiProvider;
import com.sujeetkumar.catapp.model.providers.catapi.CatApiService;
import com.sujeetkumar.catapp.model.repository.db.FavoriteCatDbRepository;
import com.sujeetkumar.catapp.model.service.AndroidFileService;
import com.sujeetkumar.catapp.model.service.CatService;
import com.sujeetkumar.catapp.model.service.CatServiceImpl;
import com.sujeetkumar.catapp.model.service.FileService;
import com.sujeetkumar.catapp.model.service.images.StorageImageService;
import com.sujeetkumar.catapp.model.service.images.picasso.StorageImagePicassoServiceImpl;
import com.sujeetkumar.catapp.model.util.CatNameGenerator;
import com.sujeetkumar.catapp.model.util.RandomCatNameGenerator;
/*
import org.otfusion.caturday.model.repository.db.FavoriteCatDbRepository;
import org.otfusion.caturday.model.providers.catapi.CatApiProvider;
import org.otfusion.caturday.model.providers.catapi.CatApiService;
import org.otfusion.caturday.model.service.AndroidFileService;
import org.otfusion.caturday.model.service.CatService;
import org.otfusion.caturday.model.service.CatServiceImpl;
import org.otfusion.caturday.model.service.FileService;
import org.otfusion.caturday.model.service.images.StorageImageService;
import org.otfusion.caturday.model.service.images.picasso.StorageImagePicassoServiceImpl;
import org.otfusion.caturday.model.util.CatNameGenerator;
import org.otfusion.caturday.model.util.RandomCatNameGenerator;
*/

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@Module
public class ApplicationModule {

    private final CaturdayApplication application;

    public ApplicationModule(CaturdayApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public CatService provideCatService(CatApiProvider catApiProvider,
                                        FavoriteCatDbRepository favoriteCatRepository,
                                        StorageImageService storageImageService,
                                        FileService fileService) {
        return new CatServiceImpl(catApiProvider, favoriteCatRepository, storageImageService, fileService);
    }

    @Provides
    @Singleton
    public StorageImageService provideStorageImageService(FileService fileService) {
        return new StorageImagePicassoServiceImpl(application, fileService);
    }

    @Provides
    @Singleton
    public CatApiProvider provideCatApiProvider(CatApiService catApiService, Bus bus, CatNameGenerator catNameGenerator) {
        return new CatApiProvider(catApiService, bus, catNameGenerator);
    }

    @Provides
    @Singleton
    public FileService provideFileService() {
        return new AndroidFileService(application);
    }

    @Provides
    @Singleton
    public CatNameGenerator provideCatNameGenerator() {
        return new RandomCatNameGenerator();
    }

    @Provides
    @Singleton
    public FavoriteCatDbRepository provideFavoriteCatRepository() {
        return new FavoriteCatDbRepository(application);
    }

    @Provides
    @Singleton
    public CatApiService provideCatApiService() {
        Retrofit restAdapter = new Retrofit.Builder().baseUrl(CatApiProvider.ENDPOINT)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        return restAdapter.create(CatApiService.class);
    }

    @Provides
    @Singleton
    public Bus provideBus() {
        return new Bus("caturday");
    }

}
