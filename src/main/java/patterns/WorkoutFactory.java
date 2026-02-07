package com.workout.management.patterns;

import com.workout.management.model.*;

public class WorkoutFactory {
    public static Workout createWorkout(String type, String name, int duration, double value) {
        if ("CARDIO".equalsIgnoreCase(type)) {
            return CardioWorkout.builder().name(name).durationMin(duration).avgHeartRate(value).build();
        } else if ("STRENGTH".equalsIgnoreCase(type)) {
            return StrengthWorkout.builder().name(name).durationMin(duration).totalWeight(value).build();
        }
        return null;
    }
}