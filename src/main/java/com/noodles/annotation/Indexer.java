package com.noodles.annotation;

import java.lang.annotation.*;

/**
 * Created by gaoxinwei on 2018/2/12.
 */
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Indexer {

    boolean required() default true;
}
