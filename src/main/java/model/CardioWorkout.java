package com.workout.management.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@NoArgsConstructor
@SuperBuilder
public class CardioWorkout extends Workout {
    private double avgHeartRate;

    @Override
    public double calculateIntensity() { return avgHeartRate / 2.0; }
}