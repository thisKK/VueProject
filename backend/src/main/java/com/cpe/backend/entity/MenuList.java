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

    @OneToMany(fetch = FetchType.EAGER)
     private Collection<MenuDesign> menuDesign;
}

    