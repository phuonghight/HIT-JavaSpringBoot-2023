package com.example.shopmanagerment.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class UploadFileCloudinary {
    @Autowired
    private Cloudinary cloudinary;

    public String getUrlFromFile(MultipartFile file) throws IOException {
        try {
//            byte[] fileBytes = file.getBytes();
//            Map params = ObjectUtils.asMap(
//                    "folder", "your-folder",
//                    "resource_type", "auto",
//                    "public_id", "custom-public-id",
//                    "tags", "image,product"
//            );
//            Map uploadResult = cloudinary.uploader().upload(fileBytes, params);
//            return uploadResult.get("secure_url").toString();

            return cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("secure_url").toString();
        } catch (IOException exception) {
            throw new IOException("Errors in file processing.", exception);
        }
    }

    public String removeFileToUrl(String imageUrl) throws IOException {
        try {
            String publicId = imageUrl.substring(imageUrl.lastIndexOf("/") + 1, imageUrl.lastIndexOf("."));
            //Todo : publicId : mã định danh duy nhất của file , đoạn code trên để trích xuất mã đấy

            cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
            //Todo : Xóa file trên cloudinary dựa trên mã đấy
            return "Remove file to url is successfully";
        } catch (IOException exception) {
            throw new IOException("Errors in file processing.", exception);
        }
    }
}
