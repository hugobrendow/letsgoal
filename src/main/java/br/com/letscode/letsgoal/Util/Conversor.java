package br.com.letscode.letsgoal.Util;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Conversor {

    public static <T> Stream<T> iterableToStream(Iterable<T> iterable){
        // obtém o divisor do Iterable e o transforma em um fluxo sequencial
        return StreamSupport.stream(iterable.spliterator(), false);
    }

}
