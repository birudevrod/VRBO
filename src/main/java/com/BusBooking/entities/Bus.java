package com.BusBooking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "buses")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "operator_id", referencedColumnName = "id")
    private BusOperator busOperator;

    @Column(name = "bus_type")
    private String busType;

    @Column(name = "total_seats")
    private Integer totalSeats;

    @Column(name = "amenities")
    private String amenities;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private Set<Schedule> schedules;
}

// 6 no