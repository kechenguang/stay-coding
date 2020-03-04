package effectiveJava.beans;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Person {


    public abstract String name();

    public abstract int age();
}
