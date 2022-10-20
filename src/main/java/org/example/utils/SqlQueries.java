package org.example.utils;

public final class SqlQueries {

    public static final String SELECT_ALL_USERS_TEENAGERS = """
            SELECT * FROM user WHERE age < 18
            """;

    public static final String SELECT_ALL_USERS_NAME_FINISHED_O = """
            SELECT * FROM user WHERE first_name LIKE '%o'
            """;

    public static final String SELECT_ALL_USERS_WORK_AGE = """
            SELECT * FROM user WHERE age between 18 and 60
            """;

    public static final String SELECT_ALL_USERS_NAME_WITH_A = """
            SELECT * FROM user WHERE first_name LIKE '%a%'
            """;

    public static final String SELECT_ALL_USERS_FULL_AGE = """
            SELECT * FROM user WHERE age >= 18
            """;

}
