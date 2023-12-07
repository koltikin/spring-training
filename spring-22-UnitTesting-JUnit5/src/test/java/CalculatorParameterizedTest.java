import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest {
    @ParameterizedTest
    @ValueSource(strings={"Java", "JS","TS"})
    void testCase1(String arg){
        Assertions.assertFalse(arg.isEmpty());

    }
    @ParameterizedTest
    @ValueSource(ints={2,6,9})
    void testCase2(int num){
        Assertions.assertEquals(0, num % 3);
    }
    @ParameterizedTest
    @ValueSource(strings={"Java", "JS","TS"})
    @EmptySource
    void testCase3(String args){
        Assertions.assertFalse(args.isEmpty());
    }
    @ParameterizedTest
    @ValueSource(strings={"Java", "JS","TS"})
    @NullSource
    void testCase4(String args){
        Assertions.assertFalse(args.isEmpty());
    }
    @ParameterizedTest
    @ValueSource(strings={"Java", "JS","TS"})
    @NullAndEmptySource
    void testCase5(String args){
        Assertions.assertFalse(args.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("StringProvider")
    void testCase6(String arg){
        Assertions.assertFalse(arg.isEmpty());
    }
    static String[] StringProvider(){
        return new String[]{"Java","JS","TS"};
    }

    @ParameterizedTest
    @CsvSource({
            "10,20,30",
            "5,45,50",
            "100,20,130",
    })
    void testCase7(int num1, int num2, int result){
        Assertions.assertEquals(result, Calculator.add(num1,num2));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv",numLinesToSkip = 1)
    void testCase8(int num1, int num2, int result){
        Assertions.assertEquals(result, Calculator.add(num1,num2));
    }
}
