package by.Ahmed.mapper;

public interface Mapper<K, F> {
    F mapFrom(K object);
}
