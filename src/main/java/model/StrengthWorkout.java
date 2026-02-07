package com.workout.management.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder // Builder паттернін іске қосады
public class StrengthWorkout extends Workout {
    private double totalWeight;

    @Override
    public double calculateIntensity() {
        // Күш жаттығуларының қарқындылығын есептеу
        return totalWeight / 10.0;
    }
}