package com.workout.management.repository;

import com.workout.management.model.*;
import com.workout.management.utils.DatabaseConnection;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WorkoutRepository {

    public void create(Workout workout) {
        String sql = "INSERT INTO workouts (name, duration, type, specific_value) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, workout.getName());
            stmt.setInt(2, workout.getDurationMin());

            if (workout instanceof CardioWorkout) {
                stmt.setString(3, "CARDIO");
                stmt.setDouble(4, ((CardioWorkout) workout).getAvgHeartRate());
            } else if (workout instanceof StrengthWorkout) {
                stmt.setString(3, "STRENGTH");
                stmt.setDouble(4, ((StrengthWorkout) workout).getTotalWeight());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Workout> findAll() {
        List<Workout> workouts = new ArrayList<>();
        String sql = "SELECT * FROM workouts";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String type = rs.getString("type");
                if ("CARDIO".equals(type)) {
                    workouts.add(CardioWorkout.builder()
                            .id(rs.getInt("id"))
                            .name(rs.getString("name"))
                            .durationMin(rs.getInt("duration"))
                            .avgHeartRate(rs.getDouble("specific_value"))
                            .build());
                } else if ("STRENGTH".equals(type)) {
                    workouts.add(StrengthWorkout.builder()
                            .id(rs.getInt("id"))
                            .name(rs.getString("name"))
                            .durationMin(rs.getInt("duration"))
                            .totalWeight(rs.getDouble("specific_value"))
                            .build());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workouts;
    }
}