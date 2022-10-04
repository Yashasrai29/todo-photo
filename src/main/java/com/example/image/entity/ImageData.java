package com.example.image.entity;

import lombok.*;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name="ImageData")
public class ImageData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String type;
    @Lob
    @Column(name="image_data",length = 1000)
    private byte[] imageData;
}
