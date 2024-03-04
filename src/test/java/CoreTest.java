import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CoreTest {

    @Test
    public void testF() throws NoSuchFieldException {
        Parser<RuntimeException> a = new Parser<>();
        a.parse(new File(""));
    }


}

interface A {
     void display();
}

interface B{

    void display();
}


class C implements A, B {

    public void display() {

    }
}

class Parser<T extends Exception> {
    public void parse(File file) throws T {     // OK
// ...
    }
}



