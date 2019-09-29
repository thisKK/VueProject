package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;


import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*")
@Data
@Entity
@NoArgsConstructor
@Table(name="MENULIST")
public class MenuList {
    @Id
    @SequenceGenerator(name="MENULIST_SEQ",sequenceName="MENULIST_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="MENULIST_SEQ")
    @Column(name="MENULIST_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String name;
    private @NonNull Integer price;
    private @NonNull Integer units;

    @OneToOne(mappedBy = "menuList", cascade = CascadeType.ALL)
    @JsonIgnore
    private MenuDesign menuDesign;


}

    