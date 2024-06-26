package org.nhom1.agilecarrentall.service.common;

import org.nhom1.agilecarrentall.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FilesStorageService {
    Image save(MultipartFile file);
    List<Image> saveAll(MultipartFile[] file);
    void deleteAll(List<Image> images);
    void delete(Image image);
}
