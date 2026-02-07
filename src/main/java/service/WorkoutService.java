package com.workout.management.service;

import com.workout.management.model.Workout;
import com.workout.management.repository.WorkoutRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkoutService {
    private final WorkoutRepository repository;

    public WorkoutService(WorkoutRepository repository) {
        this.repository = repository;
    }

    public void addWorkout(Workout workout) throws Exception {
        if (workout.getName() == null || workout.getName().isEmpty()) throw new Exception("Аты бос болмауы керек!");
        repository.create(workout);
    }

    public List<Workout> getAllWorkouts() {
        return repository.findAll();
    }
}