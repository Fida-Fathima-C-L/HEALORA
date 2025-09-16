package ui;

import dao.PetDAO;
import model.Pet;

import java.util.List;

public class petService {
    private PetDAO petDAO;

    public petService() {
        this.petDAO = new PetDAO();
    }

    // Add a new pet
    public void createPet(String name) {
        Pet pet = new Pet(name); // starts with default stats
        petDAO.addPet(pet);
    }

    // Update existing pet
    public void updatePet(Pet pet) {
        petDAO.updatePet(pet);
    }

    // Find a pet by name
    public Pet getPet(String name) {
        return petDAO.getPetByName(name);
    }

    // Show all pets
    public void listAllPets() {
        List<Pet> pets = petDAO.getAllPets();
        for (Pet p : pets) {
            System.out.println("🐾 " + p.getName() +
                    " | Level " + p.getLevel() +
                    " | ❤️ " + p.getHealth() +
                    " | 😀 " + p.getHappiness() +
                    " | ⚡ " + p.getEnergy());
        }
    }
}
