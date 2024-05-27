package org.nhom1.agilecarrentall.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.nhom1.agilecarrentall.entity.type.ImageType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Integer imageId;

    @Column(name = "image_name", nullable = false, length = 1000)
    @NotBlank
    @Size(max = 1000)
    private String imageName;

    @Column(name = "image_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ImageType imageType;

    @Column(name = "image_url", nullable = false, columnDefinition = "text")
    @NotBlank
    private String imageUrl;

    @Column(name = "image_alt", length = 1000)
    @NotBlank
    @Size(max = 1000)
    private String imageAlt;

    public Image(String imageName, ImageType imageType, String imageUrl, String imageAlt) {
        this.imageName = imageName;
        this.imageType = imageType;
        this.imageUrl = imageUrl;
        this.imageAlt = imageAlt;
    }

}
