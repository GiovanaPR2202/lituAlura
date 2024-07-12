package com.example.litualura.service;

public interface IConverterData {
    <T> T  getData(String json, Class<T> Tclass);
}
