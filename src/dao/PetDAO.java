package dao;

import model.Pet;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {

    // Insert a new pet
    public void addPet(Pet pet) {
        String sql = "INSERT INTO pets (name, level, happiness, health, energy) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pet.getName());
            stmt.setInt(2, pet.getLevel());
            stmt.setInt(3, pet.getHappiness());
            stmt.setInt(4, pet.getHealth());
            stmt.setInt(5, pet.getEnergy());

            stmt.executeUpdate();
            System.out.println(" Pet added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get a pet by name
    public Pet getPetByName(String name) {
        String sql = "SELECT * FROM pets WHERE name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Pet(
                        rs.getString("name"),
                        rs.getInt("level"),
                        rs.getInt("happiness"),
                        rs.getInt("health"),
                        rs.getInt("energy")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // not found
    }

    // Update pet stats
    public void updatePet(Pet pet) {
        String sql = "UPDATE pets SET level=?, happiness=?, health=?, energy=? WHERE name=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pet.getLevel());
            stmt.setInt(2, pet.getHappiness());
            stmt.setInt(3, pet.getHealth());
            stmt.setInt(4, pet.getEnergy());
            stmt.setString(5, pet.getName());

            stmt.executeUpdate();
            System.out.println("✅ Pet updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all pets
    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                pets.add(new Pet(
                        rs.getString("name"),
                        rs.getInt("level"),
                        rs.getInt("happiness"),
                        rs.getInt("health"),
                        rs.getInt("energy")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }
}

