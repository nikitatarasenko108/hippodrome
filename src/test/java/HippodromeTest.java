import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {




    @Test
    void ifNullThrowsException(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,() -> new Hippodrome(null));
    }

    @Test
    void ifNullWritesMessage(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,() -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", illegalArgumentException.getMessage());
    }

    @Test
    void ifEmptyThrowsException(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,() -> new Hippodrome(new ArrayList<>()));
    }

    @Test
    void ifEmptyWritesMessage(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,() -> new Hippodrome(new ArrayList<>()));
        assertEquals("Horses cannot be empty.", illegalArgumentException.getMessage());
    }

    @Test
    void testGetHorsesReturnsSameObjectsInSameOrder() {
        List<Horse> horses = IntStream.range(0, 30)
                .mapToObj(i -> new Horse("Horse" + i,5.1))
                .collect(Collectors.toList());

        Hippodrome hippodrome = new Hippodrome(horses);

        List<Horse> returnedHorses = hippodrome.getHorses();

        assertNotSame(horses, returnedHorses,
                "Метод getHorses должен возвращать копию списка");

        assertEquals(30, returnedHorses.size(),
                "Список должен содержать 30 лошадей");

        for (int i = 0; i < horses.size(); i++) {
            assertSame(horses.get(i), returnedHorses.get(i),
                    "Лошадь в позиции " + i + " должна быть тем же объектом");
        }

        assertIterableEquals(horses, returnedHorses,
                "Списки должны содержать те же объекты в той же последовательности");
    }

    @Test
    void testMoveCallsMoveOnAllHorses() {
        class HorseWithMoveCounter extends Horse {
            int moveCount = 0;

            public HorseWithMoveCounter() {
                super("TestHorse", 1.0, 0.0);
            }

            @Override
            public void move() {
                moveCount++;
            }
        }

        List<Horse> horses = IntStream.range(0, 50)
                .mapToObj(i -> new HorseWithMoveCounter())
                .collect(Collectors.toList());

        Hippodrome hippodrome = new Hippodrome(horses);

        hippodrome.move();

        horses.forEach(horse ->
                assertEquals(1, ((HorseWithMoveCounter) horse).moveCount)
        );
    }

    @Test
    void getWinner(){
        List<Horse> horses = new ArrayList<>();
        Horse horse = new Horse("hudey",2.7,2.1);
        Horse horse1 = new Horse("hude",2.7,2.2);
        Horse horse2 = new Horse("hudy",2.7,100.3);
        horses.add(horse);
        horses.add(horse1);
        horses.add(horse2);
        Hippodrome hippodrome = new Hippodrome(horses);

        assertSame(hippodrome.getWinner(),horse2);
    }




}