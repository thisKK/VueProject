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
@Table(name = "MENU")
public class Menu {
    @Id
    @SequenceGenerator(name = "MENU_SEQ", sequenceName = "MENU_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MENU_SEQ")
    @Column(name = "MENU_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String menuName;
    private @NonNull Integer menuPrice;
    private @NonNull Integer menuUnits;

    @OneToOne(mappedBy = "menu", cascade = CascadeType.ALL)
    @JsonIgnore
    private MenuDesign menuDesign;

}
