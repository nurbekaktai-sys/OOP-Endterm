package com.workout.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutDTO {
    private String name;
    private int durationMin;
    private String type; // CARDIO немесе STRENGTH
    private double specificValue; // avgHeartRate немесе totalWeight
}