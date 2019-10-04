package com.cpe.backend.menu.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
// import org.hibernate.engine.spi.CollectionEntry;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@Entity
@NoArgsConstructor
@Table(name="MENU")
public class Menu {

    @Id
    @SequenceGenerator(name = "MENU_SEQ", sequenceName = "MENU_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MENU_SEQ")
    @Column(name = "MENU_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String menuName;
    @Column(name = "menuPrice")
    private @NonNull float menuPrice;

    @Column(name = "menuUnits")
    private @NonNull Integer menuUnits;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MenuType.class)
    @JoinColumn(name = "MENUTYPE_ID",unique = true, insertable = true)
    private MenuType menuTypeID;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Nation.class)
    @JoinColumn(name = "NATION_ID", insertable = true)
    private Nation nationID;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Appropriate.class)
    @JoinColumn(name = "APPROPRIATE_ID", insertable = true)
    private Appropriate appropriateID;

}