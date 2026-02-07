package com.workout.management.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@SuperBuilder // Бұл Builder паттернін іске қосады
public abstract class Workout {
    private int id;
    private String name;
    private int durationMin;

    public abstract double calculateIntensity();
}