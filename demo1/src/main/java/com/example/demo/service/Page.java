package com.example.demo.service;

import org.springframework.core.convert.converter.Converter;

public interface  Page<T> {
    int getTotalPages();
    long getTotalElements();
    <S> Page<S> map(Converter<? super  T,? extends  S> varl);
}
//extends Slice<T>