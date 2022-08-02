import java.util.Scanner;

public class AnimalService {


    private AnimalRepository animalRepository;

    public AnimalService() {
    }

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public char returnFirstLetterOfAnimal(String name){

        return name.charAt(0);
    }

    public void changeCountryOfAnimal(Animal animal, String country){
        animal.setCountry(country);
    }




    public String returnMyFavoriteAnimal(int id){

        return animalRepository.getAnimalByID(id).getName().toUpperCase();
    }

}
