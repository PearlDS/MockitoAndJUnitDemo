import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
//@RunWith(MockitoJunitRunner.class) --> try to fix this, why not work?!
public class AnimalTester {


    @InjectMocks
    private AnimalService animalService = new AnimalService();
    private  Animal animal;
    @Mock
    private AnimalRepository animalRepository;

    @Before
    public void makeData(){
        animal = new Animal(5, "Donkey", "Dubai");

    }

    @Test
    public void getGavoriteAnimalTester(){
        when(animalRepository.getAnimalByID(1)).thenReturn(new Animal(1,"Squirrel","England"));
        when(animalRepository.getAnimalByID(2)).thenReturn(new Animal(2,"cow","France"));
        String s = animalService.returnMyFavoriteAnimal(1);
        Assert.assertEquals("SQUIRREL", s);
        s = animalService.returnMyFavoriteAnimal(2);
        Assert.assertEquals("COW", s);

    }


    @Test
    public void testFirstLetterMethod(){

        Assert.assertEquals('s',animalService.returnFirstLetterOfAnimal("squirrel"));
    }

    @Ignore
    @Test
    public void checkIfCountryChangedInAnimal(){
        System.out.println(animal);
        animalService.changeCountryOfAnimal(animal, "Spain");
        Assert.assertEquals("Spain", animal.getCountry());

    }

    @Test
    public void checkIfCountryChangedInAnima(){
        System.out.println(animal);
        animalService.changeCountryOfAnimal(animal, "Belgium");
        Assert.assertEquals("Belgium", animal.getCountry());

    }

    @Test
    public void checkIfCountryChangedInAnim(){
        System.out.println(animal);
        animalService.changeCountryOfAnimal(animal, "Greece");
        Assert.assertEquals("Greece", animal.getCountry());

    }

    @Test
    public void asserThatTest(){

      assertThat(6).isEven().isGreaterThan(4);

      assertThat(animal.getName()).isNotBlank().startsWith("Do");

    }



}
