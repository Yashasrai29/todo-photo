package com.example.image.service;

import com.example.image.entity.ImageData;
import com.example.image.repository.ImageRepository;
import com.example.image.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData=imageRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if(imageData!=null){
            System.out.println("Added image successfully:"+file.getOriginalFilename());
        }
        return null;
    }
    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData=imageRepository.findByName(fileName);
        byte[] image=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return image;

    }


}
