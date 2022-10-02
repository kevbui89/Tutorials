package com.googleguice.annotations;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;

@BindingAnnotation
// Where the annotation can be placed, in this case, we can use it for fields, methods and parameters
@Target({ FIELD, PARAMETER, METHOD})
// Tells code if it is store in source code or at runtime
@Retention(RUNTIME)
public @interface ColorValue
{
}
