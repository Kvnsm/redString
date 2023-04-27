package fr.schoolbyhiit.portailformation.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Mapper
@Builder
@Table(schema = "portail_formation")
public class Course {

    @Id
    @Column(name = "id_course")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, unique = true, nullable = false)
    private String name;

    @Column
    private String referee;

    @Column(nullable = false)
    private Long totalHourCount;

    @ManyToOne
    @JoinColumn(name = "id_module")
    private Module module;
}
