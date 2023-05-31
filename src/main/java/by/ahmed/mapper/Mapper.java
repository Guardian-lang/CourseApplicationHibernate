package by.ahmed.mapper;

public interface Mapper<K, F> {
    F mapFrom(K object);
}
