package com.workout.management.controller;

import com.workout.management.dto.WorkoutDTO;
import com.workout.management.model.Workout;
import com.workout.management.patterns.WorkoutFactory;
import com.workout.management.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {
    private final WorkoutService service;

    public WorkoutController(WorkoutService service) {
        this.service = service;
    }

    @GetMapping
    public List<Workout> getAllWorkouts() {
        return service.getAllWorkouts();
    }

    @PostMapping
    public String addWorkout(@RequestBody WorkoutDTO dto) throws Exception {
        Workout workout = WorkoutFactory.createWorkout(
                dto.getType(),
                dto.getName(),
                dto.getDurationMin(),
                dto.getSpecificValue()
        );
        service.addWorkout(workout);
        return "Workout added successfully using Factory, Builder and DTO!";
    }
}