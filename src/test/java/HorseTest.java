import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;



class HorseTest {
    Horse horse = new Horse("inga", 5.0, 1.0);
    Horse hor = new Horse("inga", 5.0);
    @Test
    void ifNameNullThrowsException(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,() ->new Horse(null, 5.0));
    }

    @Test
    void ifNameNullWritesMessage(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,() ->new Horse(null, 5.0));
    String message = "Name cannot be null.";
    assertEquals(message, illegalArgumentException.getMessage());

    }
    @Test
    void ifNameEmptyThrowsException(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,() ->new Horse("", 5.0));
    }

    @Test
    void ifNameEmptyWritesMessage(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,() ->new Horse("", 5.0));
        String string =  "Name cannot be blank.";
        assertEquals(string, illegalArgumentException.getMessage());
    }

    @Test
    void ifSpeedIsNegativeTrowsException(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,() ->new Horse("inga", -5.0));
    }

    @Test
    void ifSpeedIsNegativeWritesMessage(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,() ->new Horse("inga", -5.0));
        String string =  "Speed cannot be negative.";
        assertEquals(string, illegalArgumentException.getMessage());
    }

    @Test
    void ifDistanceIsNegativeTrowsException(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,() ->new Horse("inga", 5.0, -1.0));
    }

    @Test
    void ifDistanceIsNegativeWritesMessage(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,() ->new Horse("inga", 5.0, -1.0));
        String string =  "Distance cannot be negative.";
        assertEquals(string, illegalArgumentException.getMessage());
    }

    @Test
    void getName(){
        assertEquals("inga", horse.getName());
    }

    @Test
    void getSpeed(){
        assertEquals(5.0, horse.getSpeed());
    }

    @Test
    void getDistance(){
        assertEquals(1.0,horse.getDistance());
    }

    @Test
    void getDistanceIfTwoParam(){
        assertEquals(0,hor.getDistance());
    }

    @Test
    void move(){
        try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {

            // Вызываем метод, который внутри вызывает YourStaticClass.getRandomDouble(0.2, 0.9)
            Horse instance = new Horse("inga",5.0);
            instance.move();

            // Проверяем, что статический метод вызван с нужными параметрами
            mockedStatic.verify(() ->
                    Horse.getRandomDouble(eq(0.2), eq(0.9))
            );
        }
    }



}