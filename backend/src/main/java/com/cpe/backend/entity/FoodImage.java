package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@NoArgsConstructor
@Table(name="FOODIMAGE")
public class FoodImage {
    @Id
    @SequenceGenerator(name="FOODIMAGE_SEQ",sequenceName="FOODIMAGE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FOODIMAGE_SEQ")
    @Column(name="FOODIMAGE_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String nameImage;

    private @NonNull String urlImage;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<MenuDesign> menuDesigns;
}