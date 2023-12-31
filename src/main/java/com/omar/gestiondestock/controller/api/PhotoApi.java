package com.omar.gestiondestock.controller.api;


import com.flickr4java.flickr.FlickrException;
import com.omar.gestiondestock.utils.Constants;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Api("photos")
public interface PhotoApi {

    @PostMapping(Constants.APP_ROOT + "/save/{id}/{title}/{context}")
    Object savePhoto(@PathVariable("context") String context, @PathVariable("id") Integer id, @RequestPart("file") MultipartFile photo, @PathVariable(
            "title") String title) throws IOException,
            FlickrException;
}
